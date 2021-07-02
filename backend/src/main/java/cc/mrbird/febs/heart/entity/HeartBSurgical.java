package cc.mrbird.febs.heart.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import cc.mrbird.febs.common.converter.*;

/**
 * <p>
 * 手术
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_surgical")
@Data
@Accessors(chain = true)
public class HeartBSurgical implements Serializable{

private static final long serialVersionUID=1L;

    /**
     * 主键自增
     */
                            
        @ExcelField(value ="主键自增")
    private String id;

    /**
     * 用户帐号
     */
        
        @ExcelField(value ="用户帐号")
    private String username;

    /**
     * 病案号
     */
        
        @ExcelField(value ="病案号")
    private String fileNo;

    /**
     * 姓名
     */
        
        @ExcelField(value ="姓名")
    private String name;

    /**
     * 备注
     */
        
        @ExcelField(value ="备注")
    private String ssNote;

    /**
     * 手术日期和时间
     */
        
        @ExcelField(value ="手术日期和时间", writeConverter = DateConverter.class)
    private Date ssDate;
    private transient String ssDateFrom;
    private transient String ssDateTo;

    /**
     * 手术结束日期和时间
     */
        
        @ExcelField(value ="手术结束日期和时间", writeConverter = DateConverter.class)
    private Date ssDateend;
    private transient String ssDateendFrom;
    private transient String ssDateendTo;

    /**
     * 手术医生姓名
     */
        
        @ExcelField(value ="手术医生姓名")
    private String ssDoctor;

    /**
     * 助手1
     */
        
        @ExcelField(value ="助手1")
    private String ssAssitant1;

    /**
     * 助手2
     */
        
        @ExcelField(value ="助手2")
    private String ssAssitant2;

    /**
     * 助手3
     */
        
        @ExcelField(value ="助手3")
    private String ssAssitant3;

    /**
     * 助手4
     */
        
        @ExcelField(value ="助手4")
    private String ssAssitant4;

    /**
     * 助手5
     */
        
        @ExcelField(value ="助手5")
    private String ssAssitant5;

    /**
     * 主动脉手术方式
     */
        
        @ExcelField(value ="主动脉手术方式")
    private String ssZdmssfs;

    /**
     * 合并手术
     */
        
        @ExcelField(value ="合并手术")
    private String ssHbss;

    /**
     * 主动脉窦成形
     */
        
        @ExcelField(value ="主动脉窦成形")
    private String ssZdmdcx;

    /**
     * 主动脉瓣成形
     */
        
        @ExcelField(value ="主动脉瓣成形")
    private String ssZdmbcx;

    /**
     * 术中失血量
     */
        
        @ExcelField(value ="术中失血量")
    private BigDecimal ssSzsxl;

    /**
     * 红细胞输入量
     */
        
        @ExcelField(value ="红细胞输入量")
    private BigDecimal ssHxbsrl;

    /**
     * 血浆输入量
     */
        
        @ExcelField(value ="血浆输入量")
    private BigDecimal ssXjsrl;

    /**
     * 血小板输入量
     */
        
        @ExcelField(value ="血小板输入量")
    private BigDecimal ssXxbsrl;

    /**
     * CBP时间
     */
        
        @ExcelField(value ="CBP时间")
    private BigDecimal ssCbptime;

    /**
     * 主动脉阻断时间
     */
        
        @ExcelField(value ="主动脉阻断时间")
    private BigDecimal ssZdmzdsj;

    /**
     * 最低鼻咽温度
     */
        
        @ExcelField(value ="最低鼻咽温度")
    private BigDecimal ssZdbywd;

    /**
     * 深低温停循环时间
     */
        
        @ExcelField(value ="深低温停循环时间")
    private BigDecimal ssSdwtxhsj;

    /**
     * 最低直肠温
     */
        
        @ExcelField(value ="最低直肠温")
    private BigDecimal ssZdzcw;

    /**
     * 停跳液类型
     */
        
        @ExcelField(value ="停跳液类型")
    private String ttylx;

    /**
     * 停跳液使用量（ml）
     */
        
        @ExcelField(value ="停跳液使用量（ml）")
    private BigDecimal ttysyl;

    /**
     * 是否删除
     */
    @TableField("IS_DELETEMARK")
        
        @ExcelField(value ="是否删除")
    private Integer isDeletemark;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
        
        @ExcelField(value ="创建时间", writeConverter = DateConverter.class)
    private Date createTime;
    private transient String createTimeFrom;
    private transient String createTimeTo;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
        
        @ExcelField(value ="修改时间", writeConverter = DateConverter.class)
    private Date modifyTime;
    private transient String modifyTimeFrom;
    private transient String modifyTimeTo;

    /**
     * 创建人
     */
    @TableField("CREATE_USER_ID")
        
        @ExcelField(value ="创建人")
    private Long createUserId;

    /**
     * 修改人
     */
    @TableField("MODIFY_USER_ID")
        
        @ExcelField(value ="修改人")
    private Long modifyUserId;



    public static final String ID ="id" ;

    public static final String USERNAME ="username" ;

    public static final String FILE_NO ="file_no" ;

    public static final String NAME ="name" ;

    public static final String SS_NOTE ="ss_note" ;

    public static final String SS_DATE ="ss_date" ;

    public static final String SS_DATEEND ="ss_dateend" ;

    public static final String SS_DOCTOR ="ss_doctor" ;

    public static final String SS_ASSITANT1 ="ss_assitant1" ;

    public static final String SS_ASSITANT2 ="ss_assitant2" ;

    public static final String SS_ASSITANT3 ="ss_assitant3" ;

    public static final String SS_ASSITANT4 ="ss_assitant4" ;

    public static final String SS_ASSITANT5 ="ss_assitant5" ;

    public static final String SS_ZDMSSFS ="ss_zdmssfs" ;

    public static final String SS_HBSS ="ss_hbss" ;

    public static final String SS_ZDMDCX ="ss_zdmdcx" ;

    public static final String SS_ZDMBCX ="ss_zdmbcx" ;

    public static final String SS_SZSXL ="ss_szsxl" ;

    public static final String SS_HXBSRL ="ss_hxbsrl" ;

    public static final String SS_XJSRL ="ss_xjsrl" ;

    public static final String SS_XXBSRL ="ss_xxbsrl" ;

    public static final String SS_CBPTIME ="ss_cbptime" ;

    public static final String SS_ZDMZDSJ ="ss_zdmzdsj" ;

    public static final String SS_ZDBYWD ="ss_zdbywd" ;

    public static final String SS_SDWTXHSJ ="ss_sdwtxhsj" ;

    public static final String SS_ZDZCW ="ss_zdzcw" ;

    public static final String TTYLX ="ttylx" ;

    public static final String TTYSYL ="ttysyl" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }