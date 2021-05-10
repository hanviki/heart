package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCtfc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-06
 */
public interface HeartBCtfcMapper extends BaseMapper<HeartBCtfc> {
        void updateHeartBCtfc(HeartBCtfc heartBCtfc);
        }
