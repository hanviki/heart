package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBCheck;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 检验 服务类
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface IHeartBCheckService extends IService<HeartBCheck> {

        IPage<HeartBCheck> findHeartBChecks(QueryRequest request, HeartBCheck heartBCheck);

        void createHeartBCheck(HeartBCheck heartBCheck);

        void updateHeartBCheck(HeartBCheck heartBCheck);

        void deleteHeartBChecks(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
