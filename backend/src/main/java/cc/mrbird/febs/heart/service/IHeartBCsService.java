package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCs;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 超声 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface IHeartBCsService extends IService<HeartBCs> {

        IPage<HeartBCs> findHeartBCss(QueryRequest request, HeartBCs heartBCs);

        void createHeartBCs(HeartBCs heartBCs);

        void updateHeartBCs(HeartBCs heartBCs);

        void deleteHeartBCss(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
