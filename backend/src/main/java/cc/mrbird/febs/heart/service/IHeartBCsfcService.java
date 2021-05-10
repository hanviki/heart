package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCsfc;
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
public interface IHeartBCsfcService extends IService<HeartBCsfc> {

        IPage<HeartBCsfc> findHeartBCsfcs(QueryRequest request, HeartBCsfc heartBCsfc);

        void createHeartBCsfc(HeartBCsfc heartBCsfc);

        void updateHeartBCsfc(HeartBCsfc heartBCsfc);

        void deleteHeartBCsfcs(String[]Ids);
        }
