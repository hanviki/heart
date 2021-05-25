package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBSqzlService;
import cc.mrbird.febs.heart.entity.HeartBSqzl;

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
@RequestMapping("heartBSqzl")

public class HeartBSqzlController extends BaseController{

private String message;
@Autowired
public IHeartBSqzlService iHeartBSqzlService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBSqzl 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBSqzl:view")
public Map<String, Object> List(QueryRequest request, HeartBSqzl heartBSqzl){
        return getDataTable(this.iHeartBSqzlService.findHeartBSqzls(request, heartBSqzl));
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
@RequiresPermissions("heartBSqzl:add")
public void addHeartBSqzl(@Valid HeartBSqzl heartBSqzl)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBSqzl.setUsername(currentUser.getUsername());
        heartBSqzl.setCreateUserId(currentUser.getUserId());
        this.iHeartBSqzlService.createHeartBSqzl(heartBSqzl);
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
@RequiresPermissions("heartBSqzl:update")
public void updateHeartBSqzl(@Valid HeartBSqzl heartBSqzl)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBSqzl.setModifyUserId(currentUser.getUserId());
        this.iHeartBSqzlService.updateHeartBSqzl(heartBSqzl);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBSqzl:delete")
public void deleteHeartBSqzls(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBSqzlService.deleteHeartBSqzls(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBSqzl:export")
public void export(QueryRequest request, HeartBSqzl heartBSqzl, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBSqzl> heartBSqzls = this.iHeartBSqzlService.findHeartBSqzls(request, heartBSqzl).getRecords();
        ExcelKit.$Export(HeartBSqzl.class, response).downXlsx(heartBSqzls, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBSqzl detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBSqzl heartBSqzl=this.iHeartBSqzlService.getById(id);
        return heartBSqzl;
        }
        }