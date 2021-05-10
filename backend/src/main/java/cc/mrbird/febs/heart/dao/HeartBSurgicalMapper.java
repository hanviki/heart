package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBSurgical;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-06
 */
public interface HeartBSurgicalMapper extends BaseMapper<HeartBSurgical> {
        void updateHeartBSurgical(HeartBSurgical heartBSurgical);
        }
