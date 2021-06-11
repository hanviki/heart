package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBChecktwo;
import cc.mrbird.febs.heart.dao.HeartBChecktwoMapper;
import cc.mrbird.febs.heart.service.IHeartBChecktwoService;
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
 * 血常规 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
@Slf4j
@Service("IHeartBChecktwoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBChecktwoServiceImpl extends ServiceImpl<HeartBChecktwoMapper, HeartBChecktwo> implements IHeartBChecktwoService {


@Override
public IPage<HeartBChecktwo> findHeartBChecktwos(QueryRequest request, HeartBChecktwo heartBChecktwo){
        try{
        LambdaQueryWrapper<HeartBChecktwo> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBChecktwo.getUsername())) {
        queryWrapper.eq(HeartBChecktwo::getUsername, heartBChecktwo.getUsername());
        }
        queryWrapper.eq(HeartBChecktwo::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBChecktwo> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBChecktwo(HeartBChecktwo heartBChecktwo){
        if(!StringUtils.isNotBlank(heartBChecktwo.getId())) {
                heartBChecktwo.setId(UUID.randomUUID().toString());
        }
        heartBChecktwo.setCreateTime(new Date());
        heartBChecktwo.setIsDeletemark(1);
        this.save(heartBChecktwo);
        }

@Override
@Transactional
public void updateHeartBChecktwo(HeartBChecktwo heartBChecktwo){
        heartBChecktwo.setModifyTime(new Date());
        this.baseMapper.updateHeartBChecktwo(heartBChecktwo);
        }

@Override
@Transactional
public void deleteHeartBChecktwos(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBChecktwo heartBChecktwo =new HeartBChecktwo();
        heartBChecktwo.setId(id);
        heartBChecktwo.setIsDeletemark(0);
        this.baseMapper.updateHeartBChecktwo(heartBChecktwo);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }