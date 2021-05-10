package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.heart.entity.*;
import cc.mrbird.febs.heart.service.*;

import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.system.domain.User;
import cn.hutool.Hutool;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
@RequestMapping("heartBPatientinfo")

public class HeartBPatientinfoController extends BaseController{

private String message;
@Autowired
public IHeartBPatientinfoService iHeartBPatientinfoService;
@Autowired
public IHeartBCheckService iHeartBCheckService;
@Autowired
public IHeartBCsfcService iHeartBCsfcService;
@Autowired
public IHeartBCsService iHeartBCsService;
@Autowired
public IHeartBCtfcService iHeartBCtfcService;
@Autowired
public  IHeartBCtoutService iHeartBCtoutService;
@Autowired
public  IHeartBCtService iHeartBCtService;
@Autowired
public IHeartBHyfcService iHeartBHyfcService;
@Autowired
public  IHeartBSurgicalafterService iHeartBSurgicalafterService;
@Autowired
public  IHeartBSurgicalService iHeartBSurgicalService;
@Autowired
public  IHeartBHospitalinfoService iHeartBHospitalinfoService;


@GetMapping
@RequiresPermissions("heartBPatientinfo:view")
public Map<String, Object> List(QueryRequest request, HeartBPatientinfo heartBPatientinfo){
        return getDataTable(this.iHeartBPatientinfoService.findHeartBPatientinfos(request, heartBPatientinfo));
        }


@Log("新增/按钮")
@PostMapping
public void addHeartBPatientinfo(@Valid String  data)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();

            JSONObject userJson = JSONObject.parseObject(data);
            CustomHeart heart = JSON.toJavaObject(userJson,CustomHeart.class);
            String fileNo ="";
            if(heart!=null){

                if(heart.getPatientInfo()!=null){
                   HeartBPatientinfo heartBPatientinfo=  heart.getPatientInfo();
                   heartBPatientinfo.setCreateUserId(currentUser.getUserId());
                   heartBPatientinfo.setUsername(currentUser.getUsername());
                    this.iHeartBPatientinfoService.createHeartBPatientinfo(heartBPatientinfo);
                    fileNo= heartBPatientinfo.getFileNo();
                }
                if(heart.getCheckInfo()!=null){
                    HeartBCheck check= heart.getCheckInfo();
                    check.setCreateUserId(currentUser.getUserId());
                    check.setUsername(currentUser.getUsername());
                    check.setFileNo(fileNo);
                    this.iHeartBCheckService.createHeartBCheck(check);
                }
                if(heart.getCsInfo()!=null){
                    HeartBCs heartBCs= heart.getCsInfo();
                    heartBCs.setCreateUserId(currentUser.getUserId());
                    heartBCs.setUsername(currentUser.getUsername());
                    heartBCs.setFileNo(fileNo);
                    this.iHeartBCsService.createHeartBCs(heartBCs);
                }
                if(heart.getCtInfo()!=null){
                    HeartBCt heartBCt= heart.getCtInfo();
                    heartBCt.setCreateUserId(currentUser.getUserId());
                    heartBCt.setUsername(currentUser.getUsername());
                    this.iHeartBCtService.createHeartBCt(heartBCt);
                }
                if(heart.getHospitalInfo()!=null){
                    HeartBHospitalinfo heartBHospitalinfo= heart.getHospitalInfo();
                    heartBHospitalinfo.setCreateUserId(currentUser.getUserId());
                    heartBHospitalinfo.setUsername(currentUser.getUsername());
                    heartBHospitalinfo.setFileNo(fileNo);
                    this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
                }
                if(heart.getOutInfo()!=null){
                    HeartBCtout heartBCtout= heart.getOutInfo();
                    heartBCtout.setCreateUserId(currentUser.getUserId());
                    heartBCtout.setUsername(currentUser.getUsername());
                    heartBCtout.setFileNo(fileNo);
                    this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
                }
                if(heart.getSurAfterInfo()!=null){
                    HeartBSurgicalafter heartBSurgicalafter= heart.getSurAfterInfo();
                    heartBSurgicalafter.setCreateUserId(currentUser.getUserId());
                    heartBSurgicalafter.setUsername(currentUser.getUsername());
                    heartBSurgicalafter.setFileNo(fileNo);
                    this.iHeartBSurgicalafterService.createHeartBSurgicalafter(heartBSurgicalafter);
                }
                if(heart.getSurgicalInfo()!=null){
                    HeartBSurgical heartBSurgical= heart.getSurgicalInfo();
                    heartBSurgical.setCreateUserId(currentUser.getUserId());
                    heartBSurgical.setUsername(currentUser.getUsername());
                    heartBSurgical.setFileNo(fileNo);
                    this.iHeartBSurgicalService.createHeartBSurgical(heartBSurgical);
                }
                if(heart.getFcctInfo()!=null){
                    List<HeartBCtfc> heartBCtfcList= heart.getFcctInfo();
                    for (HeartBCtfc item:heartBCtfcList
                         ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        this.iHeartBCtfcService.createHeartBCtfc(item);
                    }

                }
                if(heart.getFchyInfo()!=null){
                    List<HeartBHyfc> heartBHyfcList= heart.getFchyInfo();
                    for (HeartBHyfc item:heartBHyfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        this.iHeartBHyfcService.createHeartBHyfc(item);
                    }

                }
                if(heart.getFcInfo()!=null){
                    List<HeartBCsfc> heartBCsfcList= heart.getFcInfo();
                    for (HeartBCsfc item:heartBCsfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        this.iHeartBCsfcService.createHeartBCsfc(item);
                    }

                }
            }
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
@RequiresPermissions("heartBPatientinfo:update")
public void updateHeartBPatientinfo(@Valid HeartBPatientinfo heartBPatientinfo)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      heartBPatientinfo.setModifyUserId(currentUser.getUserId());
        this.iHeartBPatientinfoService.updateHeartBPatientinfo(heartBPatientinfo);
        }catch(Exception e){
        message="修改失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("heartBPatientinfo:delete")
public void deleteHeartBPatientinfos(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iHeartBPatientinfoService.deleteHeartBPatientinfos(arr_ids);
        }catch(Exception e){
        message="删除失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("heartBPatientinfo:export")
public void export(QueryRequest request, HeartBPatientinfo heartBPatientinfo, HttpServletResponse response) throws FebsException {
        try {
        List<HeartBPatientinfo> heartBPatientinfos = this.iHeartBPatientinfoService.findHeartBPatientinfos(request, heartBPatientinfo).getRecords();
        ExcelKit.$Export(HeartBPatientinfo.class, response).downXlsx(heartBPatientinfos, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public HeartBPatientinfo detail(@NotBlank(message = "{required}") @PathVariable String id) {
    HeartBPatientinfo heartBPatientinfo=this.iHeartBPatientinfoService.getById(id);
        return heartBPatientinfo;
        }
        }