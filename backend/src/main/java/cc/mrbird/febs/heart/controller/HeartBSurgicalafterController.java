package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBSurgicalafterService;
import cc.mrbird.febs.heart.entity.HeartBSurgicalafter;

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
 * @since 2021-04-29
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBSurgicalafter")

public class HeartBSurgicalafterController extends BaseController{

private String message;
@Autowired
public IHeartBSurgicalafterService iHeartBSurgicalafterService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBSurgicalafter 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBSurgicalafter:view")
public Map<String, Object> List(QueryRequest request, HeartBSurgicalafter heartBSurgicalafter){
        return getDataTable(this.iHeartBSurgicalafterService.findHeartBSurgicalafters(request, heartBSurgicalafter));
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
@RequiresPermissions("heartBSurgicalafter:add")
public void addHeartBSurgicalafter(@Valid HeartBSurgicalafter heartBSurgicalafter)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBSurgicalafter.setUsername(currentUser.getUsername());
        heartBSurgicalafter.setCreateUserId(currentUser.getUserId());
        this.iHeartBSurgicalafterService.createHeartBSurgicalafter(heartBSurgicalafter);
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
@RequiresPermissions("heartBSurgicalafter:update")
public void updateHeartBSurgicalafter(@Valid HeartBSurgicalafter heartBSurgicalafter)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBSurgicalafter.setModifyUserId(currentUser.getUserId());
        this.iHeartBSurgicalafterService.updateHeartBSurgicalafter(heartBSurgicalafter);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBSurgicalafter:delete")
public void deleteHeartBSurgicalafters(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBSurgicalafterService.deleteHeartBSurgicalafters(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBSurgicalafter:export")
public void export(QueryRequest request, HeartBSurgicalafter heartBSurgicalafter, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBSurgicalafter> heartBSurgicalafters = this.iHeartBSurgicalafterService.findHeartBSurgicalafters(request, heartBSurgicalafter).getRecords();
        ExcelKit.$Export(HeartBSurgicalafter.class, response).downXlsx(heartBSurgicalafters, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBSurgicalafter detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBSurgicalafter heartBSurgicalafter=this.iHeartBSurgicalafterService.getById(id);
        return heartBSurgicalafter;
        }
        }