package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBHospitalinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */
public interface HeartBHospitalinfoMapper extends BaseMapper<HeartBHospitalinfo> {
        void updateHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo);
        }
