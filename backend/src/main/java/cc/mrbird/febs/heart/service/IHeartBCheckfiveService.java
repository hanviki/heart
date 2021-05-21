package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCheckfive;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 凝血功能 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface IHeartBCheckfiveService extends IService<HeartBCheckfive> {

        IPage<HeartBCheckfive> findHeartBCheckfives(QueryRequest request, HeartBCheckfive heartBCheckfive);

        void createHeartBCheckfive(HeartBCheckfive heartBCheckfive);

        void updateHeartBCheckfive(HeartBCheckfive heartBCheckfive);

        void deleteHeartBCheckfives(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
