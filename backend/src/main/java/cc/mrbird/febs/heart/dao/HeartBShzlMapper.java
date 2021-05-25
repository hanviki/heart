package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBShzl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 术后资料 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-25
 */
public interface HeartBShzlMapper extends BaseMapper<HeartBShzl> {
        void updateHeartBShzl(HeartBShzl heartBShzl);

        @Delete("update heart_b_shzl set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
