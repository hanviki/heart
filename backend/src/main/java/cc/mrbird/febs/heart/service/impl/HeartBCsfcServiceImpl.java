package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCsfc;
import cc.mrbird.febs.heart.dao.HeartBCsfcMapper;
import cc.mrbird.febs.heart.service.IHeartBCsfcService;
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
 * 超声复查 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-17
 */
@Slf4j
@Service("IHeartBCsfcService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCsfcServiceImpl extends ServiceImpl<HeartBCsfcMapper, HeartBCsfc> implements IHeartBCsfcService {


@Override
public IPage<HeartBCsfc> findHeartBCsfcs(QueryRequest request, HeartBCsfc heartBCsfc){
        try{
        LambdaQueryWrapper<HeartBCsfc> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCsfc.getUsername())) {
        queryWrapper.eq(HeartBCsfc::getUsername, heartBCsfc.getUsername());
        }
        queryWrapper.eq(HeartBCsfc::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCsfc> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCsfc(HeartBCsfc heartBCsfc){
        heartBCsfc.setId(UUID.randomUUID().toString());
        heartBCsfc.setCreateTime(new Date());
        heartBCsfc.setIsDeletemark(1);
        this.save(heartBCsfc);
        }

@Override
@Transactional
public void updateHeartBCsfc(HeartBCsfc heartBCsfc){
        heartBCsfc.setModifyTime(new Date());
        this.baseMapper.updateHeartBCsfc(heartBCsfc);
        }

@Override
@Transactional
public void deleteHeartBCsfcs(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCsfc heartBCsfc =new HeartBCsfc();
        heartBCsfc.setId(id);
        heartBCsfc.setIsDeletemark(0);
        this.baseMapper.updateHeartBCsfc(heartBCsfc);
        }
        }


        }