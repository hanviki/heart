package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBChecktwo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 血常规 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface HeartBChecktwoMapper extends BaseMapper<HeartBChecktwo> {
        void updateHeartBChecktwo(HeartBChecktwo heartBChecktwo);

        @Delete("update heart_b_checktwo set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
