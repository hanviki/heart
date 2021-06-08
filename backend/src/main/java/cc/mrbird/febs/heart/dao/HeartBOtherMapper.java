package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBOther;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 其他 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-07
 */
public interface HeartBOtherMapper extends BaseMapper<HeartBOther> {
        void updateHeartBOther(HeartBOther heartBOther);

        @Delete("update heart_b_other set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
