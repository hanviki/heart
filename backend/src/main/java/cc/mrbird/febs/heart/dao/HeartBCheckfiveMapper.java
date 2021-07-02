package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBCheckfive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 凝血功能 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBCheckfiveMapper extends BaseMapper<HeartBCheckfive> {
        void updateHeartBCheckfive(HeartBCheckfive heartBCheckfive);

        @Delete("update heart_b_checkfive set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
