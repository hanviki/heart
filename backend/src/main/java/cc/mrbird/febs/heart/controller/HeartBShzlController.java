package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBShzlService;
import cc.mrbird.febs.heart.entity.HeartBShzl;

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
 * @since 2021-05-24
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBShzl")

public class HeartBShzlController extends BaseController{

private String message;
@Autowired
public IHeartBShzlService iHeartBShzlService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBShzl 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBShzl:view")
public Map<String, Object> List(QueryRequest request, HeartBShzl heartBShzl){
        return getDataTable(this.iHeartBShzlService.findHeartBShzls(request, heartBShzl));
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
@RequiresPermissions("heartBShzl:add")
public void addHeartBShzl(@Valid HeartBShzl heartBShzl)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBShzl.setUsername(currentUser.getUsername());
        heartBShzl.setCreateUserId(currentUser.getUserId());
        this.iHeartBShzlService.createHeartBShzl(heartBShzl);
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
@RequiresPermissions("heartBShzl:update")
public void updateHeartBShzl(@Valid HeartBShzl heartBShzl)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBShzl.setModifyUserId(currentUser.getUserId());
        this.iHeartBShzlService.updateHeartBShzl(heartBShzl);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBShzl:delete")
public void deleteHeartBShzls(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBShzlService.deleteHeartBShzls(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBShzl:export")
public void export(QueryRequest request, HeartBShzl heartBShzl, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBShzl> heartBShzls = this.iHeartBShzlService.findHeartBShzls(request, heartBShzl).getRecords();
        ExcelKit.$Export(HeartBShzl.class, response).downXlsx(heartBShzls, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBShzl detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBShzl heartBShzl=this.iHeartBShzlService.getById(id);
        return heartBShzl;
        }
        }