package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCtfc;
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
 * @since 2021-05-06
 */
public interface IHeartBCtfcService extends IService<HeartBCtfc> {

        IPage<HeartBCtfc> findHeartBCtfcs(QueryRequest request, HeartBCtfc heartBCtfc);

        void createHeartBCtfc(HeartBCtfc heartBCtfc);

        void updateHeartBCtfc(HeartBCtfc heartBCtfc);

        void deleteHeartBCtfcs(String[]Ids);
        }
