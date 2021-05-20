package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBCs;
import cc.mrbird.febs.heart.dao.HeartBCsMapper;
import cc.mrbird.febs.heart.service.IHeartBCsService;
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
 * 超声 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
@Slf4j
@Service("IHeartBCsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBCsServiceImpl extends ServiceImpl<HeartBCsMapper, HeartBCs> implements IHeartBCsService {


@Override
public IPage<HeartBCs> findHeartBCss(QueryRequest request, HeartBCs heartBCs){
        try{
        LambdaQueryWrapper<HeartBCs> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBCs.getUsername())) {
        queryWrapper.eq(HeartBCs::getUsername, heartBCs.getUsername());
        }
        queryWrapper.eq(HeartBCs::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBCs> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBCs(HeartBCs heartBCs){
        if(heartBCs.getId() ==null) {
        heartBCs.setId(UUID.randomUUID().toString());
        }
        heartBCs.setCreateTime(new Date());
        heartBCs.setIsDeletemark(1);
        this.save(heartBCs);
        }

@Override
@Transactional
public void updateHeartBCs(HeartBCs heartBCs){
        heartBCs.setModifyTime(new Date());
        this.baseMapper.updateHeartBCs(heartBCs);
        }

@Override
@Transactional
public void deleteHeartBCss(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBCs heartBCs =new HeartBCs();
        heartBCs.setId(id);
        heartBCs.setIsDeletemark(0);
        this.baseMapper.updateHeartBCs(heartBCs);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }