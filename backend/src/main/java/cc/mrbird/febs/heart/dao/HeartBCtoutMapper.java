package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCtout;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
public interface HeartBCtoutMapper extends BaseMapper<HeartBCtout> {
        void updateHeartBCtout(HeartBCtout heartBCtout);
        }
