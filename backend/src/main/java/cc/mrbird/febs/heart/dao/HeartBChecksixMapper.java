package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBChecksix;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBChecksixMapper extends BaseMapper<HeartBChecksix> {
        void updateHeartBChecksix(HeartBChecksix heartBChecksix);

        @Delete("update heart_b_checksix set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
