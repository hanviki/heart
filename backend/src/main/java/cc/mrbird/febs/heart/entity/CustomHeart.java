package cc.mrbird.febs.heart.entity;

import cc.mrbird.febs.heart.controller.HeartBShzlxqController;
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
    private transient  List<HeartBCheck> checkInfo; //检验 3
    private transient  List<HeartBChecktwo> checkTwoInfo; //检验 3
    private transient  List<HeartBCheckthree> checkThreeInfo; //检验 3
    private transient  List<HeartBCheckfour> checkFourInfo; //检验 3
    private transient  List<HeartBCheckfive> checkFiveInfo; //检验 3
    private transient  List<HeartBChecksix> checkSixInfo; //检验 3
    private transient List<HeartBCs> csInfo; //超声 4
    private transient List<HeartBCt> ctInfo; //术前CT 5
    private transient List<HeartBCtout> outInfo; //出院复查CT 6
    private transient HeartBSurgical surgicalInfo; //手术 7
    private transient  HeartBSurgicalafter  surAfterInfo;//术后 8
    private transient List<HeartBCsfc> fcInfo; //超声复查 8.2
    private transient List<HeartBCtfc> fcctInfo;//CT复查 8.3
    private transient  List<HeartBHyfc> fchyInfo; //化验复查 8.4
    private transient  List<HeartBShzlxq> shzlxqsInfo;
    private transient  HeartBShzl shzlInfo;
    private transient  HeartBSqzl sqzlInfo;
    private transient List<HeartBOther> otherInfo; //其他
}
