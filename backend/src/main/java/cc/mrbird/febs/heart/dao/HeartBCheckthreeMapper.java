package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCheckthree;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 血气分析 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */
public interface HeartBCheckthreeMapper extends BaseMapper<HeartBCheckthree> {
        void updateHeartBCheckthree(HeartBCheckthree heartBCheckthree);

        @Delete("update heart_b_checkthree set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
