package cc.mrbird.febs.heart.entity;

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
 * 病人信息表
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_patientinfo")
@Data
@Accessors(chain = true)
public class HeartBPatientinfo implements Serializable{

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
     * 年龄
     */
        
        @ExcelField(value ="年龄")
    private Integer age;

    /**
     * 性别
     */
        
        @ExcelField(value ="性别")
    private Boolean gender;

    /**
     * 身高
     */
        
        @ExcelField(value ="身高")
    private Integer height;

    /**
     * 体重
     */
        
        @ExcelField(value ="体重")
    private Integer weight;

    /**
     * 省
     */
        
        @ExcelField(value ="省")
    private String province;

    /**
     * 市
     */
        
        @ExcelField(value ="市")
    private String city;

    /**
     * 区
     */
        
        @ExcelField(value ="区")
    private String area;

    /**
     * 详细地址
     */
        
        @ExcelField(value ="详细地址")
    private String address;

    /**
     * 联系方式
     */
        
        @ExcelField(value ="联系方式")
    private String telphone;

    /**
     * 入诊日期和时间
     */
        
        @ExcelField(value ="入诊日期和时间", writeConverter = DateConverter.class)
    private Date inCheck;
    private transient String inCheckFrom;
    private transient String inCheckTo;

    /**
     * 年
     */
        
        @ExcelField(value ="年")
    private Integer toYear;

    /**
     * 月
     */
        
        @ExcelField(value ="月")
    private Integer toMonth;

    /**
     * 日
     */
        
        @ExcelField(value ="日")
    private Integer toDay;

    /**
     * 小时
     */
        
        @ExcelField(value ="小时")
    private Integer toHour;

    /**
     * 分钟
     */
        
        @ExcelField(value ="分钟")
    private Integer toMinutes;

    /**
     * 发病-就诊时间
     */
        
        @ExcelField(value ="发病-就诊时间")
    private String toCheck;

    /**
     * 疼痛部位
     */
        
        @ExcelField(value ="疼痛部位")
    private String painPos;

    /**
     * 症状和体征
     */
        
        @ExcelField(value ="症状和体征")
    private String symptoms;

    /**
     * 症状和体征
     */
        
        @ExcelField(value ="症状和体征")
    private String otherSymptoms;

    /**
     * 急诊转归
     */
        
        @ExcelField(value ="急诊转归")
    private String emergency;

    /**
     * 死亡原因
     */
        
        @ExcelField(value ="死亡原因")
    private String deathCause;

    /**
     * 死亡时间
     */
        
        @ExcelField(value ="死亡时间", writeConverter = DateConverter.class)
    private Date deathDate;
    private transient String deathDateFrom;
    private transient String deathDateTo;

    /**
     * 急诊转归备注
     */
        
        @ExcelField(value ="急诊转归备注")
    private String emergencyNote;

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

    /**
     * 主诉
     */
        
        @ExcelField(value ="主诉")
    private String zhusu;



    public static final String ID ="id" ;

    public static final String USERNAME ="username" ;

    public static final String FILE_NO ="file_no" ;

    public static final String NAME ="name" ;

    public static final String AGE ="age" ;

    public static final String GENDER ="gender" ;

    public static final String HEIGHT ="height" ;

    public static final String WEIGHT ="weight" ;

    public static final String PROVINCE ="province" ;

    public static final String CITY ="city" ;

    public static final String AREA ="area" ;

    public static final String ADDRESS ="address" ;

    public static final String TELPHONE ="telphone" ;

    public static final String IN_CHECK ="in_check" ;

    public static final String TO_YEAR ="to_year" ;

    public static final String TO_MONTH ="to_month" ;

    public static final String TO_DAY ="to_day" ;

    public static final String TO_HOUR ="to_hour" ;

    public static final String TO_MINUTES ="to_minutes" ;

    public static final String TO_CHECK ="to_check" ;

    public static final String PAIN_POS ="pain_pos" ;

    public static final String SYMPTOMS ="symptoms" ;

    public static final String OTHER_SYMPTOMS ="other_symptoms" ;

    public static final String EMERGENCY ="emergency" ;

    public static final String DEATH_CAUSE ="death_cause" ;

    public static final String DEATH_DATE ="death_date" ;

    public static final String EMERGENCY_NOTE ="emergency_note" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

    public static final String ZHUSU ="zhusu" ;

        }