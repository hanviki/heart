package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCheckthree;
import cc.mrbird.febs.heart.dao.HeartBCheckthreeMapper;
import cc.mrbird.febs.heart.service.IHeartBCheckthreeService;
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
 * 血气分析 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
@Slf4j
@Service("IHeartBCheckthreeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCheckthreeServiceImpl extends ServiceImpl<HeartBCheckthreeMapper, HeartBCheckthree> implements IHeartBCheckthreeService {


@Override
public IPage<HeartBCheckthree> findHeartBCheckthrees(QueryRequest request, HeartBCheckthree heartBCheckthree){
        try{
        LambdaQueryWrapper<HeartBCheckthree> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCheckthree.getUsername())) {
        queryWrapper.eq(HeartBCheckthree::getUsername, heartBCheckthree.getUsername());
        }
        queryWrapper.eq(HeartBCheckthree::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCheckthree> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCheckthree(HeartBCheckthree heartBCheckthree){
        heartBCheckthree.setId(UUID.randomUUID().toString());
        heartBCheckthree.setCreateTime(new Date());
        heartBCheckthree.setIsDeletemark(1);
        this.save(heartBCheckthree);
        }

@Override
@Transactional
public void updateHeartBCheckthree(HeartBCheckthree heartBCheckthree){
        heartBCheckthree.setModifyTime(new Date());
        this.baseMapper.updateHeartBCheckthree(heartBCheckthree);
        }

@Override
@Transactional
public void deleteHeartBCheckthrees(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCheckthree heartBCheckthree =new HeartBCheckthree();
        heartBCheckthree.setId(id);
        heartBCheckthree.setIsDeletemark(0);
        this.baseMapper.updateHeartBCheckthree(heartBCheckthree);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }