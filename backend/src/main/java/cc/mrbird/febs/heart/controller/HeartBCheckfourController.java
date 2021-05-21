package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCheckfourService;
import cc.mrbird.febs.heart.entity.HeartBCheckfour;

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
@RequestMapping("heartBCheckfour")

public class HeartBCheckfourController extends BaseController{

private String message;
@Autowired
public IHeartBCheckfourService iHeartBCheckfourService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCheckfour 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCheckfour:view")
public Map<String, Object> List(QueryRequest request, HeartBCheckfour heartBCheckfour){
        return getDataTable(this.iHeartBCheckfourService.findHeartBCheckfours(request, heartBCheckfour));
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
@RequiresPermissions("heartBCheckfour:add")
public void addHeartBCheckfour(@Valid HeartBCheckfour heartBCheckfour)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCheckfour.setUsername(currentUser.getUsername());
        heartBCheckfour.setCreateUserId(currentUser.getUserId());
        this.iHeartBCheckfourService.createHeartBCheckfour(heartBCheckfour);
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
@RequiresPermissions("heartBCheckfour:update")
public void updateHeartBCheckfour(@Valid HeartBCheckfour heartBCheckfour)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCheckfour.setModifyUserId(currentUser.getUserId());
        this.iHeartBCheckfourService.updateHeartBCheckfour(heartBCheckfour);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBCheckfour:delete")
public void deleteHeartBCheckfours(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCheckfourService.deleteHeartBCheckfours(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCheckfour:export")
public void export(QueryRequest request, HeartBCheckfour heartBCheckfour, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCheckfour> heartBCheckfours = this.iHeartBCheckfourService.findHeartBCheckfours(request, heartBCheckfour).getRecords();
        ExcelKit.$Export(HeartBCheckfour.class, response).downXlsx(heartBCheckfours, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCheckfour detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCheckfour heartBCheckfour=this.iHeartBCheckfourService.getById(id);
        return heartBCheckfour;
        }
        }