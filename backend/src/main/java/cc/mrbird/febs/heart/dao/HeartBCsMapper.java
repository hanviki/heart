package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 超声 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBCsMapper extends BaseMapper<HeartBCs> {
        void updateHeartBCs(HeartBCs heartBCs);

        @Delete("update heart_b_cs set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
