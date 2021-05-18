package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBSurgicalafter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 术后 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-05-18
 */
public interface HeartBSurgicalafterMapper extends BaseMapper<HeartBSurgicalafter> {
        void updateHeartBSurgicalafter(HeartBSurgicalafter heartBSurgicalafter);

        @Delete("update heart_b_surgicalafter set IS_DELETEMARK=0 where file_no=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
