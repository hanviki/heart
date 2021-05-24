package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCheckfiveService;
import cc.mrbird.febs.heart.entity.HeartBCheckfive;

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
@RequestMapping("heartBCheckfive")

public class HeartBCheckfiveController extends BaseController{

private String message;
@Autowired
public IHeartBCheckfiveService iHeartBCheckfiveService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCheckfive 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCheckfive:view")
public Map<String, Object> List(QueryRequest request, HeartBCheckfive heartBCheckfive){
        return getDataTable(this.iHeartBCheckfiveService.findHeartBCheckfives(request, heartBCheckfive));
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
@RequiresPermissions("heartBCheckfive:add")
public void addHeartBCheckfive(@Valid HeartBCheckfive heartBCheckfive)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCheckfive.setUsername(currentUser.getUsername());
        heartBCheckfive.setCreateUserId(currentUser.getUserId());
        this.iHeartBCheckfiveService.createHeartBCheckfive(heartBCheckfive);
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
@RequiresPermissions("heartBCheckfive:update")
public void updateHeartBCheckfive(@Valid HeartBCheckfive heartBCheckfive)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCheckfive.setModifyUserId(currentUser.getUserId());
        this.iHeartBCheckfiveService.updateHeartBCheckfive(heartBCheckfive);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
//@RequiresPermissions("heartBCheckfive:delete")
public void deleteHeartBCheckfives(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCheckfiveService.deleteHeartBCheckfives(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCheckfive:export")
public void export(QueryRequest request, HeartBCheckfive heartBCheckfive, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCheckfive> heartBCheckfives = this.iHeartBCheckfiveService.findHeartBCheckfives(request, heartBCheckfive).getRecords();
        ExcelKit.$Export(HeartBCheckfive.class, response).downXlsx(heartBCheckfives, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCheckfive detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCheckfive heartBCheckfive=this.iHeartBCheckfiveService.getById(id);
        return heartBCheckfive;
        }
        }