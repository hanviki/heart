package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBHyfc;
import cc.mrbird.febs.heart.dao.HeartBHyfcMapper;
import cc.mrbird.febs.heart.service.IHeartBHyfcService;
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
 * 化验复查 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBHyfcService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBHyfcServiceImpl extends ServiceImpl<HeartBHyfcMapper, HeartBHyfc> implements IHeartBHyfcService {


@Override
public IPage<HeartBHyfc> findHeartBHyfcs(QueryRequest request, HeartBHyfc heartBHyfc){
        try{
        LambdaQueryWrapper<HeartBHyfc> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBHyfc.getUsername())) {
        queryWrapper.eq(HeartBHyfc::getUsername, heartBHyfc.getUsername());
        }
        queryWrapper.eq(HeartBHyfc::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBHyfc> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBHyfc(HeartBHyfc heartBHyfc){
        heartBHyfc.setId(UUID.randomUUID().toString());
        heartBHyfc.setCreateTime(new Date());
        heartBHyfc.setIsDeletemark(1);
        this.save(heartBHyfc);
        }

@Override
@Transactional
public void updateHeartBHyfc(HeartBHyfc heartBHyfc){
        heartBHyfc.setModifyTime(new Date());
        this.baseMapper.updateHeartBHyfc(heartBHyfc);
        }

@Override
@Transactional
public void deleteHeartBHyfcs(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBHyfc heartBHyfc =new HeartBHyfc();
        heartBHyfc.setId(id);
        heartBHyfc.setIsDeletemark(0);
        this.baseMapper.updateHeartBHyfc(heartBHyfc);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }