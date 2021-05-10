package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.service.IHeartBHospitalinfoService;
import cc.mrbird.febs.heart.entity.HeartBHospitalinfo;

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
@RequestMapping("heartBHospitalinfo")

public class HeartBHospitalinfoController extends BaseController{

private String message;
@Autowired
public IHeartBHospitalinfoService iHeartBHospitalinfoService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param heartBHospitalinfo 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("heartBHospitalinfo:view")
public Map<String, Object> List(QueryRequest request, HeartBHospitalinfo heartBHospitalinfo){
        return getDataTable(this.iHeartBHospitalinfoService.findHeartBHospitalinfos(request, heartBHospitalinfo));
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
@RequiresPermissions("heartBHospitalinfo:add")
public void addHeartBHospitalinfo(@Valid HeartBHospitalinfo heartBHospitalinfo)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
    heartBHospitalinfo.setUsername(currentUser.getUsername());
        heartBHospitalinfo.setCreateUserId(currentUser.getUserId());
        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
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
@RequiresPermissions("heartBHospitalinfo:update")
public void updateHeartBHospitalinfo(@Valid HeartBHospitalinfo heartBHospitalinfo)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBHospitalinfo.setModifyUserId(currentUser.getUserId());
        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBHospitalinfo:delete")
public void deleteHeartBHospitalinfos(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBHospitalinfoService.deleteHeartBHospitalinfos(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBHospitalinfo:export")
public void export(QueryRequest request, HeartBHospitalinfo heartBHospitalinfo, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBHospitalinfo> heartBHospitalinfos = this.iHeartBHospitalinfoService.findHeartBHospitalinfos(request, heartBHospitalinfo).getRecords();
        ExcelKit.$Export(HeartBHospitalinfo.class, response).downXlsx(heartBHospitalinfos, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBHospitalinfo detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBHospitalinfo heartBHospitalinfo=this.iHeartBHospitalinfoService.getById(id);
        return heartBHospitalinfo;
        }
        }