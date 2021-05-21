package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCheckfour;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 肝肾功 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface IHeartBCheckfourService extends IService<HeartBCheckfour> {

        IPage<HeartBCheckfour> findHeartBCheckfours(QueryRequest request, HeartBCheckfour heartBCheckfour);

        void createHeartBCheckfour(HeartBCheckfour heartBCheckfour);

        void updateHeartBCheckfour(HeartBCheckfour heartBCheckfour);

        void deleteHeartBCheckfours(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
