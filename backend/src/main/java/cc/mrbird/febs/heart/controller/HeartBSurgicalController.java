package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBSurgicalService;
import cc.mrbird.febs.heart.entity.HeartBSurgical;

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
 * @since 2021-05-06
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBSurgical")

public class HeartBSurgicalController extends BaseController{

private String message;
@Autowired
public IHeartBSurgicalService iHeartBSurgicalService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBSurgical 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBSurgical:view")
public Map<String, Object> List(QueryRequest request, HeartBSurgical heartBSurgical){
        return getDataTable(this.iHeartBSurgicalService.findHeartBSurgicals(request, heartBSurgical));
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
public void addHeartBSurgical(@Valid HeartBSurgical heartBSurgical)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBSurgical.setUsername(currentUser.getUsername());
        heartBSurgical.setCreateUserId(currentUser.getUserId());
        this.iHeartBSurgicalService.createHeartBSurgical(heartBSurgical);
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
public void updateHeartBSurgical(@Valid HeartBSurgical heartBSurgical)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBSurgical.setModifyUserId(currentUser.getUserId());
        this.iHeartBSurgicalService.updateHeartBSurgical(heartBSurgical);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
public void deleteHeartBSurgicals(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBSurgicalService.deleteHeartBSurgicals(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBSurgical:export")
public void export(QueryRequest request, HeartBSurgical heartBSurgical, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBSurgical> heartBSurgicals = this.iHeartBSurgicalService.findHeartBSurgicals(request, heartBSurgical).getRecords();
        ExcelKit.$Export(HeartBSurgical.class, response).downXlsx(heartBSurgicals, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBSurgical detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBSurgical heartBSurgical=this.iHeartBSurgicalService.getById(id);
        return heartBSurgical;
        }
        }