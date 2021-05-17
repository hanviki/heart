package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCtoutService;
import cc.mrbird.febs.heart.entity.HeartBCtout;

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
@RequestMapping("heartBCtout")

public class HeartBCtoutController extends BaseController{

private String message;
@Autowired
public IHeartBCtoutService iHeartBCtoutService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCtout 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCtout:view")
public Map<String, Object> List(QueryRequest request, HeartBCtout heartBCtout){
        return getDataTable(this.iHeartBCtoutService.findHeartBCtouts(request, heartBCtout));
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
public void addHeartBCtout(@Valid HeartBCtout heartBCtout)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCtout.setUsername(currentUser.getUsername());
        heartBCtout.setCreateUserId(currentUser.getUserId());
        this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
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
public void updateHeartBCtout(@Valid HeartBCtout heartBCtout)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCtout.setModifyUserId(currentUser.getUserId());
        this.iHeartBCtoutService.updateHeartBCtout(heartBCtout);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
public void deleteHeartBCtouts(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCtoutService.deleteHeartBCtouts(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCtout:export")
public void export(QueryRequest request, HeartBCtout heartBCtout, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCtout> heartBCtouts = this.iHeartBCtoutService.findHeartBCtouts(request, heartBCtout).getRecords();
        ExcelKit.$Export(HeartBCtout.class, response).downXlsx(heartBCtouts, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCtout detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCtout heartBCtout=this.iHeartBCtoutService.getById(id);
        return heartBCtout;
        }
        }