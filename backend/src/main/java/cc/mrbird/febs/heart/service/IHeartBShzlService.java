package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBShzl;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 术后资料 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
public interface IHeartBShzlService extends IService<HeartBShzl> {

        IPage<HeartBShzl> findHeartBShzls(QueryRequest request, HeartBShzl heartBShzl);

        void createHeartBShzl(HeartBShzl heartBShzl);

        void updateHeartBShzl(HeartBShzl heartBShzl);

        void deleteHeartBShzls(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
