package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCsfc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 超声复查 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBCsfcMapper extends BaseMapper<HeartBCsfc> {
        void updateHeartBCsfc(HeartBCsfc heartBCsfc);

        @Delete("update heart_b_csfc set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
