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
 * 住院病历资料
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_hospitalinfo")
@Data
@Accessors(chain = true)
public class HeartBHospitalinfo implements Serializable{

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
     * 主诉
     */
        
        @ExcelField(value ="主诉")
    private String zhusu;

    /**
     * 入院日期
     */
        
        @ExcelField(value ="入院日期", writeConverter = DateConverter.class)
    private Date inHospital;
    private transient String inHospitalFrom;
    private transient String inHospitalTo;

    /**
     * 出院日期
     */
        
        @ExcelField(value ="出院日期", writeConverter = DateConverter.class)
    private Date outHospital;
    private transient String outHospitalFrom;
    private transient String outHospitalTo;

    /**
     * 住院转归
     */
        
        @ExcelField(value ="住院转归")
    private String inRedirect;

    /**
     * 死亡原因
     */
        
        @ExcelField(value ="死亡原因")
    private String deathInfo;

    /**
     * 死亡日期
     */
        
        @ExcelField(value ="死亡日期", writeConverter = DateConverter.class)
    private Date swsj;
    private transient String swsjFrom;
    private transient String swsjTo;

    /**
     * 夹层诊断（Stanford分层）
     */
        
        @ExcelField(value ="夹层诊断（Stanford分层）")
    private String inRedirectnote;

    /**
     * 夹层诊断（阜外分型）
     */
        
        @ExcelField(value ="夹层诊断（阜外分型）")
    private String jczd;

    /**
     * 高血压
     */
        
        @ExcelField(value ="高血压")
    private String gxy;

    /**
     * NYHA分级
     */
        
        @ExcelField(value ="NYHA分级")
    private String nyha;

    /**
     * 糖尿病
     */
        
        @ExcelField(value ="糖尿病")
    private String tnb;

    /**
     * 马凡综合征
     */
        
        @ExcelField(value ="马凡综合征")
    private String mfzhz;

    /**
     * 其他
     */
        
        @ExcelField(value ="其他")
    private String other;

    /**
     * 主动脉瓣手术
     */
        
        @ExcelField(value ="主动脉瓣手术")
    private String zdmbss;

    /**
     * 主动脉瓣手术时间
     */
        
        @ExcelField(value ="主动脉瓣手术时间", writeConverter = DateConverter.class)
    private Date zdmbssDate;
    private transient String zdmbssDateFrom;
    private transient String zdmbssDateTo;

    /**
     * 全弓置换
     */
        
        @ExcelField(value ="全弓置换")
    private String qgzh;

    /**
     * 全弓置换时间
     */
        
        @ExcelField(value ="全弓置换时间", writeConverter = DateConverter.class)
    private Date qgzhDate;
    private transient String qgzhDateFrom;
    private transient String qgzhDateTo;

    /**
     * 夹层腔内修复术
     */
        
        @ExcelField(value ="夹层腔内修复术")
    private String jcqnxfs;

    /**
     * 夹层腔内修复术时间
     */
        
        @ExcelField(value ="夹层腔内修复术时间", writeConverter = DateConverter.class)
    private Date jcqnxfsDate;
    private transient String jcqnxfsDateFrom;
    private transient String jcqnxfsDateTo;

    /**
     * 其他主动干预
     */
        
        @ExcelField(value ="其他主动干预")
    private String qtzdgy;

    /**
     * 上次主动干预时间
     */
        
        @ExcelField(value ="上次主动干预时间", writeConverter = DateConverter.class)
    private Date sczdgysj;
    private transient String sczdgysjFrom;
    private transient String sczdgysjTo;

    /**
     * 主动脉疾病家族史
     */
        
        @ExcelField(value ="主动脉疾病家族史")
    private String zdmjbjzs;

    /**
     * 吸烟
     */
        
        @ExcelField(value ="吸烟")
    private String xy;

    /**
     * 喝酒
     */
        
        @ExcelField(value ="喝酒")
    private String hj;

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

    public static final String ZHUSU ="zhusu" ;

    public static final String IN_HOSPITAL ="in_hospital" ;

    public static final String OUT_HOSPITAL ="out_hospital" ;

    public static final String IN_REDIRECT ="in_redirect" ;

    public static final String DEATH_INFO ="death_info" ;

    public static final String SWSJ ="swsj" ;

    public static final String IN_REDIRECTNOTE ="in_redirectnote" ;

    public static final String JCZD ="jczd" ;

    public static final String GXY ="gxy" ;

    public static final String NYHA ="nyha" ;

    public static final String TNB ="tnb" ;

    public static final String MFZHZ ="mfzhz" ;

    public static final String OTHER ="other" ;

    public static final String ZDMBSS ="zdmbss" ;

    public static final String ZDMBSS_DATE ="zdmbss_date" ;

    public static final String QGZH ="qgzh" ;

    public static final String QGZH_DATE ="qgzh_date" ;

    public static final String JCQNXFS ="jcqnxfs" ;

    public static final String JCQNXFS_DATE ="jcqnxfs_date" ;

    public static final String QTZDGY ="qtzdgy" ;

    public static final String SCZDGYSJ ="sczdgysj" ;

    public static final String ZDMJBJZS ="zdmjbjzs" ;

    public static final String XY ="xy" ;

    public static final String HJ ="hj" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }