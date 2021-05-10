package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCtfc;
import cc.mrbird.febs.heart.dao.HeartBCtfcMapper;
import cc.mrbird.febs.heart.service.IHeartBCtfcService;
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
 * @since 2021-05-06
 */
@Slf4j
@Service("IHeartBCtfcService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCtfcServiceImpl extends ServiceImpl<HeartBCtfcMapper, HeartBCtfc> implements IHeartBCtfcService {


@Override
public IPage<HeartBCtfc> findHeartBCtfcs(QueryRequest request, HeartBCtfc heartBCtfc){
        try{
        LambdaQueryWrapper<HeartBCtfc> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCtfc.getUsername())) {
        queryWrapper.eq(HeartBCtfc::getUsername, heartBCtfc.getUsername());
        }
        queryWrapper.eq(HeartBCtfc::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCtfc> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCtfc(HeartBCtfc heartBCtfc){
        if(heartBCtfc.getId()==null) {
                heartBCtfc.setId(UUID.randomUUID().toString());
        }
        heartBCtfc.setCreateTime(new Date());
        heartBCtfc.setIsDeletemark(1);
        this.save(heartBCtfc);
        }

@Override
@Transactional
public void updateHeartBCtfc(HeartBCtfc heartBCtfc){
        heartBCtfc.setModifyTime(new Date());
        this.baseMapper.updateHeartBCtfc(heartBCtfc);
        }

@Override
@Transactional
public void deleteHeartBCtfcs(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        this.baseMapper.deleteBatchIds(list);
        }


        }