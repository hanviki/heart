package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBHyfcService;
import cc.mrbird.febs.heart.entity.HeartBHyfc;

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
@RequestMapping("heartBHyfc")

public class HeartBHyfcController extends BaseController{

private String message;
@Autowired
public IHeartBHyfcService iHeartBHyfcService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBHyfc 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBHyfc:view")
public Map<String, Object> List(QueryRequest request, HeartBHyfc heartBHyfc){
        return getDataTable(this.iHeartBHyfcService.findHeartBHyfcs(request, heartBHyfc));
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
public void addHeartBHyfc(@Valid HeartBHyfc heartBHyfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBHyfc.setUsername(currentUser.getUsername());
        heartBHyfc.setCreateUserId(currentUser.getUserId());
        this.iHeartBHyfcService.createHeartBHyfc(heartBHyfc);
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
public void updateHeartBHyfc(@Valid HeartBHyfc heartBHyfc)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBHyfc.setModifyUserId(currentUser.getUserId());
        this.iHeartBHyfcService.updateHeartBHyfc(heartBHyfc);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
public void deleteHeartBHyfcs(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBHyfcService.deleteHeartBHyfcs(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBHyfc:export")
public void export(QueryRequest request, HeartBHyfc heartBHyfc, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBHyfc> heartBHyfcs = this.iHeartBHyfcService.findHeartBHyfcs(request, heartBHyfc).getRecords();
        ExcelKit.$Export(HeartBHyfc.class, response).downXlsx(heartBHyfcs, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBHyfc detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBHyfc heartBHyfc=this.iHeartBHyfcService.getById(id);
        return heartBHyfc;
        }
        }