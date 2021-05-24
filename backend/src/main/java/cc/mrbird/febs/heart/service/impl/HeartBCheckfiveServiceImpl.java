package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCheckfive;
import cc.mrbird.febs.heart.dao.HeartBCheckfiveMapper;
import cc.mrbird.febs.heart.service.IHeartBCheckfiveService;
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
 * 凝血功能 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
@Slf4j
@Service("IHeartBCheckfiveService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCheckfiveServiceImpl extends ServiceImpl<HeartBCheckfiveMapper, HeartBCheckfive> implements IHeartBCheckfiveService {


@Override
public IPage<HeartBCheckfive> findHeartBCheckfives(QueryRequest request, HeartBCheckfive heartBCheckfive){
        try{
        LambdaQueryWrapper<HeartBCheckfive> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCheckfive.getUsername())) {
        queryWrapper.eq(HeartBCheckfive::getUsername, heartBCheckfive.getUsername());
        }
        queryWrapper.eq(HeartBCheckfive::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCheckfive> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCheckfive(HeartBCheckfive heartBCheckfive){
        if(heartBCheckfive.getId() ==null) {
                heartBCheckfive.setId(UUID.randomUUID().toString());
        }
        heartBCheckfive.setCreateTime(new Date());
        heartBCheckfive.setIsDeletemark(1);
        this.save(heartBCheckfive);
        }

@Override
@Transactional
public void updateHeartBCheckfive(HeartBCheckfive heartBCheckfive){
        heartBCheckfive.setModifyTime(new Date());
        this.baseMapper.updateHeartBCheckfive(heartBCheckfive);
        }

@Override
@Transactional
public void deleteHeartBCheckfives(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCheckfive heartBCheckfive =new HeartBCheckfive();
        heartBCheckfive.setId(id);
        heartBCheckfive.setIsDeletemark(0);
        this.baseMapper.updateHeartBCheckfive(heartBCheckfive);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }