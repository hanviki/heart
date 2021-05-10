package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCtfcService;
import cc.mrbird.febs.heart.entity.HeartBCtfc;

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
@RequestMapping("heartBCtfc")

public class HeartBCtfcController extends BaseController{

private String message;
@Autowired
public IHeartBCtfcService iHeartBCtfcService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCtfc 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCtfc:view")
public Map<String, Object> List(QueryRequest request, HeartBCtfc heartBCtfc){
        return getDataTable(this.iHeartBCtfcService.findHeartBCtfcs(request, heartBCtfc));
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
@RequiresPermissions("heartBCtfc:add")
public void addHeartBCtfc(@Valid HeartBCtfc heartBCtfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCtfc.setUsername(currentUser.getUsername());
        heartBCtfc.setCreateUserId(currentUser.getUserId());
        this.iHeartBCtfcService.createHeartBCtfc(heartBCtfc);
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
@RequiresPermissions("heartBCtfc:update")
public void updateHeartBCtfc(@Valid HeartBCtfc heartBCtfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCtfc.setModifyUserId(currentUser.getUserId());
        this.iHeartBCtfcService.updateHeartBCtfc(heartBCtfc);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBCtfc:delete")
public void deleteHeartBCtfcs(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCtfcService.deleteHeartBCtfcs(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCtfc:export")
public void export(QueryRequest request, HeartBCtfc heartBCtfc, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCtfc> heartBCtfcs = this.iHeartBCtfcService.findHeartBCtfcs(request, heartBCtfc).getRecords();
        ExcelKit.$Export(HeartBCtfc.class, response).downXlsx(heartBCtfcs, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCtfc detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCtfc heartBCtfc=this.iHeartBCtfcService.getById(id);
        return heartBCtfc;
        }
        }