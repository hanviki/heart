package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBShzl;
import cc.mrbird.febs.heart.dao.HeartBShzlMapper;
import cc.mrbird.febs.heart.service.IHeartBShzlService;
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
 * 术后资料 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
@Slf4j
@Service("IHeartBShzlService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBShzlServiceImpl extends ServiceImpl<HeartBShzlMapper, HeartBShzl> implements IHeartBShzlService {


@Override
public IPage<HeartBShzl> findHeartBShzls(QueryRequest request, HeartBShzl heartBShzl){
        try{
        LambdaQueryWrapper<HeartBShzl> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBShzl.getUsername())) {
        queryWrapper.eq(HeartBShzl::getUsername, heartBShzl.getUsername());
        }
        queryWrapper.eq(HeartBShzl::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBShzl> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBShzl(HeartBShzl heartBShzl){
        if(heartBShzl.getId() ==null) {
                heartBShzl.setId(UUID.randomUUID().toString());
        }
        heartBShzl.setCreateTime(new Date());
        heartBShzl.setIsDeletemark(1);
        this.save(heartBShzl);
        }

@Override
@Transactional
public void updateHeartBShzl(HeartBShzl heartBShzl){
        heartBShzl.setModifyTime(new Date());
        this.baseMapper.updateHeartBShzl(heartBShzl);
        }

@Override
@Transactional
public void deleteHeartBShzls(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBShzl heartBShzl =new HeartBShzl();
        heartBShzl.setId(id);
        heartBShzl.setIsDeletemark(0);
        this.baseMapper.updateHeartBShzl(heartBShzl);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }