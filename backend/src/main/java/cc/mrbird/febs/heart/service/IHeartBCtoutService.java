package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCtout;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 出院复查CT6 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface IHeartBCtoutService extends IService<HeartBCtout> {

        IPage<HeartBCtout> findHeartBCtouts(QueryRequest request, HeartBCtout heartBCtout);

        void createHeartBCtout(HeartBCtout heartBCtout);

        void updateHeartBCtout(HeartBCtout heartBCtout);

        void deleteHeartBCtouts(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
