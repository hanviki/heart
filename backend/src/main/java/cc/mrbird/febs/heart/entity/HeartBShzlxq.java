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
 * 血气结果
 * </p>
 *
 * @author viki
 * @since 2021-05-24
 */

@Excel("heart_b_shzlxq")
@Data
@Accessors(chain = true)
public class HeartBShzlxq implements Serializable{

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
     * 检测时间
     */

    @ExcelField(value ="检测时间", writeConverter = DateConverter.class)
    private Date checkDate;
    private transient String checkDateFrom;
    private transient String checkDateTo;

    /**
     * 血气结果时间
     */
        
        @ExcelField(value ="血气结果时间")
    private String xqtype;

    /**
     * PH
     */
        
        @ExcelField(value ="PH")
    private BigDecimal ph;

    /**
     * PO2
     */
        
        @ExcelField(value ="PO2")
    private BigDecimal po2;

    /**
     * PCO2
     */
        
        @ExcelField(value ="PCO2")
    private BigDecimal pco2;

    /**
     * K+
     */
        
        @ExcelField(value ="K+")
    private BigDecimal k;

    /**
     * Na+
     */
        
        @ExcelField(value ="Na+")
    private BigDecimal na;

    /**
     * Ca+
     */
        
        @ExcelField(value ="Ca+")
    private BigDecimal ca;

    /**
     * GLU
     */
        
        @ExcelField(value ="GLU")
    private BigDecimal glu;

    /**
     * BE
     */
        
        @ExcelField(value ="BE")
    private BigDecimal be;

    /**
     * Lac
     */
        
        @ExcelField(value ="Lac")
    private BigDecimal lac;

    /**
     * Hb
     */
        
        @ExcelField(value ="Hb")
    private BigDecimal hb;

    /**
     * FiaO2
     */
        
        @ExcelField(value ="FiaO2")
    private BigDecimal fiao2;

    /**
     * So2
     */

    @ExcelField(value ="SO2")
    private BigDecimal so2;

    /**
     * 备注
     */
        
        @ExcelField(value ="备注")
    private String note;

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

    private Integer displayIndex;

    public static final String ID ="id" ;

    public static final String USERNAME ="username" ;

    public static final String FILE_NO ="file_no" ;

    public static final String NAME ="name" ;

    public static final String CHECK_DATE ="check_date" ;

    public static final String XQTYPE ="xqtype" ;

    public static final String PH ="ph" ;

    public static final String PO2 ="po2" ;

    public static final String PCO2 ="pco2" ;

    public static final String K ="k" ;

    public static final String NA ="na" ;

    public static final String CA ="ca" ;

    public static final String GLU ="glu" ;

    public static final String BE ="be" ;

    public static final String LAC ="lac" ;

    public static final String HB ="hb" ;

    public static final String FIAO2 ="fiao2" ;

    public static final String SO2 ="so2" ;

    public static final String NOTE ="note" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }