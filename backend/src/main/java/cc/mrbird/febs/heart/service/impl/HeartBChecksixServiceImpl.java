package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBChecksix;
import cc.mrbird.febs.heart.dao.HeartBChecksixMapper;
import cc.mrbird.febs.heart.service.IHeartBChecksixService;
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
 * @since 2021-06-22
 */
@Slf4j
@Service("IHeartBChecksixService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBChecksixServiceImpl extends ServiceImpl<HeartBChecksixMapper, HeartBChecksix> implements IHeartBChecksixService {


@Override
public IPage<HeartBChecksix> findHeartBChecksixs(QueryRequest request, HeartBChecksix heartBChecksix){
        try{
        LambdaQueryWrapper<HeartBChecksix> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBChecksix.getUsername())) {
        queryWrapper.eq(HeartBChecksix::getUsername, heartBChecksix.getUsername());
        }
        queryWrapper.eq(HeartBChecksix::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBChecksix> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBChecksix(HeartBChecksix heartBChecksix){
        if(!StringUtils.isNotBlank(heartBChecksix.getId())) {
                heartBChecksix.setId(UUID.randomUUID().toString());
        }
        heartBChecksix.setCreateTime(new Date());
        heartBChecksix.setIsDeletemark(1);
        this.save(heartBChecksix);
        }

@Override
@Transactional
public void updateHeartBChecksix(HeartBChecksix heartBChecksix){
        heartBChecksix.setModifyTime(new Date());
        this.baseMapper.updateHeartBChecksix(heartBChecksix);
        }

@Override
@Transactional
public void deleteHeartBChecksixs(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBChecksix heartBChecksix =new HeartBChecksix();
        heartBChecksix.setId(id);
        heartBChecksix.setIsDeletemark(0);
        this.baseMapper.updateHeartBChecksix(heartBChecksix);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }