package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 检验 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBCheckMapper extends BaseMapper<HeartBCheck> {
        void updateHeartBCheck(HeartBCheck heartBCheck);

        @Delete("update heart_b_check set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
