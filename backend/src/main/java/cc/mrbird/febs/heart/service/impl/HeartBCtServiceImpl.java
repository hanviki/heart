package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCt;
import cc.mrbird.febs.heart.dao.HeartBCtMapper;
import cc.mrbird.febs.heart.service.IHeartBCtService;
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
 * 术前CT 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBCtService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCtServiceImpl extends ServiceImpl<HeartBCtMapper, HeartBCt> implements IHeartBCtService {


@Override
public IPage<HeartBCt> findHeartBCts(QueryRequest request, HeartBCt heartBCt){
        try{
        LambdaQueryWrapper<HeartBCt> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCt.getUsername())) {
        queryWrapper.eq(HeartBCt::getUsername, heartBCt.getUsername());
        }
        queryWrapper.eq(HeartBCt::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCt> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCt(HeartBCt heartBCt){
        if(heartBCt.getId() ==null) {
                heartBCt.setId(UUID.randomUUID().toString());
        }
        heartBCt.setCreateTime(new Date());
        heartBCt.setIsDeletemark(1);
        this.save(heartBCt);
        }

@Override
@Transactional
public void updateHeartBCt(HeartBCt heartBCt){
        heartBCt.setModifyTime(new Date());
        this.baseMapper.updateHeartBCt(heartBCt);
        }

@Override
@Transactional
public void deleteHeartBCts(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCt heartBCt =new HeartBCt();
        heartBCt.setId(id);
        heartBCt.setIsDeletemark(0);
        this.baseMapper.updateHeartBCt(heartBCt);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }