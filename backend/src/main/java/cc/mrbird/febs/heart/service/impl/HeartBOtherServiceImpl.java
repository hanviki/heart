package cc.mrbird.febs.heart.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.heart.entity.HeartBOther;
import cc.mrbird.febs.heart.dao.HeartBOtherMapper;
import cc.mrbird.febs.heart.service.IHeartBOtherService;
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
 * 其他 服务实现类
 * </p>
 *
 * @author viki
 * @since 2021-06-07
 */
@Slf4j
@Service("IHeartBOtherService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HeartBOtherServiceImpl extends ServiceImpl<HeartBOtherMapper, HeartBOther> implements IHeartBOtherService {


@Override
public IPage<HeartBOther> findHeartBOthers(QueryRequest request, HeartBOther heartBOther){
        try{
        LambdaQueryWrapper<HeartBOther> queryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(heartBOther.getUsername())) {
        queryWrapper.eq(HeartBOther::getUsername, heartBOther.getUsername());
        }
        queryWrapper.eq(HeartBOther::getIsDeletemark, 1);//1是未删 0是已删
        Page<HeartBOther> page=new Page<>();
        SortUtil.handlePageSort(request,page,true);
        return this.page(page,queryWrapper);
        }catch(Exception e){
        log.error("获取字典信息失败" ,e);
        return null;
        }
        }

@Override
@Transactional
public void createHeartBOther(HeartBOther heartBOther){
       // heartBOther.setId(UUID.randomUUID().toString());
        if(heartBOther.getId() ==null) {
                heartBOther.setId(UUID.randomUUID().toString());
        }
        heartBOther.setCreateTime(new Date());
        heartBOther.setIsDeletemark(1);
        this.save(heartBOther);
        }

@Override
@Transactional
public void updateHeartBOther(HeartBOther heartBOther){
        heartBOther.setModifyTime(new Date());
        this.baseMapper.updateHeartBOther(heartBOther);
        }

@Override
@Transactional
public void deleteHeartBOthers(String[]Ids){
        List<String> list=Arrays.asList(Ids);
        for (String id: list
        ) {
        HeartBOther heartBOther =new HeartBOther();
        heartBOther.setId(id);
        heartBOther.setIsDeletemark(0);
        this.baseMapper.updateHeartBOther(heartBOther);
        }
        }

@Override
@Transactional
public  void deleteByFileNo(String fileNo){
        this.baseMapper.deleteByFileNo(fileNo);
        }
        }