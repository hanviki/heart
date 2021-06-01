package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 心梗三项 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-28
 */
public interface HeartBCheckMapper extends BaseMapper<HeartBCheck> {
        void updateHeartBCheck(HeartBCheck heartBCheck);

        @Delete("update heart_b_check set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
