package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCheckService;
import cc.mrbird.febs.heart.entity.HeartBCheck;

import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.system.domain.User;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author viki
 * @since 2021-05-21
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBCheck")

public class HeartBCheckController extends BaseController{

private String message;
@Autowired
public IHeartBCheckService iHeartBCheckService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCheck 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCheck:view")
public Map<String, Object> List(QueryRequest request, HeartBCheck heartBCheck){
        return getDataTable(this.iHeartBCheckService.findHeartBChecks(request, heartBCheck));
        }

/**
 * 跳转添加页面
 * @param request
 * @param response
 * @param model
 * @return
 */
@Log("新增/按钮")
@PostMapping
@RequiresPermissions("heartBCheck:add")
public void addHeartBCheck(@Valid HeartBCheck heartBCheck)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCheck.setUsername(currentUser.getUsername());
        heartBCheck.setCreateUserId(currentUser.getUserId());
        this.iHeartBCheckService.createHeartBCheck(heartBCheck);
        }catch(Exception e){
        message="新增/按钮失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@Log("修改")
@PutMapping
@RequiresPermissions("heartBCheck:update")
public void updateHeartBCheck(@Valid HeartBCheck heartBCheck)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCheck.setModifyUserId(currentUser.getUserId());
        this.iHeartBCheckService.updateHeartBCheck(heartBCheck);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
//@RequiresPermissions("heartBCheck:delete")
public void deleteHeartBChecks(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCheckService.deleteHeartBChecks(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCheck:export")
public void export(QueryRequest request, HeartBCheck heartBCheck, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCheck> heartBChecks = this.iHeartBCheckService.findHeartBChecks(request, heartBCheck).getRecords();
        ExcelKit.$Export(HeartBCheck.class, response).downXlsx(heartBChecks, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCheck detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCheck heartBCheck=this.iHeartBCheckService.getById(id);
        return heartBCheck;
        }
        }