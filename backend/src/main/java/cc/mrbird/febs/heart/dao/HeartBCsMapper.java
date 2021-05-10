package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 超声 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-06
 */
public interface HeartBCsMapper extends BaseMapper<HeartBCs> {
        void updateHeartBCs(HeartBCs heartBCs);
        }
