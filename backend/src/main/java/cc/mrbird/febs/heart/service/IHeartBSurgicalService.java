package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBSurgical;
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
public interface IHeartBSurgicalService extends IService<HeartBSurgical> {

        IPage<HeartBSurgical> findHeartBSurgicals(QueryRequest request, HeartBSurgical heartBSurgical);

        void createHeartBSurgical(HeartBSurgical heartBSurgical);

        void updateHeartBSurgical(HeartBSurgical heartBSurgical);

        void deleteHeartBSurgicals(String[]Ids);
        }
