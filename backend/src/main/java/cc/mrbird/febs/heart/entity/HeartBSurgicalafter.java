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
 * 
 * </p>
 *
 * @author viki
 * @since 2021-04-29
 */

@Excel("heart_b_surgicalafter")
@Data
@Accessors(chain = true)
public class HeartBSurgicalafter implements Serializable{

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
     * 累计辅助通气时间
     */
        
        @ExcelField(value ="累计辅助通气时间")
    private BigDecimal shLjfztqsj;

    /**
     * 再次气管插管
     */
        
        @ExcelField(value ="再次气管插管")
    private BigDecimal shZcqgcg;

    /**
     * 术后ICU停留时间
     */
        
        @ExcelField(value ="术后ICU停留时间")
    private BigDecimal shShicutime;

    /**
     * 再次进入ICU
     */
        
        @ExcelField(value ="再次进入ICU")
    private String shZcicu;

    /**
     * 再次ICU停留时间
     */
        
        @ExcelField(value ="再次ICU停留时间")
    private BigDecimal shZcicutime;

    /**
     * 术后开胸止血
     */
        
        @ExcelField(value ="术后开胸止血")
    private BigDecimal shShkxzx;

    /**
     * 其他再次手术原因
     */
        
        @ExcelField(value ="其他再次手术原因")
    private String shQtzcssyy;

    /**
     * 术后并发症
     */
        
        @ExcelField(value ="术后并发症")
    private String shShbfz;

    /**
     * 备注
     */
        
        @ExcelField(value ="备注")
    private String shNote;

    /**
     * 主诉
     */
        
        @ExcelField(value ="主诉")
    private String shsfZs;

    /**
     * 生存状态
     */
        
        @ExcelField(value ="生存状态")
    private String shsfSczt;

    /**
     * 死亡原因
     */
        
        @ExcelField(value ="死亡原因")
    private String shsfDeath;

    /**
     * 死亡日期
     */
        
        @ExcelField(value ="死亡日期", writeConverter = DateConverter.class)
    private Date shsfDeathDate;
    private transient String shsfDeathDateFrom;
    private transient String shsfDeathDateTo;

    /**
     * 心血管再次干预
     */
        
        @ExcelField(value ="心血管再次干预")
    private String shsfXxgzcgy;

    /**
     * 再次干预时间
     */
        
        @ExcelField(value ="再次干预时间", writeConverter = DateConverter.class)
    private Date shsfZcgysj;
    private transient String shsfZcgysjFrom;
    private transient String shsfZcgysjTo;

    /**
     * 新发疾病
     */
        
        @ExcelField(value ="新发疾病")
    private String shsfXfjb;

    /**
     * 新发疾病时间
     */
        
        @ExcelField(value ="新发疾病时间", writeConverter = DateConverter.class)
    private Date shsfXfjbsj;
    private transient String shsfXfjbsjFrom;
    private transient String shsfXfjbsjTo;

    /**
     * 其他并发症
     */
        
        @ExcelField(value ="其他并发症")
    private String shsfQtbfz;

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

    public static final String SH_LJFZTQSJ ="sh_ljfztqsj" ;

    public static final String SH_ZCQGCG ="sh_zcqgcg" ;

    public static final String SH_SHICUTIME ="sh_shicutime" ;

    public static final String SH_ZCICU ="sh_zcicu" ;

    public static final String SH_ZCICUTIME ="sh_zcicutime" ;

    public static final String SH_SHKXZX ="sh_shkxzx" ;

    public static final String SH_QTZCSSYY ="sh_qtzcssyy" ;

    public static final String SH_SHBFZ ="sh_shbfz" ;

    public static final String SH_NOTE ="sh_note" ;

    public static final String SHSF_ZS ="shsf_zs" ;

    public static final String SHSF_SCZT ="shsf_sczt" ;

    public static final String SHSF_DEATH ="shsf_death" ;

    public static final String SHSF_DEATH_DATE ="shsf_death_date" ;

    public static final String SHSF_XXGZCGY ="shsf_xxgzcgy" ;

    public static final String SHSF_ZCGYSJ ="shsf_zcgysj" ;

    public static final String SHSF_XFJB ="shsf_xfjb" ;

    public static final String SHSF_XFJBSJ ="shsf_xfjbsj" ;

    public static final String SHSF_QTBFZ ="shsf_qtbfz" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }