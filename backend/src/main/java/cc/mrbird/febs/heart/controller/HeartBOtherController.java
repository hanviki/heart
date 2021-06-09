package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBOtherService;
import cc.mrbird.febs.heart.entity.HeartBOther;

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
 * @since 2021-06-07
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBOther")

public class HeartBOtherController extends BaseController{

private String message;
@Autowired
public IHeartBOtherService iHeartBOtherService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBOther 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBOther:view")
public Map<String, Object> List(QueryRequest request, HeartBOther heartBOther){
        return getDataTable(this.iHeartBOtherService.findHeartBOthers(request, heartBOther));
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
@RequiresPermissions("heartBOther:add")
public void addHeartBOther(@Valid HeartBOther heartBOther)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBOther.setUsername(currentUser.getUsername());
        heartBOther.setCreateUserId(currentUser.getUserId());
        this.iHeartBOtherService.createHeartBOther(heartBOther);
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
@RequiresPermissions("heartBOther:update")
public void updateHeartBOther(@Valid HeartBOther heartBOther)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBOther.setModifyUserId(currentUser.getUserId());
        this.iHeartBOtherService.updateHeartBOther(heartBOther);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
public void deleteHeartBOthers(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBOtherService.deleteHeartBOthers(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBOther:export")
public void export(QueryRequest request, HeartBOther heartBOther, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBOther> heartBOthers = this.iHeartBOtherService.findHeartBOthers(request, heartBOther).getRecords();
        ExcelKit.$Export(HeartBOther.class, response).downXlsx(heartBOthers, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBOther detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBOther heartBOther=this.iHeartBOtherService.getById(id);
        return heartBOther;
        }
        }