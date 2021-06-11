package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCtout;
import cc.mrbird.febs.heart.dao.HeartBCtoutMapper;
import cc.mrbird.febs.heart.service.IHeartBCtoutService;
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
 * 出院复查CT6 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBCtoutService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCtoutServiceImpl extends ServiceImpl<HeartBCtoutMapper, HeartBCtout> implements IHeartBCtoutService {


@Override
public IPage<HeartBCtout> findHeartBCtouts(QueryRequest request, HeartBCtout heartBCtout){
        try{
        LambdaQueryWrapper<HeartBCtout> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCtout.getUsername())) {
        queryWrapper.eq(HeartBCtout::getUsername, heartBCtout.getUsername());
        }
        queryWrapper.eq(HeartBCtout::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCtout> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCtout(HeartBCtout heartBCtout){
        if(!StringUtils.isNotBlank(heartBCtout.getId())) {
                heartBCtout.setId(UUID.randomUUID().toString());
        }
        heartBCtout.setCreateTime(new Date());
        heartBCtout.setIsDeletemark(1);
        this.save(heartBCtout);
        }

@Override
@Transactional
public void updateHeartBCtout(HeartBCtout heartBCtout){
        heartBCtout.setModifyTime(new Date());
        this.baseMapper.updateHeartBCtout(heartBCtout);
        }

@Override
@Transactional
public void deleteHeartBCtouts(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCtout heartBCtout =new HeartBCtout();
        heartBCtout.setId(id);
        heartBCtout.setIsDeletemark(0);
        this.baseMapper.updateHeartBCtout(heartBCtout);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }