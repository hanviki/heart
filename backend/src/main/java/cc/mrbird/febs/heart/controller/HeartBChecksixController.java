package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBChecksixService;
import cc.mrbird.febs.heart.entity.HeartBChecksix;

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
 * @since 2021-06-22
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBChecksix")

public class HeartBChecksixController extends BaseController{

private String message;
@Autowired
public IHeartBChecksixService iHeartBChecksixService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBChecksix 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBChecksix:view")
public Map<String, Object> List(QueryRequest request, HeartBChecksix heartBChecksix){
        return getDataTable(this.iHeartBChecksixService.findHeartBChecksixs(request, heartBChecksix));
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
@RequiresPermissions("heartBChecksix:add")
public void addHeartBChecksix(@Valid HeartBChecksix heartBChecksix)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBChecksix.setUsername(currentUser.getUsername());
        heartBChecksix.setCreateUserId(currentUser.getUserId());
        this.iHeartBChecksixService.createHeartBChecksix(heartBChecksix);
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
@RequiresPermissions("heartBChecksix:update")
public void updateHeartBChecksix(@Valid HeartBChecksix heartBChecksix)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBChecksix.setModifyUserId(currentUser.getUserId());
        this.iHeartBChecksixService.updateHeartBChecksix(heartBChecksix);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBChecksix:delete")
public void deleteHeartBChecksixs(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBChecksixService.deleteHeartBChecksixs(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBChecksix:export")
public void export(QueryRequest request, HeartBChecksix heartBChecksix, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBChecksix> heartBChecksixs = this.iHeartBChecksixService.findHeartBChecksixs(request, heartBChecksix).getRecords();
        ExcelKit.$Export(HeartBChecksix.class, response).downXlsx(heartBChecksixs, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBChecksix detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBChecksix heartBChecksix=this.iHeartBChecksixService.getById(id);
        return heartBChecksix;
        }
        }