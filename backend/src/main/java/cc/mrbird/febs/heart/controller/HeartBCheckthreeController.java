package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCheckthreeService;
import cc.mrbird.febs.heart.entity.HeartBCheckthree;

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
@RequestMapping("heartBCheckthree")

public class HeartBCheckthreeController extends BaseController{

private String message;
@Autowired
public IHeartBCheckthreeService iHeartBCheckthreeService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCheckthree 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCheckthree:view")
public Map<String, Object> List(QueryRequest request, HeartBCheckthree heartBCheckthree){
        return getDataTable(this.iHeartBCheckthreeService.findHeartBCheckthrees(request, heartBCheckthree));
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
@RequiresPermissions("heartBCheckthree:add")
public void addHeartBCheckthree(@Valid HeartBCheckthree heartBCheckthree)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCheckthree.setUsername(currentUser.getUsername());
        heartBCheckthree.setCreateUserId(currentUser.getUserId());
        this.iHeartBCheckthreeService.createHeartBCheckthree(heartBCheckthree);
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
@RequiresPermissions("heartBCheckthree:update")
public void updateHeartBCheckthree(@Valid HeartBCheckthree heartBCheckthree)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCheckthree.setModifyUserId(currentUser.getUserId());
        this.iHeartBCheckthreeService.updateHeartBCheckthree(heartBCheckthree);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBCheckthree:delete")
public void deleteHeartBCheckthrees(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCheckthreeService.deleteHeartBCheckthrees(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCheckthree:export")
public void export(QueryRequest request, HeartBCheckthree heartBCheckthree, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCheckthree> heartBCheckthrees = this.iHeartBCheckthreeService.findHeartBCheckthrees(request, heartBCheckthree).getRecords();
        ExcelKit.$Export(HeartBCheckthree.class, response).downXlsx(heartBCheckthrees, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCheckthree detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCheckthree heartBCheckthree=this.iHeartBCheckthreeService.getById(id);
        return heartBCheckthree;
        }
        }