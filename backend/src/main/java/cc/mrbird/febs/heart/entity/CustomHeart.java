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
    private transient HeartBHospitalinfo hospitalInfo; //个人信息 1
    private transient  HeartBPatientinfo patientInfo; //病人信息表 2
    private transient  HeartBCheck checkInfo; //检验 3
    private transient HeartBCs csInfo; //超声 4
    private transient HeartBCt ctInfo; //术前CT 5
    private transient HeartBCtout outInfo; //出院复查CT 6
    private transient HeartBSurgical surgicalInfo; //手术 7
    private transient  HeartBSurgicalafter  surAfterInfo;//术后 8
    private transient List<HeartBCsfc> fcInfo; //超声复查 8.2
    private transient List<HeartBCtfc> fcctInfo;//CT复查 8.3
    private transient  List<HeartBHyfc> fchyInfo; //化验复查 8.4
}
