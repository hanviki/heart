package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBPatientinfo;
import cc.mrbird.febs.heart.dao.HeartBPatientinfoMapper;
import cc.mrbird.febs.heart.service.IHeartBPatientinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
@Slf4j
@Service("IHeartBPatientinfoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBPatientinfoServiceImpl extends ServiceImpl<HeartBPatientinfoMapper, HeartBPatientinfo> implements IHeartBPatientinfoService {


@Override
public IPage<HeartBPatientinfo> findHeartBPatientinfos(QueryRequest request, HeartBPatientinfo heartBPatientinfo){
        try{
        LambdaQueryWrapper<HeartBPatientinfo> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBPatientinfo.getUsername())) {
        queryWrapper.eq(HeartBPatientinfo::getUsername, heartBPatientinfo.getUsername());
        }
                if (StringUtils.isNotBlank(heartBPatientinfo.getFileNo())) {
                        queryWrapper.eq(HeartBPatientinfo::getFileNo, heartBPatientinfo.getFileNo());
                }
                if (StringUtils.isNotBlank(heartBPatientinfo.getName())) {
                        queryWrapper.like(HeartBPatientinfo::getName, heartBPatientinfo.getName());
                }
        queryWrapper.eq(HeartBPatientinfo::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBPatientinfo> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }
        @Override
        public  IPage<HeartBPatientinfo> findHeartBPatientinfosDept(QueryRequest request, HeartBPatientinfo heartBPatientinfo,String userId){
                try{
                        LambdaQueryWrapper<HeartBPatientinfo> queryWrapper=new LambdaQueryWrapper<>();
                        queryWrapper.apply("heart_b_patientinfo.username in (SELECT\n" +
                                "\tA.USERNAME \n" +
                                "FROM\n" +
                                "\tt_user A \n" +
                                "WHERE\n" +
                                "\tA.DEPT_ID IN ( SELECT B.AreaID FROM scm_b_userandarea B WHERE B.USERID = {0} ) UNION ALL\n" +
                                "\tSELECT {1} from DUAL)",userId,heartBPatientinfo.getUsername());
                        if (StringUtils.isNotBlank(heartBPatientinfo.getFileNo())) {
                                queryWrapper.eq(HeartBPatientinfo::getFileNo, heartBPatientinfo.getFileNo());
                        }
                        if (StringUtils.isNotBlank(heartBPatientinfo.getName())) {
                                queryWrapper.like(HeartBPatientinfo::getName, heartBPatientinfo.getName());
                        }
                        queryWrapper.eq(HeartBPatientinfo::getIsDeletemark, 1);//1是未删 0是已删
                        Page<HeartBPatientinfo> page=new Page<>();
                        SortUtil.handlePageSort(request,page,true);
                        return this.page(page,queryWrapper);
                }catch(Exception e){
                        log.error("获取字典信息失败" ,e);
                        return null;
                }
        }
@Override
@Transactional
public void createHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo){
        if(!StringUtils.isNotBlank(heartBPatientinfo.getId())) {
                heartBPatientinfo.setId(UUID.randomUUID().toString());
        }
        heartBPatientinfo.setCreateTime(new Date());
        heartBPatientinfo.setIsDeletemark(1);
        this.save(heartBPatientinfo);
        }

@Override
@Transactional
public void updateHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo){
        heartBPatientinfo.setModifyTime(new Date());
        this.baseMapper.updateHeartBPatientinfo(heartBPatientinfo);
        }

@Override
@Transactional
public void deleteHeartBPatientinfos(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
             ) {
                HeartBPatientinfo heartBPatientinfo =new HeartBPatientinfo();
                heartBPatientinfo.setId(id);
                heartBPatientinfo.setIsDeletemark(0);
                this.baseMapper.updateHeartBPatientinfo(heartBPatientinfo);
        }
       // this.baseMapper.deleteBatchIds(list);
        }


        }