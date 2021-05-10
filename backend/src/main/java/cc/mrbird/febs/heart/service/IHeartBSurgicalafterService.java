package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBSurgicalafter;
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
public interface IHeartBSurgicalafterService extends IService<HeartBSurgicalafter> {

        IPage<HeartBSurgicalafter> findHeartBSurgicalafters(QueryRequest request, HeartBSurgicalafter heartBSurgicalafter);

        void createHeartBSurgicalafter(HeartBSurgicalafter heartBSurgicalafter);

        void updateHeartBSurgicalafter(HeartBSurgicalafter heartBSurgicalafter);

        void deleteHeartBSurgicalafters(String[]Ids);
        }
