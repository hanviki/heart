package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBSqzl;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 术前资料 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
public interface IHeartBSqzlService extends IService<HeartBSqzl> {

        IPage<HeartBSqzl> findHeartBSqzls(QueryRequest request, HeartBSqzl heartBSqzl);

        void createHeartBSqzl(HeartBSqzl heartBSqzl);

        void updateHeartBSqzl(HeartBSqzl heartBSqzl);

        void deleteHeartBSqzls(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
