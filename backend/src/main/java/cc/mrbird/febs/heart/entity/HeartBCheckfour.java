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
 * 肝肾功
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_checkfour")
@Data
@Accessors(chain = true)
public class HeartBCheckfour implements Serializable{

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
     * 肌酐
     */
        
        @ExcelField(value ="肌酐")
    private BigDecimal jg;

    /**
     * 尿素氮
     */
        
        @ExcelField(value ="尿素氮")
    private BigDecimal nsd;

    /**
     * 尿酸
     */
        
        @ExcelField(value ="尿酸")
    private BigDecimal ns;

    /**
     * 白蛋白
     */
        
        @ExcelField(value ="白蛋白")
    private BigDecimal bdb;

    /**
     * 胱仰素
     */
        
        @ExcelField(value ="胱仰素")
    private BigDecimal gysc;

    /**
     * 肾小球滤过率
     */
        
        @ExcelField(value ="肾小球滤过率")
    private String sxqlgl;

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

    public static final String XJG ="xjg" ;

    public static final String ALT ="alt" ;

    public static final String AST ="ast" ;

    public static final String ZDHS ="zdhs" ;

    public static final String ZJDHS ="zjdhs" ;

    public static final String DFM ="dfm" ;

    public static final String JG ="jg" ;

    public static final String NSD ="nsd" ;

    public static final String NS ="ns" ;

    public static final String BDB ="bdb" ;

    public static final String GYSC ="gysc" ;

    public static final String SXQLGL ="sxqlgl" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

    public static final String DISPLAY_INDEX ="display_index" ;

        }