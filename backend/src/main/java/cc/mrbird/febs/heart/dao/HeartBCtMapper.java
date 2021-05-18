package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 术前CT Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBCtMapper extends BaseMapper<HeartBCt> {
        void updateHeartBCt(HeartBCt heartBCt);

        @Delete("update heart_b_ct set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
