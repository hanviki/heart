package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCheck;
import cc.mrbird.febs.heart.dao.HeartBCheckMapper;
import cc.mrbird.febs.heart.service.IHeartBCheckService;
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
 * 检验 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-17
 */
@Slf4j
@Service("IHeartBCheckService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCheckServiceImpl extends ServiceImpl<HeartBCheckMapper, HeartBCheck> implements IHeartBCheckService {


@Override
public IPage<HeartBCheck> findHeartBChecks(QueryRequest request, HeartBCheck heartBCheck){
        try{
        LambdaQueryWrapper<HeartBCheck> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCheck.getUsername())) {
        queryWrapper.eq(HeartBCheck::getUsername, heartBCheck.getUsername());
        }
        queryWrapper.eq(HeartBCheck::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCheck> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCheck(HeartBCheck heartBCheck){
        heartBCheck.setId(UUID.randomUUID().toString());
        heartBCheck.setCreateTime(new Date());
        heartBCheck.setIsDeletemark(1);
        this.save(heartBCheck);
        }

@Override
@Transactional
public void updateHeartBCheck(HeartBCheck heartBCheck){
        heartBCheck.setModifyTime(new Date());
        this.baseMapper.updateHeartBCheck(heartBCheck);
        }

@Override
@Transactional
public void deleteHeartBChecks(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCheck heartBCheck =new HeartBCheck();
        heartBCheck.setId(id);
        heartBCheck.setIsDeletemark(0);
        this.baseMapper.updateHeartBCheck(heartBCheck);
        }
        }


        }