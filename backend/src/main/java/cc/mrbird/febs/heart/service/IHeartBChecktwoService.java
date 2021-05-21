package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBChecktwo;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 血常规 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface IHeartBChecktwoService extends IService<HeartBChecktwo> {

        IPage<HeartBChecktwo> findHeartBChecktwos(QueryRequest request, HeartBChecktwo heartBChecktwo);

        void createHeartBChecktwo(HeartBChecktwo heartBChecktwo);

        void updateHeartBChecktwo(HeartBChecktwo heartBChecktwo);

        void deleteHeartBChecktwos(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
