package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBPatientinfo;
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
public interface IHeartBPatientinfoService extends IService<HeartBPatientinfo> {

        IPage<HeartBPatientinfo> findHeartBPatientinfos(QueryRequest request, HeartBPatientinfo heartBPatientinfo);

        void createHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo);

        void updateHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo);

        void deleteHeartBPatientinfos(String[]Ids);
        }
