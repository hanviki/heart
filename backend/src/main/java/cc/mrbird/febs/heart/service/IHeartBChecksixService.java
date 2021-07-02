package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBChecksix;
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
 * @since 2021-06-22
 */
public interface IHeartBChecksixService extends IService<HeartBChecksix> {

        IPage<HeartBChecksix> findHeartBChecksixs(QueryRequest request, HeartBChecksix heartBChecksix);

        void createHeartBChecksix(HeartBChecksix heartBChecksix);

        void updateHeartBChecksix(HeartBChecksix heartBChecksix);

        void deleteHeartBChecksixs(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
