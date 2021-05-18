package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBSurgical;
import cc.mrbird.febs.heart.dao.HeartBSurgicalMapper;
import cc.mrbird.febs.heart.service.IHeartBSurgicalService;
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
 * 手术 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBSurgicalService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBSurgicalServiceImpl extends ServiceImpl<HeartBSurgicalMapper, HeartBSurgical> implements IHeartBSurgicalService {


@Override
public IPage<HeartBSurgical> findHeartBSurgicals(QueryRequest request, HeartBSurgical heartBSurgical){
        try{
        LambdaQueryWrapper<HeartBSurgical> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBSurgical.getUsername())) {
        queryWrapper.eq(HeartBSurgical::getUsername, heartBSurgical.getUsername());
        }
        queryWrapper.eq(HeartBSurgical::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBSurgical> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBSurgical(HeartBSurgical heartBSurgical){
        heartBSurgical.setId(UUID.randomUUID().toString());
        heartBSurgical.setCreateTime(new Date());
        heartBSurgical.setIsDeletemark(1);
        this.save(heartBSurgical);
        }

@Override
@Transactional
public void updateHeartBSurgical(HeartBSurgical heartBSurgical){
        heartBSurgical.setModifyTime(new Date());
        this.baseMapper.updateHeartBSurgical(heartBSurgical);
        }

@Override
@Transactional
public void deleteHeartBSurgicals(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBSurgical heartBSurgical =new HeartBSurgical();
        heartBSurgical.setId(id);
        heartBSurgical.setIsDeletemark(0);
        this.baseMapper.updateHeartBSurgical(heartBSurgical);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }