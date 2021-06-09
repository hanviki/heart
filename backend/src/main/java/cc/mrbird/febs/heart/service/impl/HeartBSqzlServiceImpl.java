package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBSqzl;
import cc.mrbird.febs.heart.dao.HeartBSqzlMapper;
import cc.mrbird.febs.heart.service.IHeartBSqzlService;
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
 * 术前资料 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
@Slf4j
@Service("IHeartBSqzlService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBSqzlServiceImpl extends ServiceImpl<HeartBSqzlMapper, HeartBSqzl> implements IHeartBSqzlService {


@Override
public IPage<HeartBSqzl> findHeartBSqzls(QueryRequest request, HeartBSqzl heartBSqzl){
        try{
        LambdaQueryWrapper<HeartBSqzl> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBSqzl.getUsername())) {
        queryWrapper.eq(HeartBSqzl::getUsername, heartBSqzl.getUsername());
        }
        queryWrapper.eq(HeartBSqzl::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBSqzl> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBSqzl(HeartBSqzl heartBSqzl){
        if(heartBSqzl.getId() ==null) {
                heartBSqzl.setId(UUID.randomUUID().toString());
        }
        heartBSqzl.setCreateTime(new Date());
        heartBSqzl.setIsDeletemark(1);
        this.save(heartBSqzl);
        }

@Override
@Transactional
public void updateHeartBSqzl(HeartBSqzl heartBSqzl){
        heartBSqzl.setModifyTime(new Date());
        this.baseMapper.updateHeartBSqzl(heartBSqzl);
        }

@Override
@Transactional
public void deleteHeartBSqzls(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBSqzl heartBSqzl =new HeartBSqzl();
        heartBSqzl.setId(id);
        heartBSqzl.setIsDeletemark(0);
        this.baseMapper.updateHeartBSqzl(heartBSqzl);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }