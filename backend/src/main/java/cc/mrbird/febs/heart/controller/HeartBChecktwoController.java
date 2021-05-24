package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBChecktwoService;
import cc.mrbird.febs.heart.entity.HeartBChecktwo;

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
@RequestMapping("heartBChecktwo")

public class HeartBChecktwoController extends BaseController{

private String message;
@Autowired
public IHeartBChecktwoService iHeartBChecktwoService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBChecktwo 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBChecktwo:view")
public Map<String, Object> List(QueryRequest request, HeartBChecktwo heartBChecktwo){
        return getDataTable(this.iHeartBChecktwoService.findHeartBChecktwos(request, heartBChecktwo));
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
@RequiresPermissions("heartBChecktwo:add")
public void addHeartBChecktwo(@Valid HeartBChecktwo heartBChecktwo)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBChecktwo.setUsername(currentUser.getUsername());
        heartBChecktwo.setCreateUserId(currentUser.getUserId());
        this.iHeartBChecktwoService.createHeartBChecktwo(heartBChecktwo);
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
@RequiresPermissions("heartBChecktwo:update")
public void updateHeartBChecktwo(@Valid HeartBChecktwo heartBChecktwo)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBChecktwo.setModifyUserId(currentUser.getUserId());
        this.iHeartBChecktwoService.updateHeartBChecktwo(heartBChecktwo);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
//@RequiresPermissions("heartBChecktwo:delete")
public void deleteHeartBChecktwos(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBChecktwoService.deleteHeartBChecktwos(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBChecktwo:export")
public void export(QueryRequest request, HeartBChecktwo heartBChecktwo, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBChecktwo> heartBChecktwos = this.iHeartBChecktwoService.findHeartBChecktwos(request, heartBChecktwo).getRecords();
        ExcelKit.$Export(HeartBChecktwo.class, response).downXlsx(heartBChecktwos, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBChecktwo detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBChecktwo heartBChecktwo=this.iHeartBChecktwoService.getById(id);
        return heartBChecktwo;
        }
        }