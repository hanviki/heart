package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCtfc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * CT复查 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBCtfcMapper extends BaseMapper<HeartBCtfc> {
        void updateHeartBCtfc(HeartBCtfc heartBCtfc);

        @Delete("update heart_b_ctfc set IS_DELETEMARK=0 where file_no=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
