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
 * 超声复查
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_csfc")
@Data
@Accessors(chain = true)
public class HeartBCsfc implements Serializable{

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
                            
        @ExcelField(value ="主键")
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
     * 检测时间
     */
        
        @ExcelField(value ="检测时间", writeConverter = DateConverter.class)
    private Date checkDate;
    private transient String checkDateFrom;
    private transient String checkDateTo;

    /**
     * 文件名
     */
        
        @ExcelField(value ="文件名")
    private String fileName;

    /**
     * 文件地址
     */
        
        @ExcelField(value ="文件地址")
    private String fileUrl;

    /**
     * AVR
     */
        
        @ExcelField(value ="AVR")
    private String avr;

    /**
     * MVR
     */
        
        @ExcelField(value ="MVR")
    private String mvr;

    /**
     * 室壁运动异常位置(如无,则不填)
     */
        
        @ExcelField(value ="室壁运动异常位置(如无,则不填)")
    private String sbydycwz;

    /**
     * 心包积液
     */
        
        @ExcelField(value ="心包积液")
    private String xbjy;

    /**
     * EF(%)
     */
        
        @ExcelField(value ="EF(%)")
    private BigDecimal ef;

    /**
     * 左室舒张末内径(mm)
     */
        
        @ExcelField(value ="左室舒张末内径(mm)")
    private BigDecimal zsszwnj;

    /**
     * 主动脉瓣环直径(mm)
     */
        
        @ExcelField(value ="主动脉瓣环直径(mm)")
    private BigDecimal zdmbhzj;

    /**
     * 主动脉窦直径(mm)
     */
        
        @ExcelField(value ="主动脉窦直径(mm)")
    private BigDecimal zdmdzj;

    /**
     * 主动脉窦直径(mm)
     */
        
        @ExcelField(value ="主动脉窦直径(mm)")
    private BigDecimal sdmdzj;

    /**
     * 升主动脉直径(mm)
     */
        
        @ExcelField(value ="升主动脉直径(mm)")
    private BigDecimal szdmdzj;

    /**
     * 超声检查时间
     */
        
        @ExcelField(value ="超声检查时间", writeConverter = DateConverter.class)
    private Date csjcsj;
    private transient String csjcsjFrom;
    private transient String csjcsjTo;

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
     * 排序
     */
        
        @ExcelField(value ="排序")
    private Integer displayIndex;



    public static final String ID ="id" ;

    public static final String USERNAME ="username" ;

    public static final String FILE_NO ="file_no" ;

    public static final String NAME ="name" ;

    public static final String CHECK_DATE ="check_date" ;

    public static final String FILE_NAME ="file_name" ;

    public static final String FILE_URL ="file_url" ;

    public static final String AVR ="avr" ;

    public static final String MVR ="mvr" ;

    public static final String SBYDYCWZ ="sbydycwz" ;

    public static final String XBJY ="xbjy" ;

    public static final String EF ="ef" ;

    public static final String ZSSZWNJ ="zsszwnj" ;

    public static final String ZDMBHZJ ="zdmbhzj" ;

    public static final String ZDMDZJ ="zdmdzj" ;

    public static final String SDMDZJ ="sdmdzj" ;

    public static final String SZDMDZJ ="szdmdzj" ;

    public static final String CSJCSJ ="csjcsj" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

    public static final String DISPLAY_INDEX ="display_index" ;

        }