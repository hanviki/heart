package cc.mrbird.febs.heart.service;

import cc.mrbird.febs.heart.entity.HeartBOther;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 其他 服务类
 * </p>
 *
 * @author viki
 * @since 2021-06-07
 */
public interface IHeartBOtherService extends IService<HeartBOther> {

        IPage<HeartBOther> findHeartBOthers(QueryRequest request, HeartBOther heartBOther);

        void createHeartBOther(HeartBOther heartBOther);

        void updateHeartBOther(HeartBOther heartBOther);

        void deleteHeartBOthers(String[]Ids);

        void deleteByFileNo(String fileNo);
        }
