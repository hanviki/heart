package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBShzlxq;
import cc.mrbird.febs.heart.dao.HeartBShzlxqMapper;
import cc.mrbird.febs.heart.service.IHeartBShzlxqService;
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
 * 血气结果 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
@Slf4j
@Service("IHeartBShzlxqService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBShzlxqServiceImpl extends ServiceImpl<HeartBShzlxqMapper, HeartBShzlxq> implements IHeartBShzlxqService {


@Override
public IPage<HeartBShzlxq> findHeartBShzlxqs(QueryRequest request, HeartBShzlxq heartBShzlxq){
        try{
        LambdaQueryWrapper<HeartBShzlxq> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBShzlxq.getUsername())) {
        queryWrapper.eq(HeartBShzlxq::getUsername, heartBShzlxq.getUsername());
        }
        queryWrapper.eq(HeartBShzlxq::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBShzlxq> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBShzlxq(HeartBShzlxq heartBShzlxq){
        if(!StringUtils.isNotBlank(heartBShzlxq.getId())) {
                heartBShzlxq.setId(UUID.randomUUID().toString());
        }
        heartBShzlxq.setCreateTime(new Date());
        heartBShzlxq.setIsDeletemark(1);
        this.save(heartBShzlxq);
        }

@Override
@Transactional
public void updateHeartBShzlxq(HeartBShzlxq heartBShzlxq){
        heartBShzlxq.setModifyTime(new Date());
        this.baseMapper.updateHeartBShzlxq(heartBShzlxq);
        }

@Override
@Transactional
public void deleteHeartBShzlxqs(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBShzlxq heartBShzlxq =new HeartBShzlxq();
        heartBShzlxq.setId(id);
        heartBShzlxq.setIsDeletemark(0);
        this.baseMapper.updateHeartBShzlxq(heartBShzlxq);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }