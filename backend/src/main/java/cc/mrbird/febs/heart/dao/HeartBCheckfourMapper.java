package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCheckfour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 肝肾功 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBCheckfourMapper extends BaseMapper<HeartBCheckfour> {
        void updateHeartBCheckfour(HeartBCheckfour heartBCheckfour);

        @Delete("update heart_b_checkfour set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
