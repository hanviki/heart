package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCt;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 术前CT 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface IHeartBCtService extends IService<HeartBCt> {

        IPage<HeartBCt> findHeartBCts(QueryRequest request, HeartBCt heartBCt);

        void createHeartBCt(HeartBCt heartBCt);

        void updateHeartBCt(HeartBCt heartBCt);

        void deleteHeartBCts(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
