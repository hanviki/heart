package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBPatientinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
public interface HeartBPatientinfoMapper extends BaseMapper<HeartBPatientinfo> {
        void updateHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo);
        }
