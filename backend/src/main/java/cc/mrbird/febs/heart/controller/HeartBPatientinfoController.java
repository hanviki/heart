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
import java.util.*;

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
    public IHeartBChecksixService iHeartBChecksixService;
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
    @Autowired
    public IHeartBShzlService iHeartBShzlService;
    @Autowired
    public IHeartBShzlxqService iHeartBShzlxqService;
    @Autowired
    public IHeartBSqzlService iHeartBSqzlService;
    @Autowired
    public IHeartBOtherService iHeartBOtherService;


    @GetMapping
    @RequiresPermissions("heartBPatientinfo:view")
    public Map<String, Object> List(QueryRequest request, HeartBPatientinfo heartBPatientinfo) {
        User currentUser = FebsUtil.getCurrentUser();
        heartBPatientinfo.setUsername(currentUser.getUsername());
        request.setSortField("createTime");
        request.setSortOrder("descend");
        return getDataTable(this.iHeartBPatientinfoService.findHeartBPatientinfos(request, heartBPatientinfo));
    }

    @GetMapping("dept")
    public Map<String, Object> ListDept(QueryRequest request, HeartBPatientinfo heartBPatientinfo) {
        User currentUser = FebsUtil.getCurrentUser();
        heartBPatientinfo.setUsername(currentUser.getUsername());
        request.setSortField("createTime");
        request.setSortOrder("descend");
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
        checkInfo.sort(new Comparator<HeartBCheck>() {
            @Override
            public int compare(HeartBCheck o1, HeartBCheck o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBChecktwo> queryWrapper22 = new LambdaQueryWrapper<>();
        queryWrapper22.eq(HeartBChecktwo::getFileNo, fileNo);
        queryWrapper22.eq(HeartBChecktwo::getIsDeletemark, 1);
        List<HeartBChecktwo> checkTwoInfo = this.iHeartBChecktwoService.list(queryWrapper22);

        checkTwoInfo.sort(new Comparator<HeartBChecktwo>() {
            @Override
            public int compare(HeartBChecktwo o1, HeartBChecktwo o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBCheckthree> queryWrapper23 = new LambdaQueryWrapper<>();
        queryWrapper23.eq(HeartBCheckthree::getFileNo, fileNo);
        queryWrapper23.eq(HeartBCheckthree::getIsDeletemark, 1);
        List<HeartBCheckthree> checkThreeInfo = this.iHeartBCheckthreeService.list(queryWrapper23);

        checkThreeInfo.sort(new Comparator<HeartBCheckthree>() {
            @Override
            public int compare(HeartBCheckthree o1, HeartBCheckthree o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBCheckfour> queryWrapper24 = new LambdaQueryWrapper<>();
        queryWrapper24.eq(HeartBCheckfour::getFileNo, fileNo);
        queryWrapper24.eq(HeartBCheckfour::getIsDeletemark, 1);
        List<HeartBCheckfour> checkFourInfo = this.iHeartBCheckfourService.list(queryWrapper24);

        checkFourInfo.sort(new Comparator<HeartBCheckfour>() {
            @Override
            public int compare(HeartBCheckfour o1, HeartBCheckfour o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });


        LambdaQueryWrapper<HeartBCheckfive> queryWrapper25 = new LambdaQueryWrapper<>();
        queryWrapper25.eq(HeartBCheckfive::getFileNo, fileNo);
        queryWrapper25.eq(HeartBCheckfive::getIsDeletemark, 1);
        List<HeartBCheckfive> checkFiveInfo = this.iHeartBCheckfiveService.list(queryWrapper25);

        checkFiveInfo.sort(new Comparator<HeartBCheckfive>() {
            @Override
            public int compare(HeartBCheckfive o1, HeartBCheckfive o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBChecksix> queryWrapper26 = new LambdaQueryWrapper<>();
        queryWrapper26.eq(HeartBChecksix::getFileNo, fileNo);
        queryWrapper26.eq(HeartBChecksix::getIsDeletemark, 1);
        List<HeartBChecksix> checkSixInfo = this.iHeartBChecksixService.list(queryWrapper26);

        checkSixInfo.sort(new Comparator<HeartBChecksix>() {
            @Override
            public int compare(HeartBChecksix o1, HeartBChecksix o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });


        LambdaQueryWrapper<HeartBCs> queryWrapper3 = new LambdaQueryWrapper<>();
        queryWrapper3.eq(HeartBCs::getIsDeletemark, 1);
        queryWrapper3.eq(HeartBCs::getFileNo, fileNo);
        List<HeartBCs> csInfo = this.iHeartBCsService.list(queryWrapper3);

        csInfo.sort(new Comparator<HeartBCs>() {
            @Override
            public int compare(HeartBCs o1, HeartBCs o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });



        LambdaQueryWrapper<HeartBCt> queryWrapper5 = new LambdaQueryWrapper<>();
        queryWrapper5.eq(HeartBCt::getIsDeletemark, 1);
        queryWrapper5.eq(HeartBCt::getFileNo, fileNo);
        List<HeartBCt> ctInfo = this.iHeartBCtService.list(queryWrapper5);

        ctInfo.sort(new Comparator<HeartBCt>() {
            @Override
            public int compare(HeartBCt o1, HeartBCt o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBCtout> queryWrapper6 = new LambdaQueryWrapper<>();
        queryWrapper6.eq(HeartBCtout::getFileNo, fileNo);
        queryWrapper6.eq(HeartBCtout::getIsDeletemark, 1);
        List<HeartBCtout> ctOutInfo = this.iHeartBCtoutService.list(queryWrapper6);
        ctOutInfo.sort(new Comparator<HeartBCtout>() {
            @Override
            public int compare(HeartBCtout o1, HeartBCtout o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

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

        csfcList.sort(new Comparator<HeartBCsfc>() {
            @Override
            public int compare(HeartBCsfc o1, HeartBCsfc o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });


        LambdaQueryWrapper<HeartBCtfc> queryWrapper10 = new LambdaQueryWrapper<>();
        queryWrapper10.eq(HeartBCtfc::getFileNo, fileNo);
        queryWrapper10.eq(HeartBCtfc::getIsDeletemark, 1);
        List<HeartBCtfc> ctfcList = this.iHeartBCtfcService.list(queryWrapper10);

        ctfcList.sort(new Comparator<HeartBCtfc>() {
            @Override
            public int compare(HeartBCtfc o1, HeartBCtfc o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });


        LambdaQueryWrapper<HeartBHyfc> queryWrapper11 = new LambdaQueryWrapper<>();
        queryWrapper11.eq(HeartBHyfc::getFileNo, fileNo);
        queryWrapper11.eq(HeartBHyfc::getIsDeletemark, 1);
        List<HeartBHyfc> heartBHyfcList = this.iHeartBHyfcService.list(queryWrapper11);

        heartBHyfcList.sort(new Comparator<HeartBHyfc>() {
            @Override
            public int compare(HeartBHyfc o1, HeartBHyfc o2) {
                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBShzl> queryWrapper12 = new LambdaQueryWrapper<>();
        queryWrapper12.eq(HeartBShzl::getFileNo, fileNo);
        queryWrapper12.eq(HeartBShzl::getIsDeletemark, 1);
        HeartBShzl heartBShzlList = this.iHeartBShzlService.getOne(queryWrapper12);




        LambdaQueryWrapper<HeartBSqzl> queryWrapper13 = new LambdaQueryWrapper<>();
        queryWrapper13.eq(HeartBSqzl::getFileNo, fileNo);
        queryWrapper13.eq(HeartBSqzl::getIsDeletemark, 1);
        HeartBSqzl heartBSqzlList = this.iHeartBSqzlService.getOne(queryWrapper13);

        LambdaQueryWrapper<HeartBShzlxq> queryWrapper14 = new LambdaQueryWrapper<>();
        queryWrapper14.eq(HeartBShzlxq::getFileNo, fileNo);
        queryWrapper14.eq(HeartBShzlxq::getIsDeletemark, 1);
        List<HeartBShzlxq> heartBShzlxqList = this.iHeartBShzlxqService.list(queryWrapper14);

        heartBShzlxqList.sort(new Comparator<HeartBShzlxq>() {
            @Override
            public int compare(HeartBShzlxq o1, HeartBShzlxq o2) {

                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        LambdaQueryWrapper<HeartBOther> queryWrapper15 = new LambdaQueryWrapper<>();
        queryWrapper15.eq(HeartBOther::getFileNo, fileNo);
        queryWrapper15.eq(HeartBOther::getIsDeletemark, 1);
        List<HeartBOther> heartBOtherList = this.iHeartBOtherService.list(queryWrapper15);

        heartBOtherList.sort(new Comparator<HeartBOther>() {
            @Override
            public int compare(HeartBOther o1, HeartBOther o2) {

                return o1.getDisplayIndex().compareTo(o2.getDisplayIndex());
            }
        });

        CustomHeart heart = new CustomHeart();
        heart.setCheckInfo(checkInfo);
        heart.setCheckTwoInfo(checkTwoInfo);
        heart.setCheckThreeInfo(checkThreeInfo);
        heart.setCheckFourInfo(checkFourInfo);
        heart.setCheckFiveInfo(checkFiveInfo);
        heart.setCheckSixInfo(checkSixInfo);
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
        heart.setShzlInfo(heartBShzlList);
        heart.setSqzlInfo(heartBSqzlList);
        heart.setShzlxqsInfo(heartBShzlxqList);
        heart.setOtherInfo(heartBOtherList);
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
            int dIndex=0;
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
                    dIndex=0;
                    List<HeartBCheck> heartBCheckList = heart.getCheckInfo();
                    for (HeartBCheck check : heartBCheckList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);

                        check.setDisplayIndex(dIndex);
                        this.iHeartBCheckService.createHeartBCheck(check);
                        dIndex++;
                    }

                }
                if (heart.getCheckTwoInfo() != null) {
                    dIndex=0;
                    List<HeartBChecktwo> heartBChecktwoList = heart.getCheckTwoInfo();
                    for (HeartBChecktwo check : heartBChecktwoList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setDisplayIndex(dIndex);
                        this.iHeartBChecktwoService.createHeartBChecktwo(check);
                        dIndex++;
                    }

                }
                if (heart.getCheckThreeInfo() != null) {
                    dIndex=0;
                    List<HeartBCheckthree> heartBCheckthreeList = heart.getCheckThreeInfo();
                    for (HeartBCheckthree check : heartBCheckthreeList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setDisplayIndex(dIndex);
                        this.iHeartBCheckthreeService.createHeartBCheckthree(check);
                        dIndex++;
                    }

                }
                if (heart.getCheckFourInfo() != null) {
                    dIndex=0;
                    List<HeartBCheckfour> heartBCheckfourList = heart.getCheckFourInfo();
                    for (HeartBCheckfour check : heartBCheckfourList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setDisplayIndex(dIndex);
                        this.iHeartBCheckfourService.createHeartBCheckfour(check);
                        dIndex++;
                    }

                }
                if (heart.getCheckFiveInfo() != null) {
                    dIndex=0;
                    List<HeartBCheckfive> heartBCheckfiveList = heart.getCheckFiveInfo();
                    for (HeartBCheckfive check : heartBCheckfiveList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setDisplayIndex(dIndex);
                        this.iHeartBCheckfiveService.createHeartBCheckfive(check);
                        dIndex++;
                    }

                }
                if (heart.getCheckSixInfo() != null) {
                    dIndex=0;
                    List<HeartBChecksix> heartBChecksixList = heart.getCheckSixInfo();
                    for (HeartBChecksix check : heartBChecksixList
                    ) {
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setDisplayIndex(dIndex);
                        this.iHeartBChecksixService.createHeartBChecksix(check);
                        dIndex++;
                    }

                }
                if (heart.getCsInfo() != null) {
                    dIndex=0;
                    List<HeartBCs> heartBCsList = heart.getCsInfo();
                    for (HeartBCs heartBCs : heartBCsList
                    ) {
                        heartBCs.setCreateUserId(currentUser.getUserId());
                        heartBCs.setUsername(currentUser.getUsername());
                        heartBCs.setFileNo(fileNo);
                        heartBCs.setName(name);
                        heartBCs.setDisplayIndex(dIndex);
                        this.iHeartBCsService.createHeartBCs(heartBCs);
                        dIndex++;
                    }

                }
                if (heart.getCtInfo() != null) {
                    dIndex=0;
                    List<HeartBCt> heartBCtList = heart.getCtInfo();
                    for (HeartBCt heartBCt : heartBCtList
                    ) {
                        heartBCt.setCreateUserId(currentUser.getUserId());
                        heartBCt.setUsername(currentUser.getUsername());
                        heartBCt.setFileNo(fileNo);
                        heartBCt.setName(name);
                        heartBCt.setDisplayIndex(dIndex);
                        this.iHeartBCtService.createHeartBCt(heartBCt);
                        dIndex++;
                    }

                }
                if (heart.getSqzlInfo() != null) {
                    HeartBSqzl heartBSqzl = heart.getSqzlInfo();
                    heartBSqzl.setCreateUserId(currentUser.getUserId());
                    heartBSqzl.setUsername(currentUser.getUsername());
                    heartBSqzl.setFileNo(fileNo);
                    heartBSqzl.setName(name);
//                    LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper_HeartBHospitalinfo = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getFileNo, fileNo);
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getIsDeletemark, 1);
//                    int count = this.iHeartBHospitalinfoService.count(queryWrapper_HeartBHospitalinfo);
//                    if (count > 0) {
//                        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
//                    } else {
//                        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
//                    }

                    this.iHeartBSqzlService.createHeartBSqzl(heartBSqzl);
                }
                if (heart.getShzlInfo() != null) {
                    HeartBShzl heartBShzl = heart.getShzlInfo();
                    heartBShzl.setCreateUserId(currentUser.getUserId());
                    heartBShzl.setUsername(currentUser.getUsername());
                    heartBShzl.setFileNo(fileNo);
                    heartBShzl.setName(name);
//                    LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper_HeartBHospitalinfo = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getFileNo, fileNo);
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getIsDeletemark, 1);
//                    int count = this.iHeartBHospitalinfoService.count(queryWrapper_HeartBHospitalinfo);
//                    if (count > 0) {
//                        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
//                    } else {
//                        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
//                    }
                    if(heartBShzl.getId() == null || heartBShzl.getId().equals("")){
                        heartBShzl.setId(UUID.randomUUID().toString());
                    }
                    this.iHeartBShzlService.createHeartBShzl(heartBShzl);
                }
                if (heart.getShzlxqsInfo() != null) {
                    dIndex=0;
                    List<HeartBShzlxq> heartShzlxqsList = heart.getShzlxqsInfo();
                    for (HeartBShzlxq item : heartShzlxqsList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                        this.iHeartBShzlxqService.createHeartBShzlxq(item);
                    }

                }
                if (heart.getOtherInfo() != null) {
                    dIndex=0;
                    List<HeartBOther> heartBOthers = heart.getOtherInfo();
                    for (HeartBOther item : heartBOthers
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
                        if(item.getId() == null || item.getId().equals("")){
                            item.setId(UUID.randomUUID().toString());
                        }
                        this.iHeartBOtherService.createHeartBOther(item);
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
                    dIndex=0;
                    List<HeartBCtout> heartBCtoutList = heart.getOutInfo();
                    for (HeartBCtout item : heartBCtoutList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                        this.iHeartBCtoutService.createHeartBCtout(item);
                    }

                }

//                if (heart.getOutInfo() != null) {
//                    HeartBCtout heartBCtout = heart.getOutInfo();
//                    heartBCtout.setCreateUserId(currentUser.getUserId());
//                    heartBCtout.setUsername(currentUser.getUsername());
//                    heartBCtout.setFileNo(fileNo);
//                    heartBCtout.setName(name);
//                    this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
//                }
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

                    dIndex=0;
                    List<HeartBCtfc> heartBCtfcList = heart.getFcctInfo();
                    for (HeartBCtfc item : heartBCtfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
                        this.iHeartBCtfcService.createHeartBCtfc(item);
                    }

                }
                if (heart.getFchyInfo() != null) {
                    dIndex=0;
                    List<HeartBHyfc> heartBHyfcList = heart.getFchyInfo();
                    for (HeartBHyfc item : heartBHyfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
                        this.iHeartBHyfcService.createHeartBHyfc(item);
                    }

                }
                if (heart.getFcInfo() != null) {
                    dIndex=0;
                    List<HeartBCsfc> heartBCsfcList = heart.getFcInfo();
                    for (HeartBCsfc item : heartBCsfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
            int dIndex=0;
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
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBChecktwo> heartBChecktwoList = heart.getCheckTwoInfo();
                    for (HeartBChecktwo check : heartBChecktwoList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBCheckthree> heartBCheckthreeList = heart.getCheckThreeInfo();
                    for (HeartBCheckthree check : heartBCheckthreeList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBCheckfour> heartBCheckfourList = heart.getCheckFourInfo();
                    for (HeartBCheckfour check : heartBCheckfourList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBCheckfive> heartBCheckfiveList = heart.getCheckFiveInfo();
                    for (HeartBCheckfive check : heartBCheckfiveList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;

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

                if (heart.getCheckSixInfo() != null) {
                    dIndex=0;
                    List<HeartBChecksix> heartBChecksixList = heart.getCheckSixInfo();
                    for (HeartBChecksix check : heartBChecksixList
                    ) {
                        // HeartBCheck check = heart.getCheckInfo();
                        check.setCreateUserId(currentUser.getUserId());
                        check.setUsername(currentUser.getUsername());
                        check.setFileNo(fileNo);
                        check.setName(name);
                        check.setCreateTime(new Date());
                        check.setIsDeletemark(1);
                        check.setDisplayIndex(dIndex);
                        dIndex++;

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
                        this.iHeartBChecksixService.saveOrUpdate(check);
                    }
                }


                if (heart.getCsInfo() != null) {
                    dIndex=0;
                    List<HeartBCs> heartBCsList = heart.getCsInfo();
                    for (HeartBCs heartBCs : heartBCsList
                    ) {
                      //  HeartBCs heartBCs = heart.getCsInfo();
                        heartBCs.setCreateUserId(currentUser.getUserId());
                        heartBCs.setUsername(currentUser.getUsername());
                        heartBCs.setFileNo(fileNo);
                        heartBCs.setName(name);
                        heartBCs.setCreateTime(new Date());
                        heartBCs.setIsDeletemark(1);
                        heartBCs.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBCt> heartBCtList = heart.getCtInfo();
                    for (HeartBCt heartBCt : heartBCtList
                    ) {
                        heartBCt.setCreateUserId(currentUser.getUserId());
                        heartBCt.setUsername(currentUser.getUsername());
                        heartBCt.setFileNo(fileNo);
                        heartBCt.setName(name);
                        heartBCt.setCreateTime(new Date());
                        heartBCt.setIsDeletemark(1);
                        heartBCt.setDisplayIndex(dIndex);
                        dIndex++;
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
                    heartBHospitalinfo.setCreateTime(new Date());
                    heartBHospitalinfo.setIsDeletemark(1);
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

                if (heart.getSqzlInfo() != null) {
                    HeartBSqzl heartBSqzl = heart.getSqzlInfo();
                    heartBSqzl.setCreateUserId(currentUser.getUserId());
                    heartBSqzl.setUsername(currentUser.getUsername());
                    heartBSqzl.setFileNo(fileNo);
                    heartBSqzl.setName(name);
                    heartBSqzl.setCreateTime(new Date());
                    heartBSqzl.setIsDeletemark(1);
//                    LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper_HeartBHospitalinfo = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getFileNo, fileNo);
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getIsDeletemark, 1);
//                    int count = this.iHeartBHospitalinfoService.count(queryWrapper_HeartBHospitalinfo);
//                    if (count > 0) {
//                        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
//                    } else {
//                        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
//                    }
                    if(heartBSqzl.getId() == null || heartBSqzl.getId().equals("")){
                        heartBSqzl.setId(UUID.randomUUID().toString());

                    }
                    this.iHeartBSqzlService.saveOrUpdate(heartBSqzl);
                }
                if (heart.getShzlInfo() != null) {
                    HeartBShzl heartBShzl = heart.getShzlInfo();
                    heartBShzl.setCreateUserId(currentUser.getUserId());
                    heartBShzl.setUsername(currentUser.getUsername());
                    heartBShzl.setFileNo(fileNo);
                    heartBShzl.setName(name);
                    heartBShzl.setCreateTime(new Date());
                    heartBShzl.setIsDeletemark(1);
//                    LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper_HeartBHospitalinfo = new LambdaQueryWrapper<>();
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getFileNo, fileNo);
//                    queryWrapper_HeartBHospitalinfo.eq(HeartBHospitalinfo::getIsDeletemark, 1);
//                    int count = this.iHeartBHospitalinfoService.count(queryWrapper_HeartBHospitalinfo);
//                    if (count > 0) {
//                        this.iHeartBHospitalinfoService.updateHeartBHospitalinfo(heartBHospitalinfo);
//                    } else {
//                        this.iHeartBHospitalinfoService.createHeartBHospitalinfo(heartBHospitalinfo);
//                    }
                    if(heartBShzl.getId() == null || heartBShzl.getId().equals("")){
                        heartBShzl.setId(UUID.randomUUID().toString());

                    }
                    this.iHeartBShzlService.saveOrUpdate(heartBShzl);
                }
                if (heart.getShzlxqsInfo() != null) {
                    dIndex=0;
                    List<HeartBShzlxq> heartShzlxqsList = heart.getShzlxqsInfo();
                    for (HeartBShzlxq item : heartShzlxqsList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                        this.iHeartBShzlxqService.saveOrUpdate(item);
                    }

                }

                if (heart.getOtherInfo() != null) {
                    dIndex=0;
                    List<HeartBOther> heartBOtherList = heart.getOtherInfo();
                    for (HeartBOther item : heartBOtherList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                        this.iHeartBOtherService.saveOrUpdate(item);
                    }

                }
                if (heart.getOutInfo() != null) {
                    dIndex=0;
                    List<HeartBCtout> heartBCtoutList = heart.getOutInfo();
                    for (HeartBCtout item : heartBCtoutList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
                        if(item.getId() == null || item.getId().equals("")){
                            item.setId(UUID.randomUUID().toString());

                        }
                        this.iHeartBCtoutService.saveOrUpdate(item);
                    }

                }

//                if (heart.getOutInfo() != null) {
//                    HeartBCtout heartBCtout = heart.getOutInfo();
//                    heartBCtout.setCreateUserId(currentUser.getUserId());
//                    heartBCtout.setUsername(currentUser.getUsername());
//                    heartBCtout.setFileNo(fileNo);
//                    heartBCtout.setName(name);
//                    heartBCtout.setCreateTime(new Date());
//                    heartBCtout.setIsDeletemark(1);
////                    LambdaQueryWrapper<HeartBCtout> queryWrapper_HeartBCtout = new LambdaQueryWrapper<>();
////                    queryWrapper_HeartBCtout.eq(HeartBCtout::getFileNo, fileNo);
////                    queryWrapper_HeartBCtout.eq(HeartBCtout::getIsDeletemark, 1);
////                    int count = this.iHeartBCtoutService.count(queryWrapper_HeartBCtout);
////                    if (count > 0) {
////                        this.iHeartBCtoutService.updateHeartBCtout(heartBCtout);
////                    } else {
////                        this.iHeartBCtoutService.createHeartBCtout(heartBCtout);
////                    }
//                    if(heartBCtout.getId() == null || heartBCtout.getId().equals("")){
//                        heartBCtout.setId(UUID.randomUUID().toString());
//
//                    }
//                    this.iHeartBCtoutService.saveOrUpdate(heartBCtout);
//                }
                if (heart.getSurAfterInfo() != null) {
                    HeartBSurgicalafter heartBSurgicalafter = heart.getSurAfterInfo();
                    heartBSurgicalafter.setCreateUserId(currentUser.getUserId());
                    heartBSurgicalafter.setUsername(currentUser.getUsername());
                    heartBSurgicalafter.setFileNo(fileNo);
                    heartBSurgicalafter.setName(name);
                    heartBSurgicalafter.setCreateTime(new Date());
                    heartBSurgicalafter.setIsDeletemark(1);
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
                    heartBSurgical.setCreateTime(new Date());
                    heartBSurgical.setIsDeletemark(1);
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
                    dIndex=0;
                    List<HeartBCtfc> heartBCtfcList = heart.getFcctInfo();
                    for (HeartBCtfc item : heartBCtfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBHyfc> heartBHyfcList = heart.getFchyInfo();
                    for (HeartBHyfc item : heartBHyfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                    dIndex=0;
                    List<HeartBCsfc> heartBCsfcList = heart.getFcInfo();
                    for (HeartBCsfc item : heartBCsfcList
                    ) {
                        item.setCreateUserId(currentUser.getUserId());
                        item.setUsername(currentUser.getUsername());
                        item.setFileNo(fileNo);
                        item.setName(name);
                        item.setCreateTime(new Date());
                        item.setIsDeletemark(1);
                        item.setDisplayIndex(dIndex);
                        dIndex++;
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
                this.iHeartBShzlService.deleteByFileNo(fileNo);
                this.iHeartBShzlxqService.deleteByFileNo(fileNo);
                this.iHeartBSqzlService.deleteByFileNo(fileNo);
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