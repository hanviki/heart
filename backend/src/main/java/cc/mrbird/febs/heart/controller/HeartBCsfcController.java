package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCsfcService;
import cc.mrbird.febs.heart.entity.HeartBCsfc;

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
@RequestMapping("heartBCsfc")

public class HeartBCsfcController extends BaseController{

private String message;
@Autowired
public IHeartBCsfcService iHeartBCsfcService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCsfc 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCsfc:view")
public Map<String, Object> List(QueryRequest request, HeartBCsfc heartBCsfc){
        return getDataTable(this.iHeartBCsfcService.findHeartBCsfcs(request, heartBCsfc));
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
@RequiresPermissions("heartBCsfc:add")
public void addHeartBCsfc(@Valid HeartBCsfc heartBCsfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCsfc.setUsername(currentUser.getUsername());
        heartBCsfc.setCreateUserId(currentUser.getUserId());
        this.iHeartBCsfcService.createHeartBCsfc(heartBCsfc);
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
@RequiresPermissions("heartBCsfc:update")
public void updateHeartBCsfc(@Valid HeartBCsfc heartBCsfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCsfc.setModifyUserId(currentUser.getUserId());
        this.iHeartBCsfcService.updateHeartBCsfc(heartBCsfc);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBCsfc:delete")
public void deleteHeartBCsfcs(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCsfcService.deleteHeartBCsfcs(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCsfc:export")
public void export(QueryRequest request, HeartBCsfc heartBCsfc, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCsfc> heartBCsfcs = this.iHeartBCsfcService.findHeartBCsfcs(request, heartBCsfc).getRecords();
        ExcelKit.$Export(HeartBCsfc.class, response).downXlsx(heartBCsfcs, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCsfc detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCsfc heartBCsfc=this.iHeartBCsfcService.getById(id);
        return heartBCsfc;
        }
        }