package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBShzlxq;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 血气结果 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
public interface IHeartBShzlxqService extends IService<HeartBShzlxq> {

        IPage<HeartBShzlxq> findHeartBShzlxqs(QueryRequest request, HeartBShzlxq heartBShzlxq);

        void createHeartBShzlxq(HeartBShzlxq heartBShzlxq);

        void updateHeartBShzlxq(HeartBShzlxq heartBShzlxq);

        void deleteHeartBShzlxqs(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
