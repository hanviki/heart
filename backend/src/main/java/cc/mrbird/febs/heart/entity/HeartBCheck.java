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
 * 
 * </p>
 *
 * @author viki
 * @since 2021-05-06
 */

@Excel("heart_b_check")
@Data
@Accessors(chain = true)
public class HeartBCheck implements Serializable{

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
     * 肌红蛋白
     */
        
        @ExcelField(value ="肌红蛋白")
    private BigDecimal jhdb;

    /**
     * 肌钙蛋白
     */
        
        @ExcelField(value ="肌钙蛋白")
    private BigDecimal jgdb;

    /**
     * CK-MB
     */
        
        @ExcelField(value ="CK-MB")
    private BigDecimal ckmb;

    /**
     * 超敏肌钙蛋白（optional）
     */
        
        @ExcelField(value ="超敏肌钙蛋白（optional）")
    private BigDecimal cmjgdb;

    /**
     * 红细胞计数
     */
        
        @ExcelField(value ="红细胞计数")
    private BigDecimal hxbjs;

    /**
     * 血红蛋白
     */
        
        @ExcelField(value ="血红蛋白")
    private BigDecimal xhdb;

    /**
     * 白细胞计数
     */
        
        @ExcelField(value ="白细胞计数")
    private BigDecimal bxbjs;

    /**
     * 中性粒细胞百分比
     */
        
        @ExcelField(value ="中性粒细胞百分比")
    private BigDecimal zxlxbbfb;

    /**
     * 血小板计数
     */
        
        @ExcelField(value ="血小板计数")
    private BigDecimal xxbjs;

    /**
     * PH
     */
        
        @ExcelField(value ="PH")
    private BigDecimal ph;

    /**
     * 乳酸
     */
        
        @ExcelField(value ="乳酸")
    private BigDecimal rs;

    /**
     * BE
     */
        
        @ExcelField(value ="BE")
    private BigDecimal be;

    /**
     * SO2
     */
        
        @ExcelField(value ="SO2")
    private BigDecimal so2;

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
     * 血肌肝
     */
        
        @ExcelField(value ="血肌肝")
    private BigDecimal xjg;

    /**
     * ALT
     */
        
        @ExcelField(value ="ALT")
    private BigDecimal alt;

    /**
     * AST
     */
        
        @ExcelField(value ="AST")
    private BigDecimal ast;

    /**
     * 总胆红素
     */
        
        @ExcelField(value ="总胆红素")
    private BigDecimal zdhs;

    /**
     * 直接胆红素
     */
        
        @ExcelField(value ="直接胆红素")
    private BigDecimal zjdhs;

    /**
     * 淀粉酶
     */
        
        @ExcelField(value ="淀粉酶")
    private BigDecimal dfm;

    /**
     * D二聚体
     */
        
        @ExcelField(value ="D二聚体")
    private BigDecimal d2jt;

    /**
     * FDP
     */
        
        @ExcelField(value ="FDP")
    private BigDecimal fdp;

    /**
     * PT
     */
        
        @ExcelField(value ="PT")
    private BigDecimal pt;

    /**
     * APTT
     */
        
        @ExcelField(value ="APTT")
    private BigDecimal aptt;

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

    public static final String JHDB ="jhdb" ;

    public static final String JGDB ="jgdb" ;

    public static final String CKMB ="ckmb" ;

    public static final String CMJGDB ="cmjgdb" ;

    public static final String HXBJS ="hxbjs" ;

    public static final String XHDB ="xhdb" ;

    public static final String BXBJS ="bxbjs" ;

    public static final String ZXLXBBFB ="zxlxbbfb" ;

    public static final String XXBJS ="xxbjs" ;

    public static final String PH ="ph" ;

    public static final String RS ="rs" ;

    public static final String BE ="be" ;

    public static final String SO2 ="so2" ;

    public static final String PO2 ="po2" ;

    public static final String PCO2 ="pco2" ;

    public static final String XJG ="xjg" ;

    public static final String ALT ="alt" ;

    public static final String AST ="ast" ;

    public static final String ZDHS ="zdhs" ;

    public static final String ZJDHS ="zjdhs" ;

    public static final String DFM ="dfm" ;

    public static final String D2JT ="d2jt" ;

    public static final String FDP ="fdp" ;

    public static final String PT ="pt" ;

    public static final String APTT ="aptt" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }