package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBShzlxqService;
import cc.mrbird.febs.heart.entity.HeartBShzlxq;

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
 * @since 2021-05-24
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBShzlxq")

public class HeartBShzlxqController extends BaseController{

private String message;
@Autowired
public IHeartBShzlxqService iHeartBShzlxqService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBShzlxq 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBShzlxq:view")
public Map<String, Object> List(QueryRequest request, HeartBShzlxq heartBShzlxq){
        return getDataTable(this.iHeartBShzlxqService.findHeartBShzlxqs(request, heartBShzlxq));
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
@RequiresPermissions("heartBShzlxq:add")
public void addHeartBShzlxq(@Valid HeartBShzlxq heartBShzlxq)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBShzlxq.setUsername(currentUser.getUsername());
        heartBShzlxq.setCreateUserId(currentUser.getUserId());
        this.iHeartBShzlxqService.createHeartBShzlxq(heartBShzlxq);
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
@RequiresPermissions("heartBShzlxq:update")
public void updateHeartBShzlxq(@Valid HeartBShzlxq heartBShzlxq)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBShzlxq.setModifyUserId(currentUser.getUserId());
        this.iHeartBShzlxqService.updateHeartBShzlxq(heartBShzlxq);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBShzlxq:delete")
public void deleteHeartBShzlxqs(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBShzlxqService.deleteHeartBShzlxqs(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBShzlxq:export")
public void export(QueryRequest request, HeartBShzlxq heartBShzlxq, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBShzlxq> heartBShzlxqs = this.iHeartBShzlxqService.findHeartBShzlxqs(request, heartBShzlxq).getRecords();
        ExcelKit.$Export(HeartBShzlxq.class, response).downXlsx(heartBShzlxqs, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBShzlxq detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBShzlxq heartBShzlxq=this.iHeartBShzlxqService.getById(id);
        return heartBShzlxq;
        }
        }