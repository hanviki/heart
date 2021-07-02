package cc.mrbird.febs.heart.dao;

import cc.mrbird.febs.heart.entity.HeartBPatientinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 * 病人信息表 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */
public interface HeartBPatientinfoMapper extends BaseMapper<HeartBPatientinfo> {
        void updateHeartBPatientinfo(HeartBPatientinfo heartBPatientinfo);

        @Delete("update heart_b_patientinfo set IS_DELETEMARK=0 where fileNo=#{fileNo}")
        void deleteByFileNo(@Param(value = "fileNo") String fileNo);
        }
