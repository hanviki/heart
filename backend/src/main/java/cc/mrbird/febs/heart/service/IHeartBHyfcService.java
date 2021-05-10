package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBHyfc;
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
public interface IHeartBHyfcService extends IService<HeartBHyfc> {

        IPage<HeartBHyfc> findHeartBHyfcs(QueryRequest request, HeartBHyfc heartBHyfc);

        void createHeartBHyfc(HeartBHyfc heartBHyfc);

        void updateHeartBHyfc(HeartBHyfc heartBHyfc);

        void deleteHeartBHyfcs(String[]Ids);
        }
