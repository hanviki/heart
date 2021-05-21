package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBCsService;
import cc.mrbird.febs.heart.entity.HeartBCs;

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
@RequestMapping("heartBCs")

public class HeartBCsController extends BaseController{

private String message;
@Autowired
public IHeartBCsService iHeartBCsService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBCs 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBCs:view")
public Map<String, Object> List(QueryRequest request, HeartBCs heartBCs){
        return getDataTable(this.iHeartBCsService.findHeartBCss(request, heartBCs));
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
@RequiresPermissions("heartBCs:add")
public void addHeartBCs(@Valid HeartBCs heartBCs)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBCs.setUsername(currentUser.getUsername());
        heartBCs.setCreateUserId(currentUser.getUserId());
        this.iHeartBCsService.createHeartBCs(heartBCs);
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
@RequiresPermissions("heartBCs:update")
public void updateHeartBCs(@Valid HeartBCs heartBCs)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBCs.setModifyUserId(currentUser.getUserId());
        this.iHeartBCsService.updateHeartBCs(heartBCs);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBCs:delete")
public void deleteHeartBCss(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBCsService.deleteHeartBCss(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBCs:export")
public void export(QueryRequest request, HeartBCs heartBCs, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBCs> heartBCss = this.iHeartBCsService.findHeartBCss(request, heartBCs).getRecords();
        ExcelKit.$Export(HeartBCs.class, response).downXlsx(heartBCss, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBCs detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBCs heartBCs=this.iHeartBCsService.getById(id);
        return heartBCs;
        }
        }