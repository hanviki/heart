package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCtout;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 出院复查CT6 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBCtoutMapper extends BaseMapper<HeartBCtout> {
        void updateHeartBCtout(HeartBCtout heartBCtout);

        @Delete("update heart_b_ctout set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
