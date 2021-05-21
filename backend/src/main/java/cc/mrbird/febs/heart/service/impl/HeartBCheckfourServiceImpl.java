package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCheckfour;
import cc.mrbird.febs.heart.dao.HeartBCheckfourMapper;
import cc.mrbird.febs.heart.service.IHeartBCheckfourService;
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
 * 肝肾功 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
@Slf4j
@Service("IHeartBCheckfourService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCheckfourServiceImpl extends ServiceImpl<HeartBCheckfourMapper, HeartBCheckfour> implements IHeartBCheckfourService {


@Override
public IPage<HeartBCheckfour> findHeartBCheckfours(QueryRequest request, HeartBCheckfour heartBCheckfour){
        try{
        LambdaQueryWrapper<HeartBCheckfour> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCheckfour.getUsername())) {
        queryWrapper.eq(HeartBCheckfour::getUsername, heartBCheckfour.getUsername());
        }
        queryWrapper.eq(HeartBCheckfour::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCheckfour> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCheckfour(HeartBCheckfour heartBCheckfour){
        heartBCheckfour.setId(UUID.randomUUID().toString());
        heartBCheckfour.setCreateTime(new Date());
        heartBCheckfour.setIsDeletemark(1);
        this.save(heartBCheckfour);
        }

@Override
@Transactional
public void updateHeartBCheckfour(HeartBCheckfour heartBCheckfour){
        heartBCheckfour.setModifyTime(new Date());
        this.baseMapper.updateHeartBCheckfour(heartBCheckfour);
        }

@Override
@Transactional
public void deleteHeartBCheckfours(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCheckfour heartBCheckfour =new HeartBCheckfour();
        heartBCheckfour.setId(id);
        heartBCheckfour.setIsDeletemark(0);
        this.baseMapper.updateHeartBCheckfour(heartBCheckfour);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }