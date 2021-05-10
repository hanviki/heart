package cc.mrbird.febs.heart.entity;

import lombok.Data;

import java.util.List;

/**
 * IDEA2019
 *
 * @Auther: hsc
 * @Date: 2021/05/08/16:08
 * @Description:
 */
@Data
public class CustomHeart {
    private transient HeartBHospitalinfo hospitalInfo;
    private transient  HeartBCheck checkInfo;
    private transient HeartBCs csInfo;
    private transient List<HeartBCsfc> fcInfo;
    private transient HeartBCt ctInfo;
    private transient List<HeartBCtfc> fcctInfo;
    private transient HeartBCtout outInfo;
    private transient  List<HeartBHyfc> fchyInfo;
    private transient  HeartBPatientinfo patientInfo;
    private  transient HeartBSurgical surgicalInfo;
    private transient  HeartBSurgicalafter  surAfterInfo;
}
