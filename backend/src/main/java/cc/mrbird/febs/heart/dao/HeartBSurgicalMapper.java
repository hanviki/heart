package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBSurgical;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 手术 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBSurgicalMapper extends BaseMapper<HeartBSurgical> {
        void updateHeartBSurgical(HeartBSurgical heartBSurgical);

        @Delete("update heart_b_surgical set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
