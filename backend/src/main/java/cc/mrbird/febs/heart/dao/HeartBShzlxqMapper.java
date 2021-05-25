package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBShzlxq;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 血气结果 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */
public interface HeartBShzlxqMapper extends BaseMapper<HeartBShzlxq> {
        void updateHeartBShzlxq(HeartBShzlxq heartBShzlxq);

        @Delete("update heart_b_shzlxq set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
