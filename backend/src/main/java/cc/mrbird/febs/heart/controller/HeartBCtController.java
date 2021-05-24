package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCtService;
import cc.mrbird.febs.heart.entity.HeartBCt;

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
@RequestMapping("heartBCt")

public class HeartBCtController extends BaseController{

private String message;
@Autowired
public IHeartBCtService iHeartBCtService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCt 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCt:view")
public Map<String, Object> List(QueryRequest request, HeartBCt heartBCt){
        return getDataTable(this.iHeartBCtService.findHeartBCts(request, heartBCt));
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
@RequiresPermissions("heartBCt:add")
public void addHeartBCt(@Valid HeartBCt heartBCt)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCt.setUsername(currentUser.getUsername());
        heartBCt.setCreateUserId(currentUser.getUserId());
        this.iHeartBCtService.createHeartBCt(heartBCt);
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
@RequiresPermissions("heartBCt:update")
public void updateHeartBCt(@Valid HeartBCt heartBCt)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCt.setModifyUserId(currentUser.getUserId());
        this.iHeartBCtService.updateHeartBCt(heartBCt);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
//@RequiresPermissions("heartBCt:delete")
public void deleteHeartBCts(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCtService.deleteHeartBCts(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCt:export")
public void export(QueryRequest request, HeartBCt heartBCt, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCt> heartBCts = this.iHeartBCtService.findHeartBCts(request, heartBCt).getRecords();
        ExcelKit.$Export(HeartBCt.class, response).downXlsx(heartBCts, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCt detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCt heartBCt=this.iHeartBCtService.getById(id);
        return heartBCt;
        }
        }