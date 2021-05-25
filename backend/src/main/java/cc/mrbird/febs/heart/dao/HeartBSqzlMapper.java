package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBSqzl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 术前资料 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-25
 */
public interface HeartBSqzlMapper extends BaseMapper<HeartBSqzl> {
        void updateHeartBSqzl(HeartBSqzl heartBSqzl);

        @Delete("update heart_b_sqzl set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
