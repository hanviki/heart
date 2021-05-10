package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBHospitalinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
public interface IHeartBHospitalinfoService extends IService<HeartBHospitalinfo> {

        IPage<HeartBHospitalinfo> findHeartBHospitalinfos(QueryRequest request, HeartBHospitalinfo heartBHospitalinfo);

        void createHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo);

        void updateHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo);

        void deleteHeartBHospitalinfos(String[]Ids);
        }
