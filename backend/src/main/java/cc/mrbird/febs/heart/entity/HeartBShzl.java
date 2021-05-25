package cc.mrbird.febs.heart.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
 * 术后资料
 * </p>
 *
 * @author viki
 * @since 2021-05-25
 */

@Excel("heart_b_shzl")
@Data
@Accessors(chain = true)
public class HeartBShzl implements Serializable{

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
     * 手术时间
     */
        
        @ExcelField(value ="手术时间", writeConverter = DateConverter.class)
    private Date ssDate;
    private transient String ssDateFrom;
    private transient String ssDateTo;

    /**
     * 术后入住ICU总天数
     */
        
        @ExcelField(value ="术后入住ICU总天数")
    private BigDecimal icuDay;

    /**
     * 再次入住ICU
     */
        
        @ExcelField(value ="再次入住ICU")
    private String icuAgain;

    /**
     * 嗜睡
     */
        
        @ExcelField(value ="嗜睡")
    private String shishui;

    /**
     * 嗜睡备注
     */
        
        @ExcelField(value ="嗜睡备注")
    private String shishuiNote;

    /**
     * 模糊
     */
        
        @ExcelField(value ="模糊")
    private String mohu;

    /**
     * 模糊备注
     */
        
        @ExcelField(value ="模糊备注")
    private String mohuNote;

    /**
     * 昏睡
     */
        
        @ExcelField(value ="昏睡")
    private String hunshui;

    /**
     * 昏睡备注
     */
        
        @ExcelField(value ="昏睡备注")
    private String hunshuiNote;

    /**
     * 昏迷
     */
        
        @ExcelField(value ="昏迷")
    private String hunmi;

    /**
     * 昏迷备注
     */
        
        @ExcelField(value ="昏迷备注")
    private String hunmiNote;

    /**
     * 谵妄
     */
        
        @ExcelField(value ="谵妄")
    private String zhanwang;

    /**
     * 谵妄备注
     */
        
        @ExcelField(value ="谵妄备注")
    private String zhanwangNote;

    /**
     * 意识状态备注
     */
        
        @ExcelField(value ="意识状态备注")
    private String ysztNote;

    /**
     * 有创机械通气时长
     */
        
        @ExcelField(value ="有创机械通气时长")
    private BigDecimal ycjxsc;

    /**
     * 无创辅助时间
     */
        
        @ExcelField(value ="无创辅助时间")
    private BigDecimal wcfzsjDay;

    /**
     * 无创辅助时间
     */
        
        @ExcelField(value ="无创辅助时间")
    private BigDecimal wcfzsjHour;

    /**
     * 无创辅助时间备注
     */
        
        @ExcelField(value ="无创辅助时间备注")
    private BigDecimal wcfzsjNote;

    /**
     * 疼痛评分CPOT/NRS
     */
        
        @ExcelField(value ="疼痛评分CPOT/NRS")
    private BigDecimal painScore;

    /**
     * RASS评分
     */
        
        @ExcelField(value ="RASS评分")
    private BigDecimal rass;

    /**
     * GCS评分
     */
        
        @ExcelField(value ="GCS评分")
    private BigDecimal gcs;

    /**
     * Braden评分
     */
        
        @ExcelField(value ="Braden评分")
    private BigDecimal braden;

    /**
     * 人工有创气道置管时间
     */
        
        @ExcelField(value ="人工有创气道置管时间")
    private BigDecimal rgcqdzHour;

    /**
     * 插管部位
     */
        
        @ExcelField(value ="插管部位")
    private String cgbw;

    /**
     * CVC留置时间
     */
        
        @ExcelField(value ="CVC留置时间")
    private BigDecimal cvc;

    /**
     * 留置部位
     */
        
        @ExcelField(value ="留置部位")
    private String lzbw;

    /**
     * 血透
     */
        
        @ExcelField(value ="血透")
    private String xuetou;

    /**
     * IABP置管时间
     */
        
        @ExcelField(value ="IABP置管时间")
    private String iabp;

    /**
     * 营养评估（NRS2002）
     */
        
        @ExcelField(value ="营养评估（NRS2002）")
    private BigDecimal nrs;

    /**
     * 肠内营养
     */
        
        @ExcelField(value ="肠内营养")
    private String cnyy;

    /**
     * 肠外营养
     */
        
        @ExcelField(value ="肠外营养")
    private String cwyy;

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

    public static final String SS_DATE ="ss_date" ;

    public static final String ICU_DAY ="icu_day" ;

    public static final String ICU_AGAIN ="icu_again" ;

    public static final String SHISHUI ="shishui" ;

    public static final String SHISHUI_NOTE ="shishui_note" ;

    public static final String MOHU ="mohu" ;

    public static final String MOHU_NOTE ="mohu_note" ;

    public static final String HUNSHUI ="hunshui" ;

    public static final String HUNSHUI_NOTE ="hunshui_note" ;

    public static final String HUNMI ="hunmi" ;

    public static final String HUNMI_NOTE ="hunmi_note" ;

    public static final String ZHANWANG ="zhanwang" ;

    public static final String ZHANWANG_NOTE ="zhanwang_note" ;

    public static final String YSZT_NOTE ="yszt_note" ;

    public static final String YCJXSC ="ycjxsc" ;

    public static final String WCFZSJ_DAY ="wcfzsj_day" ;

    public static final String WCFZSJ_HOUR ="wcfzsj_hour" ;

    public static final String WCFZSJ_NOTE ="wcfzsj_note" ;

    public static final String PAIN_SCORE ="pain_score" ;

    public static final String RASS ="rass" ;

    public static final String GCS ="gcs" ;

    public static final String BRADEN ="braden" ;

    public static final String RGCQDZ_HOUR ="rgcqdz_hour" ;

    public static final String CGBW ="cgbw" ;

    public static final String CVC ="cvc" ;

    public static final String LZBW ="lzbw" ;

    public static final String XUETOU ="xuetou" ;

    public static final String IABP ="iabp" ;

    public static final String NRS ="nrs" ;

    public static final String CNYY ="cnyy" ;

    public static final String CWYY ="cwyy" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }