package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBHyfc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 化验复查 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBHyfcMapper extends BaseMapper<HeartBHyfc> {
        void updateHeartBHyfc(HeartBHyfc heartBHyfc);

        @Delete("update heart_b_hyfc set IS_DELETEMARK=0 where file_no=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
