package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.MD5Util;
import cc.mrbird.febs.common.utils.WxMessage;
import cc.mrbird.febs.scm.entity.ScmBUserandarea;
import cc.mrbird.febs.scm.entity.ScmDArea;
import cc.mrbird.febs.scm.service.IScmBUserandareaService;
import cc.mrbird.febs.scm.service.impl.ScmBUserandareaServiceImpl;
import cc.mrbird.febs.system.domain.Role;
import cc.mrbird.febs.system.domain.User;
import cc.mrbird.febs.system.domain.UserConfig;
import cc.mrbird.febs.system.service.RoleService;
import cc.mrbird.febs.system.service.UserConfigService;
import cc.mrbird.febs.system.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private String message;

    @Autowired
    private UserService userService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private IScmBUserandareaService areaService;

    @GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.userService.findByName(username) == null;
    }

    @GetMapping("/{username}")
    public User detail(@NotBlank(message = "{required}") @PathVariable String username) {
        User user=this.userService.findByName(username);
        //??????????????????????????????????????????????????????roleId????????????
        List<Role> roles=roleService.findUserRole(username);
        List<Long> roleIds=roles.stream().map(role ->role.getRoleId()).collect(Collectors.toList());
        String roleIdStr=StringUtils.join(roleIds.toArray(new Long[roleIds.size()]),",");
        user.setRoleId(roleIdStr);
        return user;
    }

    @GetMapping
    @RequiresPermissions("user:view")
    public Map<String, Object> userList(QueryRequest queryRequest, User user) {
        return getDataTable(userService.findUserDetail(user, queryRequest));
    }

    @GetMapping("area/{userId}")
    public List<String> getRoleMenus(@NotBlank(message = "{required}") @PathVariable String userId) {
        List<ScmBUserandarea> list = this.areaService.getAreaByUserId(userId);
        return list.stream().map(area -> String.valueOf(area.getAreaID())).collect(Collectors.toList());
    }

    @Log("????????????")
    @PostMapping
    @RequiresPermissions("user:add")
    public void addUser(@Valid User user) throws FebsException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            message = "??????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("????????????")
    @PutMapping
    @RequiresPermissions("user:update")
    public void updateUser(@Valid User user) throws FebsException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            message = "??????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("????????????")
    @DeleteMapping("/{userIds}")
    @RequiresPermissions("user:delete")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws FebsException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            message = "??????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping("profile")
    public void updateProfile(@Valid User user) throws FebsException {
        try {
            this.userService.updateProfile(user);
        } catch (Exception e) {
            message = "????????????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping("avatar")
    public void updateAvatar(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String avatar) throws FebsException {
        try {
            this.userService.updateAvatar(username, avatar);
        } catch (Exception e) {
            message = "??????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping("userconfig")
    public void updateUserConfig(@Valid UserConfig userConfig) throws FebsException {
        try {
            this.userConfigService.update(userConfig);
        } catch (Exception e) {
            message = "???????????????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping("password/check")
    public boolean checkPassword(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) {
        String encryptPassword = MD5Util.encrypt(username, password);
        User user = userService.findByName(username);
        if (user != null)
            return StringUtils.equals(user.getPassword(), encryptPassword);
        else
            return false;
    }

    @PutMapping("password")
    public void updatePassword(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws FebsException {
        try {
            message="";
            if(!HasDigit(password) || !judgeContainsStr(password) ||!judgeContainsSpecialStr(password) || password.trim().length()<8){
                throw new FebsException("??????8???????????????????????????????????????(@$%!+-)");
            }
            userService.updatePassword(username, password);
        } catch (Exception e) {
            message = "??????????????????,????????????8???????????????????????????????????????(@$%!+-)";
            log.error(message, e);
            throw new FebsException(e.getMessage());
        }
    }

    private boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
    public boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m=Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }
    public boolean judgeContainsSpecialStr(String cardNum) {
        String regex=".*[@$%#_+*/!]+.*";
        Matcher m=Pattern.compile(regex).matcher(cardNum);
        return m.matches();
}
    @PutMapping("password/reset")
    @RequiresPermissions("user:reset")
    public void resetPassword(@NotBlank(message = "{required}") String usernames) throws FebsException {
        try {
            String[] usernameArr = usernames.split(StringPool.COMMA);
            this.userService.resetPassword(usernameArr);
        } catch (Exception e) {
            message = "????????????????????????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("user:export")
    public void export(QueryRequest queryRequest, User user, HttpServletResponse response) throws FebsException {
        try {
            List<User> users = this.userService.findUserDetail(user, queryRequest).getRecords();
            ExcelKit.$Export(User.class, response).downXlsx(users, false);
        } catch (Exception e) {
            message = "??????Excel??????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    @PutMapping("bindweixin")
    public void updateOpenid(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String openid) throws FebsException {
        try {
            log.info("openid:"+openid);
           // WxMessage wm=new WxMessage();

           // log.info("openid:"+openidS);
            userService.updateOpenid(username,openid );
        } catch (Exception e) {
            message = "??????????????????ID??????";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
