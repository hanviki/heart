package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBHospitalinfo;
import cc.mrbird.febs.heart.dao.HeartBHospitalinfoMapper;
import cc.mrbird.febs.heart.service.IHeartBHospitalinfoService;
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
 * 住院病历资料 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-17
 */
@Slf4j
@Service("IHeartBHospitalinfoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBHospitalinfoServiceImpl extends ServiceImpl<HeartBHospitalinfoMapper, HeartBHospitalinfo> implements IHeartBHospitalinfoService {


@Override
public IPage<HeartBHospitalinfo> findHeartBHospitalinfos(QueryRequest request, HeartBHospitalinfo heartBHospitalinfo){
        try{
        LambdaQueryWrapper<HeartBHospitalinfo> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBHospitalinfo.getUsername())) {
        queryWrapper.eq(HeartBHospitalinfo::getUsername, heartBHospitalinfo.getUsername());
        }
        queryWrapper.eq(HeartBHospitalinfo::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBHospitalinfo> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo){
        heartBHospitalinfo.setId(UUID.randomUUID().toString());
        heartBHospitalinfo.setCreateTime(new Date());
        heartBHospitalinfo.setIsDeletemark(1);
        this.save(heartBHospitalinfo);
        }

@Override
@Transactional
public void updateHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo){
        heartBHospitalinfo.setModifyTime(new Date());
        this.baseMapper.updateHeartBHospitalinfo(heartBHospitalinfo);
        }

@Override
@Transactional
public void deleteHeartBHospitalinfos(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBHospitalinfo heartBHospitalinfo =new HeartBHospitalinfo();
        heartBHospitalinfo.setId(id);
        heartBHospitalinfo.setIsDeletemark(0);
        this.baseMapper.updateHeartBHospitalinfo(heartBHospitalinfo);
        }
        }


        }