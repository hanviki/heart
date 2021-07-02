package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBHospitalinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 住院病历资料 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBHospitalinfoMapper extends BaseMapper<HeartBHospitalinfo> {
        void updateHeartBHospitalinfo(HeartBHospitalinfo heartBHospitalinfo);

        @Delete("update heart_b_hospitalinfo set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
