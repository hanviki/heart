package cc.mrbird.febs.heart.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.FebsResponse;
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
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author viki
 * @since 2021-04-29
 */
@Slf4j
@Validated
@RestController
@RequestMapping("heartBPatientinfo")

public class HeartBPatientinfoController extends BaseController {

    private String message;
    @Autowired
    public IHeartBPatientinfoService iHeartBPatientinfoService;
    @Autowired
    public IHeartBCheckService iHeartBCheckService;
    @Autowired
    public IHeartBChecktwoService iHeartBChecktwoService;
    @Autowired
    public IHeartBCheckthreeService iHeartBCheckthreeService;
    @Autowired
    public IHeartBCheckfourService iHeartBCheckfourService;
    @Autowired
    public IHeartBCheckfiveService iHeartBCheckfiveService;
    @Autowired
    public IHeartBCsfcService iHeartBCsfcService;
    @Autowired
    public IHeartBCsService iHeartBCsService;
    @Autowired
    public IHeartBCtfcService iHeartBCtfcService;
    @Autowired
    public IHeartBCtoutService iHeartBCtoutService;
    @Autowired
    public IHeartBCtService iHeartBCtService;
    @Autowired
    public IHeartBHyfcService iHeartBHyfcService;
    @Autowired
    public IHeartBSurgicalafterService iHeartBSurgicalafterService;
    @Autowired
    public IHeartBSurgicalService iHeartBSurgicalService;
    @Autowired
    public IHeartBHospitalinfoService iHeartBHospitalinfoService;


    @GetMapping
    @RequiresPermissions("heartBPatientinfo:view")
    public Map<String, Object> List(QueryRequest request, HeartBPatientinfo heartBPatientinfo) {
        User currentUser = FebsUtil.getCurrentUser();
        heartBPatientinfo.setUsername(currentUser.getUsername());
        return getDataTable(this.iHeartBPatientinfoService.findHeartBPatientinfos(request, heartBPatientinfo));
    }

    @GetMapping("dept")
    public Map<String, Object> ListDept(QueryRequest request, HeartBPatientinfo heartBPatientinfo) {
        User currentUser = FebsUtil.getCurrentUser();
        heartBPatientinfo.setUsername(currentUser.getUsername());
        return getDataTable(this.iHeartBPatientinfoService.findHeartBPatientinfosDept(request, heartBPatientinfo, currentUser.getUserId().toString()));
    }

    @GetMapping("check/{fileno}")
    public boolean checkfileNo(@NotBlank(message = "{required}") @PathVariable String fileno, String id) {
        LambdaQueryWrapper<HeartBPatientinfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HeartBPatientinfo::getFileNo, fileno);
        if (StringUtils.isNotBlank(id)) {
            queryWrapper.ne(HeartBPatientinfo::getId, id);
        }
        int count = this.iHeartBPatientinfoService.count(queryWrapper);
        return count == 0 ? true : false;
    }

    @GetMapping("all")
    public FebsResponse ListAll(QueryRequest request, String fileNo) {
        LambdaQueryWrapper<HeartBPatientinfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HeartBPatientinfo::getFileNo, fileNo);
        queryWrapper.eq(HeartBPatientinfo::getIsDeletemark, 1);
        HeartBPatientinfo heartBPatientinfo = this.iHeartBPatientinfoService.getOne(queryWrapper);

        LambdaQueryWrapper<HeartBCheck> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(HeartBCheck::getFileNo, fileNo);
        queryWrapper2.eq(HeartBCheck::getIsDeletemark, 1);
        List<HeartBCheck> checkInfo = this.iHeartBCheckService.list(queryWrapper2);

        LambdaQueryWrapper<HeartBChecktwo> queryWrapper22 = new LambdaQueryWrapper<>();
        queryWrapper22.eq(HeartBChecktwo::getFileNo, fileNo);
        queryWrapper22.eq(HeartBChecktwo::getIsDeletemark, 1);
        List<HeartBChecktwo> checkTwoInfo = this.iHeartBChecktwoService.list(queryWrapper22);

        LambdaQueryWrapper<HeartBCheckthree> queryWrapper23 = new LambdaQueryWrapper<>();
        queryWrapper23.eq(HeartBCheckthree::getFileNo, fileNo);
        queryWrapper23.eq(HeartBCheckthree::getIsDeletemark, 1);
        List<HeartBCheckthree> checkThreeInfo = this.iHeartBCheckthreeService.list(queryWrapper23);

        LambdaQueryWrapper<HeartBCheckfour> queryWrapper24 = new LambdaQueryWrapper<>();
        queryWrapper24.eq(HeartBCheckfour::getFileNo, fileNo);
        queryWrapper24.eq(HeartBCheckfour::getIsDeletemark, 1);
        List<HeartBCheckfour> checkFourInfo = this.iHeartBCheckfourService.list(queryWrapper24);

        LambdaQueryWrapper<HeartBCheckfive> queryWrapper25 = new LambdaQueryWrapper<>();
        queryWrapper25.eq(HeartBCheckfive::getFileNo, fileNo);
        queryWrapper25.eq(HeartBCheckfive::getIsDeletemark, 1);
        List<HeartBCheckfive> checkFiveInfo = this.iHeartBCheckfiveService.list(queryWrapper25);


        LambdaQueryWrapper<HeartBCs> queryWrapper3 = new LambdaQueryWrapper<>();
        queryWrapper3.eq(HeartBCs::getIsDeletemark, 1);
        queryWrapper3.eq(HeartBCs::getFileNo, fileNo);
        List<HeartBCs> csInfo = this.iHeartBCsService.list(queryWrapper3);


        LambdaQueryWrapper<HeartBCt> queryWrapper5 = new LambdaQueryWrapper<>();
        queryWrapper5.eq(HeartBCt::getIsDeletemark, 1);
        queryWrapper5.eq(HeartBCt::getFileNo, fileNo);
        List<HeartBCt> ctInfo = this.iHeartBCtService.list(queryWrapper5);

        LambdaQueryWrapper<HeartBCtout> queryWrapper6 = new LambdaQueryWrapper<>();
        queryWrapper6.eq(HeartBCtout::getFileNo, fileNo);
        queryWrapper6.eq(HeartBCtout::getIsDeletemark, 1);
        HeartBCtout ctOutInfo = this.iHeartBCtoutService.getOne(queryWrapper6);

        LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper7 = new LambdaQueryWrapper<>();
        queryWrapper7.eq(HeartBHospitalinfo::getFileNo, fileNo);
        queryWrapper7.eq(HeartBHospitalinfo::getIsDeletemark, 1);
        HeartBHospitalinfo hospitalinfo = this.iHeartBHospitalinfoService.getOne(queryWrapper7);


        LambdaQueryWrapper<HeartBSurgicalafter> queryWrapper8 = new LambdaQueryWrapper<>();
        queryWrapper8.eq(HeartBSurgicalafter::getFileNo, fileNo);
        queryWrapper8.eq(HeartBSurgicalafter::getIsDeletemark, 1);
        HeartBSurgicalafter heartBSurgicalafter = this.iHeartBSurgicalafterService.getOne(queryWrapper8);

        LambdaQueryWrapper<HeartBSurgical> queryWrapper9 = new LambdaQueryWrapper<>();
        queryWrapper9.eq(HeartBSurgical::getFileNo, fileNo);
        queryWrapper9.eq(HeartBSurgical::getIsDeletemark, 1);
        HeartBSurgical heartBSurgical = this.iHeartBSurgicalService.getOne(queryWrapper9);

        LambdaQueryWrapper<HeartBCsfc> queryWrapper4 = new LambdaQueryWrapper<>();
        queryWrapper4.eq(HeartBCsfc::getFileNo, fileNo);
        queryWrapper4.eq(HeartBCsfc::getIsDeletemark, 1);
        List<HeartBCsfc> csfcList = this.iHeartBCsfcService.list(queryWrapper4);


        LambdaQueryWrapper<HeartBCtfc> queryWrapper10 = new LambdaQueryWrapper<>();
        queryWrapper10.eq(HeartBCtfc::getFileNo, fileNo);
        queryWrapper10.eq(HeartBCtfc::getIsDeletemark, 1);
        List<HeartBCtfc> ctfcList = this.iHeartBCtfcService.list(queryWrapper10);

        LambdaQueryWrapper<HeartBHyfc> queryWrapper11 = new LambdaQueryWrapper<>();
        queryWrapper11.eq(HeartBHyfc::getFileNo, fileNo);
        queryWrapper11.eq(HeartBHyfc::getIsDeletemark, 1);
        List<HeartBHyfc> heartBHyfcList = this.iHeartBHyfcService.list(queryWrapper11);

        CustomHeart heart = new CustomHeart();
        heart.setCheckInfo(checkInfo);
        heart.setCheckTwoInfo(checkTwoInfo);
        heart.setCheckThreeInfo(checkThreeInfo);
        heart.setCheckFourInfo(checkFourInfo);
        heart.setCheckFiveInfo(checkFiveInfo);
        heart.setCsInfo(csInfo);
        heart.setCtInfo(ctInfo);
        heart.setFcctInfo(ctfcList);
        heart.setFcInfo(csfcList);
        heart.setHospitalInfo(hospitalinfo);
        heart.setSurAfterInfo(heartBSurgicalafter);
        heart.setSurgicalInfo(heartBSurgical);
        heart.setOutInfo(ctOutInfo);
        heart.setFchyInfo(heartBHyfcList);
        heart.setPatientInfo(heartBPatientinfo);

        return new FebsResponse().data(heart);
    }


    @Log("新增/按钮")
    @PostMapping
    @Transactional
    public void addHeartBPatientinfo(@Valid String data) throws FebsException {
        try {
            User currentUser = FebsUtil.getCurrentUser();

            JSONObject userJson = JSONObject.parseObject(data);
            CustomHeart heart = JSON.toJavaObject(userJson, CustomHeart.class);

            String fileNo = "";
            String name = "";
            if (heart != null) {
                if (heart.getPatientInfo() != null) {
                    HeartBPatientinfo heartBPatientinfo = heart.getPatientInfo();

                    LambdaQueryWrapper<HeartBPatientinfo> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(HeartBPatientinfo::getFileNo, heartBPatientinfo.getFileNo());
                    int count = this.iHeartBPatientinfoService.count(queryWrapper);
                    if (count > 0) {
                        throw new FebsException("存在重复的档案号,请重新填写档案号");
                    }

                    heartBPatientinfo.setCreateUserId(currentUser.getUserId());
                    heartBPatientinfo.setUsername(currentUser.getUsername());
                    this.iHeartBPatientinfoService.createHeartBPatientinfo(heartBPatientinfo);
                    fileNo = heartBPatientinfo.getFileNo();
                    name = heartBPatientinfo.getName();
                }

                if (heart.getCheckInfo() != null) {
                    List<HeartBCheck> heartBCheckList = heart.getCheckInfo();
                    for (HeartBCheck check : heartBCheckList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        this.iHeartBCheckService.createHeartBCheck(check);
                    }

                }
                if (heart.getCheckTwoInfo() != null) {
                    List<HeartBChecktwo> heartBChecktwoList = heart.getCheckTwoInfo();
                    for (HeartBChecktwo check : heartBChecktwoList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        this.iHeartBChecktwoService.createHeartBChecktwo(check);
                    }

                }
                if (heart.getCheckThreeInfo() != null) {
                    List<HeartBCheckthree> heartBCheckthreeList = heart.getCheckThreeInfo();
                    for (HeartBCheckthree check : heartBCheckthreeList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        this.iHeartBCheckthreeService.createHeartBCheckthree(check);
                    }

                }
                if (heart.getCheckFourInfo() != null) {
                    List<HeartBCheckfour> heartBCheckfourList = heart.getCheckFourInfo();
                    for (HeartBCheckfour check : heartBCheckfourList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        this.iHeartBCheckfourService.createHeartBCheckfour(check);
                    }

                }
                if (heart.getCheckFiveInfo() != null) {
                    List<HeartBCheckfive> heartBCheckfiveList = heart.getCheckFiveInfo();
                    for (HeartBCheckfive check : heartBCheckfiveList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        this.iHeartBCheckfiveService.createHeartBCheckfive(check);
                    }

                }
                if (heart.getCsInfo() != null) {
                    List<HeartBCs> heartBCsList = heart.getCsInfo();
                    for (HeartBCs heartBCs : heartBCsList
                    ) {
                        heartBCs.setCreateUserId(currentUser.getUserId());
                        heartBCs.setUsername(currentUser.getUsername());
                        heartBCs.setFileNo(fileNo);
                        heartBCs.setName(name);
                        this.iHeartBCsService.createHeartBCs(heartBCs);
                    }

                }
                if (heart.getCtInfo() != null) {
                    List<HeartBCt> heartBCtList = heart.getCtInfo();
                    for (HeartBCt heartBCt : heartBCtList
                    ) {
                        heartBCt.setCreateUserId(currentUser.getUserId());
                        heartBCt.setUsername(currentUser.getUsername());
                        heartBCt.setFileNo(fileNo);
                        heartBCt.setName(name);
                        this.iHeartBCtService.createHeartBCt(heartBCt);
                    }

                }


                if (heart.getHospitalInfo() != null) {
                    HeartBHospitalinfo heartBHospitalinfo = heart.getHospitalInfo();
                    heartBHospitalinfo.setCreateUserId(currentUser.getUserId());
                    heartBHospitalinfo.setUsername(currentUser.getUsername());
                    heartBHospitalinfo.setFileNo(fileNo);
                    heartBHospitalinfo.setName(name);
                    this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
                }
                if (heart.getOutInfo() != null) {
                    HeartBCtout heartBCtout = heart.getOutInfo();
                    heartBCtout.setCreateUserId(currentUser.getUserId());
                    heartBCtout.setUsername(currentUser.getUsername());
                    heartBCtout.setFileNo(fileNo);
                    heartBCtout.setName(name);
                    this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
                }
                if (heart.getSurAfterInfo() != null) {
                    HeartBSurgicalafter heartBSurgicalafter = heart.getSurAfterInfo();
                    heartBSurgicalafter.setCreateUserId(currentUser.getUserId());
                    heartBSurgicalafter.setUsername(currentUser.getUsername());
                    heartBSurgicalafter.setFileNo(fileNo);
                    heartBSurgicalafter.setName(name);
                    this.iHeartBSurgicalafterService.createHeartBSurgicalafter(heartBSurgicalafter);
                }
                if (heart.getSurgicalInfo() != null) {
                    HeartBSurgical heartBSurgical = heart.getSurgicalInfo();
                    heartBSurgical.setCreateUserId(currentUser.getUserId());
                    heartBSurgical.setUsername(currentUser.getUsername());
                    heartBSurgical.setFileNo(fileNo);
                    heartBSurgical.setName(name);
                    this.iHeartBSurgicalService.createHeartBSurgical(heartBSurgical);
                }
                if (heart.getFcctInfo() != null) {
                    List<HeartBCtfc> heartBCtfcList = heart.getFcctInfo();
                    for (HeartBCtfc item : heartBCtfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        this.iHeartBCtfcService.createHeartBCtfc(item);
                    }

                }
                if (heart.getFchyInfo() != null) {
                    List<HeartBHyfc> heartBHyfcList = heart.getFchyInfo();
                    for (HeartBHyfc item : heartBHyfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        this.iHeartBHyfcService.createHeartBHyfc(item);
                    }

                }
                if (heart.getFcInfo() != null) {
                    List<HeartBCsfc> heartBCsfcList = heart.getFcInfo();
                    for (HeartBCsfc item : heartBCsfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        this.iHeartBCsfcService.createHeartBCsfc(item);
                    }

                }
            }
        } catch (Exception e) {
            message = "新增/按钮失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    @Log("修改")
    @PutMapping
    @Transactional
    public void updateHeartBPatientinfo(@Valid String data) throws FebsException {
        try {
            User currentUser = FebsUtil.getCurrentUser();

            JSONObject userJson = JSONObject.parseObject(data);
            CustomHeart heart = JSON.toJavaObject(userJson, CustomHeart.class);


            String fileNo = "";
            String name = "";
            if (heart != null) {
                if (heart.getPatientInfo() != null) {
                    HeartBPatientinfo heartBPatientinfo = heart.getPatientInfo();

                    LambdaQueryWrapper<HeartBPatientinfo> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(HeartBPatientinfo::getFileNo, heartBPatientinfo.getFileNo());
                    queryWrapper.ne(HeartBPatientinfo::getId, heartBPatientinfo.getId());
                    int count = this.iHeartBPatientinfoService.count(queryWrapper);
                    if (count > 0) {
                        throw new FebsException("存在重复的档案号,请重新填写档案号");
                    }

                    heartBPatientinfo.setCreateUserId(currentUser.getUserId());
                    heartBPatientinfo.setUsername(currentUser.getUsername());
                    this.iHeartBPatientinfoService.updateHeartBPatientinfo(heartBPatientinfo);
                    fileNo = heartBPatientinfo.getFileNo();
                    name = heartBPatientinfo.getName();
                }
                if (heart.getCheckInfo() != null) {
                    List<HeartBCheck> heartBCheckList = heart.getCheckInfo();
                    for (HeartBCheck check : heartBCheckList
                    ) {
                       // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
//                        LambdaQueryWrapper<HeartBCheck> queryWrapper_checkInfo = new LambdaQueryWrapper<>();
//                        queryWrapper_checkInfo.eq(HeartBCheck::getFileNo, check.getFileNo());
//                        queryWrapper_checkInfo.eq(HeartBCheck::getIsDeletemark, 1);
//                        int count = this.iHeartBCheckService.count(queryWrapper_checkInfo);
//                        if (count > 0) {
//                            this.iHeartBCheckService.updateHeartBCheck(check);
//                        } else {
//                            this.iHeartBCheckService.createHeartBCheck(check);
//                        }
                        if(check.getId() == null || check.getId().equals("")){
                            check.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCheckService.saveOrUpdate(check);
                    }
                }
                if (heart.getCheckTwoInfo() != null) {
                    List<HeartBChecktwo> heartBChecktwoList = heart.getCheckTwoInfo();
                    for (HeartBChecktwo check : heartBChecktwoList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
//                        LambdaQueryWrapper<HeartBChecktwo> queryWrapper_checktwoInfo = new LambdaQueryWrapper<>();
//                        queryWrapper_checktwoInfo.eq(HeartBChecktwo::getFileNo, check.getFileNo());
//                        queryWrapper_checktwoInfo.eq(HeartBChecktwo::getIsDeletemark, 1);
//                        int count = this.iHeartBChecktwoService.count(queryWrapper_checktwoInfo);
//                        if (count > 0) {
//                            this.iHeartBChecktwoService.updateHeartBChecktwo(check);
//                        } else {
//                            this.iHeartBChecktwoService.createHeartBChecktwo(check);
//                        }
                        if(check.getId() == null || check.getId().equals("")){
                            check.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBChecktwoService.saveOrUpdate(check);
                    }
                }
                if (heart.getCheckThreeInfo() != null) {
                    List<HeartBCheckthree> heartBCheckthreeList = heart.getCheckThreeInfo();
                    for (HeartBCheckthree check : heartBCheckthreeList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
//                        LambdaQueryWrapper<HeartBCheckthree> queryWrapper_checkthreeInfo = new LambdaQueryWrapper<>();
////                        queryWrapper_checkthreeInfo.eq(HeartBCheckthree::getFileNo, check.getFileNo());
////                        queryWrapper_checkthreeInfo.eq(HeartBCheckthree::getIsDeletemark, 1);
////                        int count = this.iHeartBCheckthreeService.count(queryWrapper_checkthreeInfo);
////                        if (count > 0) {
////                            this.iHeartBCheckthreeService.updateHeartBCheckthree(check);
////                        } else {
////                            this.iHeartBCheckthreeService.createHeartBCheckthree(check);
////                        }
                        if(check.getId() == null || check.getId().equals("")){
                            check.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCheckthreeService.saveOrUpdate(check);
                    }
                }
                if (heart.getCheckFourInfo() != null) {
                    List<HeartBCheckfour> heartBCheckfourList = heart.getCheckFourInfo();
                    for (HeartBCheckfour check : heartBCheckfourList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
//                        LambdaQueryWrapper<HeartBCheckfour> queryWrapper_checkfourInfo = new LambdaQueryWrapper<>();
//                        queryWrapper_checkfourInfo.eq(HeartBCheckfour::getFileNo, check.getFileNo());
//                        queryWrapper_checkfourInfo.eq(HeartBCheckfour::getIsDeletemark, 1);
//                        int count = this.iHeartBCheckfourService.count(queryWrapper_checkfourInfo);
//                        if (count > 0) {
//                            this.iHeartBCheckfourService.updateHeartBCheckfour(check);
//                        } else {
//                            this.iHeartBCheckfourService.createHeartBCheckfour(check);
//                        }
                        if(check.getId() == null || check.getId().equals("")){
                            check.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCheckfourService.saveOrUpdate(check);
                    }
                }
                if (heart.getCheckFiveInfo() != null) {
                    List<HeartBCheckfive> heartBCheckfiveList = heart.getCheckFiveInfo();
                    for (HeartBCheckfive check : heartBCheckfiveList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
//                        LambdaQueryWrapper<HeartBCheckfive> queryWrapper_checkfiveInfo = new LambdaQueryWrapper<>();
//                        queryWrapper_checkfiveInfo.eq(HeartBCheckfive::getFileNo, check.getFileNo());
//                        queryWrapper_checkfiveInfo.eq(HeartBCheckfive::getIsDeletemark, 1);
//                        int count = this.iHeartBCheckfiveService.count(queryWrapper_checkfiveInfo);
//                        if (count > 0) {
//                            this.iHeartBCheckfiveService.updateHeartBCheckfive(check);
//                        } else {
//                            this.iHeartBCheckfiveService.createHeartBCheckfive(check);
//                        }
                        if(check.getId() == null || check.getId().equals("")){
                            check.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCheckfiveService.saveOrUpdate(check);
                    }
                }

                if (heart.getCsInfo() != null) {
                    List<HeartBCs> heartBCsList = heart.getCsInfo();
                    for (HeartBCs heartBCs : heartBCsList
                    ) {
                      //  HeartBCs heartBCs = heart.getCsInfo();
                        heartBCs.setCreateUserId(currentUser.getUserId());
                        heartBCs.setUsername(currentUser.getUsername());
                        heartBCs.setFileNo(fileNo);
                        heartBCs.setName(name);
//                        LambdaQueryWrapper<HeartBCs> queryWrapper_HeartBCs = new LambdaQueryWrapper<>();
//                        queryWrapper_HeartBCs.eq(HeartBCs::getFileNo, fileNo);
//                        queryWrapper_HeartBCs.eq(HeartBCs::getIsDeletemark, 1);
//                        int count = this.iHeartBCsService.count(queryWrapper_HeartBCs);
//                        if (count > 0) {
//                            this.iHeartBCsService.updateHeartBCs(heartBCs);
//                        } else {
//
//                            this.iHeartBCsService.createHeartBCs(heartBCs);
//                        }
                        if(heartBCs.getId() == null || heartBCs.getId().equals("")){
                            heartBCs.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCsService.saveOrUpdate(heartBCs);
                    }
                }
                if (heart.getCtInfo() != null) {
                    List<HeartBCt> heartBCtList = heart.getCtInfo();
                    for (HeartBCt heartBCt : heartBCtList
                    ) {
                        heartBCt.setCreateUserId(currentUser.getUserId());
                        heartBCt.setUsername(currentUser.getUsername());
                        heartBCt.setFileNo(fileNo);
                        heartBCt.setName(name);
//                        LambdaQueryWrapper<HeartBCt> queryWrapper_HeartBCt = new LambdaQueryWrapper<>();
//                        queryWrapper_HeartBCt.eq(HeartBCt::getFileNo, fileNo);
//                        queryWrapper_HeartBCt.eq(HeartBCt::getIsDeletemark, 1);
//                        int count = this.iHeartBCtService.count(queryWrapper_HeartBCt);
//                        if (count > 0) {
//                            this.iHeartBCtService.updateHeartBCt(heartBCt);
//                        } else {
//                            this.iHeartBCtService.createHeartBCt(heartBCt);
//                        }
                        if(heartBCt.getId() == null || heartBCt.getId().equals("")){
                            heartBCt.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCtService.saveOrUpdate(heartBCt);
                    }
                }
                if (heart.getHospitalInfo() != null) {
                    HeartBHospitalinfo heartBHospitalinfo = heart.getHospitalInfo();
                    heartBHospitalinfo.setCreateUserId(currentUser.getUserId());
                    heartBHospitalinfo.setUsername(currentUser.getUsername());
                    heartBHospitalinfo.setFileNo(fileNo);
                    heartBHospitalinfo.setName(name);
//                    LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper_HeartBHospitalinfo = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getFileNo, fileNo);
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getIsDeletemark, 1);
//                    int count = this.iHeartBHospitalinfoService.count(queryWrapper_HeartBHospitalinfo);
//                    if (count > 0) {
//                        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
//                    } else {
//                        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
//                    }
                    if(heartBHospitalinfo.getId() == null || heartBHospitalinfo.getId().equals("")){
                        heartBHospitalinfo.setId(UUID.randomUUID().toString());
                    }
                    this.iHeartBHospitalinfoService.saveOrUpdate(heartBHospitalinfo);
                }
                if (heart.getOutInfo() != null) {
                    HeartBCtout heartBCtout = heart.getOutInfo();
                    heartBCtout.setCreateUserId(currentUser.getUserId());
                    heartBCtout.setUsername(currentUser.getUsername());
                    heartBCtout.setFileNo(fileNo);
                    heartBCtout.setName(name);
//                    LambdaQueryWrapper<HeartBCtout> queryWrapper_HeartBCtout = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBCtout.eq(HeartBCtout::getFileNo, fileNo);
//                    queryWrapper_HeartBCtout.eq(HeartBCtout::getIsDeletemark, 1);
//                    int count = this.iHeartBCtoutService.count(queryWrapper_HeartBCtout);
//                    if (count > 0) {
//                        this.iHeartBCtoutService.updateHeartBCtout(heartBCtout);
//                    } else {
//                        this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
//                    }
                    if(heartBCtout.getId() == null || heartBCtout.getId().equals("")){
                        heartBCtout.setId(UUID.randomUUID().toString());
                    }
                    this.iHeartBCtoutService.saveOrUpdate(heartBCtout);
                }
                if (heart.getSurAfterInfo() != null) {
                    HeartBSurgicalafter heartBSurgicalafter = heart.getSurAfterInfo();
                    heartBSurgicalafter.setCreateUserId(currentUser.getUserId());
                    heartBSurgicalafter.setUsername(currentUser.getUsername());
                    heartBSurgicalafter.setFileNo(fileNo);
                    heartBSurgicalafter.setName(name);
//                    LambdaQueryWrapper<HeartBSurgicalafter> queryWrapper_HeartBSurgicalafter = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBSurgicalafter.eq(HeartBSurgicalafter::getFileNo, fileNo);
//                    queryWrapper_HeartBSurgicalafter.eq(HeartBSurgicalafter::getIsDeletemark, 1);
//                    int count = this.iHeartBSurgicalafterService.count(queryWrapper_HeartBSurgicalafter);
//                    if (count > 0) {
//                        this.iHeartBSurgicalafterService.updateHeartBSurgicalafter(heartBSurgicalafter);
//                    } else {
//                        this.iHeartBSurgicalafterService.createHeartBSurgicalafter(heartBSurgicalafter);
//                    }
                    if(heartBSurgicalafter.getId() == null || heartBSurgicalafter.getId().equals("")){
                        heartBSurgicalafter.setId(UUID.randomUUID().toString());
                    }
                    this.iHeartBSurgicalafterService.saveOrUpdate(heartBSurgicalafter);
                }
                if (heart.getSurgicalInfo() != null) {
                    HeartBSurgical heartBSurgical = heart.getSurgicalInfo();
                    heartBSurgical.setCreateUserId(currentUser.getUserId());
                    heartBSurgical.setUsername(currentUser.getUsername());
                    heartBSurgical.setFileNo(fileNo);
                    heartBSurgical.setName(name);
//                    LambdaQueryWrapper<HeartBSurgical> queryWrapper_HeartBSurgical = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBSurgical.eq(HeartBSurgical::getFileNo, fileNo);
//                    queryWrapper_HeartBSurgical.eq(HeartBSurgical::getIsDeletemark, 1);
//                    int count = this.iHeartBSurgicalService.count(queryWrapper_HeartBSurgical);
//                    if (count > 0) {
//                        this.iHeartBSurgicalService.updateHeartBSurgical(heartBSurgical);
//                    } else {
//                        this.iHeartBSurgicalService.createHeartBSurgical(heartBSurgical);
//                    }
                    if(heartBSurgical.getId() == null || heartBSurgical.getId().equals("")){
                        heartBSurgical.setId(UUID.randomUUID().toString());
                    }
                    this.iHeartBSurgicalService.saveOrUpdate(heartBSurgical);
                }
                if (heart.getFcctInfo() != null) {
                    List<HeartBCtfc> heartBCtfcList = heart.getFcctInfo();
                    for (HeartBCtfc item : heartBCtfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
//                        LambdaQueryWrapper<HeartBCtfc> queryWrapper_HeartBCtfc = new LambdaQueryWrapper<>();
//                        queryWrapper_HeartBCtfc.eq(HeartBCtfc::getId, item.getId());
//                        queryWrapper_HeartBCtfc.eq(HeartBCtfc::getIsDeletemark, 1);
//                        int count = this.iHeartBCtfcService.count(queryWrapper_HeartBCtfc);
//                        if (count > 0) {
//                            this.iHeartBCtfcService.updateHeartBCtfc(item);
//                        } else {
//                            this.iHeartBCtfcService.createHeartBCtfc(item);
//                        }
                        if(item.getId() == null || item.getId().equals("")){
                            item.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCtfcService.saveOrUpdate(item);
                    }

                }
                if (heart.getFchyInfo() != null) {
                    List<HeartBHyfc> heartBHyfcList = heart.getFchyInfo();
                    for (HeartBHyfc item : heartBHyfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
//                        LambdaQueryWrapper<HeartBHyfc> queryWrapper_HeartBHyfc = new LambdaQueryWrapper<>();
//                        queryWrapper_HeartBHyfc.eq(HeartBHyfc::getId, item.getId());
//                        queryWrapper_HeartBHyfc.eq(HeartBHyfc::getIsDeletemark, 1);
//                        int count = this.iHeartBHyfcService.count(queryWrapper_HeartBHyfc);
//                        if (count > 0) {
//                            this.iHeartBHyfcService.updateHeartBHyfc(item);
//                        } else {
//                            this.iHeartBHyfcService.createHeartBHyfc(item);
//                        }
                        if(item.getId() == null || item.getId().equals("")){
                            item.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBHyfcService.saveOrUpdate(item);

                    }

                }
                if (heart.getFcInfo() != null) {
                    List<HeartBCsfc> heartBCsfcList = heart.getFcInfo();
                    for (HeartBCsfc item : heartBCsfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
//                        LambdaQueryWrapper<HeartBCsfc> queryWrapper_HeartBCsfc = new LambdaQueryWrapper<>();
//                        queryWrapper_HeartBCsfc.eq(HeartBCsfc::getId, item.getId());
//                        queryWrapper_HeartBCsfc.eq(HeartBCsfc::getIsDeletemark, 1);
//                        int count = this.iHeartBCsfcService.count(queryWrapper_HeartBCsfc);
//                        if (count > 0) {
//                            this.iHeartBCsfcService.updateHeartBCsfc(item);
//                        } else {
//                            this.iHeartBCsfcService.createHeartBCsfc(item);
//                        }
                        if(item.getId() == null || item.getId().equals("")){
                            item.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBCsfcService.saveOrUpdate(item);

                    }

                }
            }
        } catch (Exception e) {
            message = "修改失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    @Log("删除")
    @DeleteMapping("/{ids}")
    @Transactional
    public void deleteHeartBPatientinfos(@NotBlank(message = "{required}") @PathVariable String ids) throws FebsException {
        try {
            String[] arr_ids = ids.split(StringPool.COMMA);
            this.iHeartBPatientinfoService.deleteHeartBPatientinfos(arr_ids);
            for (String id : arr_ids
            ) {
                HeartBPatientinfo heartBPatientinfo = this.iHeartBPatientinfoService.getById(id);
                String fileNo = heartBPatientinfo.getFileNo();
                this.iHeartBCheckService.deleteByFileNo(fileNo);
                this.iHeartBChecktwoService.deleteByFileNo(fileNo);
                this.iHeartBCheckthreeService.deleteByFileNo(fileNo);
                this.iHeartBCheckfourService.deleteByFileNo(fileNo);
                this.iHeartBCheckfiveService.deleteByFileNo(fileNo);
                this.iHeartBHyfcService.deleteByFileNo(fileNo);
                this.iHeartBCtfcService.deleteByFileNo(fileNo);
                this.iHeartBSurgicalafterService.deleteByFileNo(fileNo);
                this.iHeartBHospitalinfoService.deleteByFileNo(fileNo);
                this.iHeartBCtoutService.deleteByFileNo(fileNo);
                this.iHeartBCtService.deleteByFileNo(fileNo);
                this.iHeartBCsfcService.deleteByFileNo(fileNo);
                this.iHeartBCsService.deleteByFileNo(fileNo);
                this.iHeartBSurgicalService.deleteByFileNo(fileNo);
            }

        } catch (Exception e) {
            message = "删除失败";
            log.error(message, e);
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
        HeartBPatientinfo heartBPatientinfo = this.iHeartBPatientinfoService.getById(id);
        return heartBPatientinfo;
    }
}