package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCsfc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
public interface HeartBCsfcMapper extends BaseMapper<HeartBCsfc> {
        void updateHeartBCsfc(HeartBCsfc heartBCsfc);
        }
