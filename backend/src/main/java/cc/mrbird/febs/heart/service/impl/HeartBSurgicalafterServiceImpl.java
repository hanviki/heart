package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBSurgicalafter;
import cc.mrbird.febs.heart.dao.HeartBSurgicalafterMapper;
import cc.mrbird.febs.heart.service.IHeartBSurgicalafterService;
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
 * 术后 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBSurgicalafterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBSurgicalafterServiceImpl extends ServiceImpl<HeartBSurgicalafterMapper, HeartBSurgicalafter> implements IHeartBSurgicalafterService {


@Override
public IPage<HeartBSurgicalafter> findHeartBSurgicalafters(QueryRequest request, HeartBSurgicalafter heartBSurgicalafter){
        try{
        LambdaQueryWrapper<HeartBSurgicalafter> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBSurgicalafter.getUsername())) {
        queryWrapper.eq(HeartBSurgicalafter::getUsername, heartBSurgicalafter.getUsername());
        }
        queryWrapper.eq(HeartBSurgicalafter::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBSurgicalafter> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBSurgicalafter(HeartBSurgicalafter heartBSurgicalafter){
        if(!StringUtils.isNotBlank(heartBSurgicalafter.getId())) {
                heartBSurgicalafter.setId(UUID.randomUUID().toString());
        }
        heartBSurgicalafter.setCreateTime(new Date());
        heartBSurgicalafter.setIsDeletemark(1);
        this.save(heartBSurgicalafter);
        }

@Override
@Transactional
public void updateHeartBSurgicalafter(HeartBSurgicalafter heartBSurgicalafter){
        heartBSurgicalafter.setModifyTime(new Date());
        this.baseMapper.updateHeartBSurgicalafter(heartBSurgicalafter);
        }

@Override
@Transactional
public void deleteHeartBSurgicalafters(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBSurgicalafter heartBSurgicalafter =new HeartBSurgicalafter();
        heartBSurgicalafter.setId(id);
        heartBSurgicalafter.setIsDeletemark(0);
        this.baseMapper.updateHeartBSurgicalafter(heartBSurgicalafter);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }