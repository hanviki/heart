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
 * 出院复查CT6
 * </p>
 *
 * @author viki
 * @since 2021-06-22
 */

@Excel("heart_b_ctout")
@Data
@Accessors(chain = true)
public class HeartBCtout implements Serializable{

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
     * 病人状态
     */
        
        @ExcelField(value ="病人状态")
    private String brzt;

    /**
     * 出院复查图片名称
     */
        
        @ExcelField(value ="出院复查图片名称")
    private String fctFileName;

    /**
     * 出院复查图片地址
     */
        
        @ExcelField(value ="出院复查图片地址")
    private String fctFilePath;

    /**
     * 支架末端位置(胸椎序号)
     */
        
        @ExcelField(value ="支架末端位置(胸椎序号)")
    private String fctZjwdwz;

    /**
     * 窦直径
     */
        
        @ExcelField(value ="窦直径")
    private BigDecimal fctDzj;

    /**
     * 升主脉动直径
     */
        
        @ExcelField(value ="升主脉动直径")
    private BigDecimal fctSzmdzj;

    /**
     * 主动脉弓直径
     */
        
        @ExcelField(value ="主动脉弓直径")
    private BigDecimal fctZdmgzj;

    /**
     * 胸主动脉上段直径
     */
        
        @ExcelField(value ="胸主动脉上段直径")
    private BigDecimal fctXzdmsdzj;

    /**
     * 胸主动脉上段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉上段假腔/血肿直径")
    private BigDecimal fctXzdmsdjqxzzj;

    /**
     * 胸主动脉中段直径
     */
        
        @ExcelField(value ="胸主动脉中段直径")
    private BigDecimal fctXzdmzdzj;

    /**
     * 胸主动脉中段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉中段假腔/血肿直径")
    private BigDecimal fctXzdmzdjqzj;

    /**
     * 胸主动脉下段直径
     */
        
        @ExcelField(value ="胸主动脉下段直径")
    private BigDecimal fctXzdmxdzj;

    /**
     * 胸主动脉下段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉下段假腔/血肿直径")
    private BigDecimal fctXzdmxdjqzj;

    /**
     * 腹主动脉上段直径
     */
        
        @ExcelField(value ="腹主动脉上段直径")
    private BigDecimal fctFzdmsdzj;

    /**
     * 腹主动脉上段假腔/血肿直径
     */
        
        @ExcelField(value ="腹主动脉上段假腔/血肿直径")
    private BigDecimal fctFzdmsdjqzj;

    /**
     * 腹主动脉下段直径
     */
        
        @ExcelField(value ="腹主动脉下段直径")
    private BigDecimal fctFzdmxdzj;

    /**
     * 腹主动脉下段假腔/血肿直径
     */
        
        @ExcelField(value ="腹主动脉下段假腔/血肿直径")
    private BigDecimal fctFzdmxdjqzj;

    /**
     * 近端吻合口漏
     */
        
        @ExcelField(value ="近端吻合口漏")
    private String fctJdwhkl;

    /**
     * 远端吻合口漏
     */
        
        @ExcelField(value ="远端吻合口漏")
    private String fctYdwhkl;

    /**
     * 升主周围血肿
     */
        
        @ExcelField(value ="升主周围血肿")
    private String fctSzzwxz;

    /**
     * 弓部血肿
     */
        
        @ExcelField(value ="弓部血肿")
    private String fctGbxz;

    /**
     * 假腔转归
     */
        
        @ExcelField(value ="假腔转归")
    private String fctJqzg;

    /**
     * 腹腔干转归
     */
        
        @ExcelField(value ="腹腔干转归")
    private String fctFqqzg;

    /**
     * 左肾脉动转归
     */
        
        @ExcelField(value ="左肾脉动转归")
    private String fctZsmdzg;

    /**
     * 右肾脉动转归
     */
        
        @ExcelField(value ="右肾脉动转归")
    private String fctYsmdzg;

    /**
     * 左髂总转归
     */
        
        @ExcelField(value ="左髂总转归")
    private String fctZkzzg;

    /**
     * 右髂总转归
     */
        
        @ExcelField(value ="右髂总转归")
    private String fctYkzzg;

    /**
     * 人工血管异常说明
     */
        
        @ExcelField(value ="人工血管异常说明")
    private String fctRgxgycsm;

    /**
     * 动脉瘤样扩张
     */
        
        @ExcelField(value ="动脉瘤样扩张")
    private String fctDmlykz;

    /**
     * 支架异常说明
     */
        
        @ExcelField(value ="支架异常说明")
    private String fctZjycsm;

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

    /**
     * 检测时间
     */
        
        @ExcelField(value ="检测时间", writeConverter = DateConverter.class)
    private Date checkDate2;
    private transient String checkDate2From;
    private transient String checkDate2To;

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
     * 检测时间
     */

    @ExcelField(value ="检测时间", writeConverter = DateConverter.class)
    private Date checkDate3;
    private transient String checkDate3From;
    private transient String checkDate3To;

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
     * 室壁运动异常位置
     */
        
        @ExcelField(value ="室壁运动异常位置")
    private String sbydycwz;

    /**
     * 心包积液
     */
        
        @ExcelField(value ="心包积液")
    private String xbjy;

    /**
     * EF
     */
        
        @ExcelField(value ="EF")
    private BigDecimal ef;

    /**
     * 左室舒张末内径
     */
        
        @ExcelField(value ="左室舒张末内径")
    private BigDecimal zsszwnj;

    /**
     * 主动脉闭环直径
     */
        
        @ExcelField(value ="主动脉闭环直径")
    private BigDecimal zdmbhzj;

    /**
     * 主动脉窦直径
     */
        
        @ExcelField(value ="主动脉窦直径")
    private BigDecimal zdmdzj;

    /**
     * 升主动脉直径
     */
        
        @ExcelField(value ="升主动脉直径")
    private BigDecimal szdmzj;



    public static final String ID ="id" ;

    public static final String USERNAME ="username" ;

    public static final String FILE_NO ="file_no" ;

    public static final String NAME ="name" ;

    public static final String CHECK_DATE ="check_date" ;

    public static final String BRZT ="brzt" ;

    public static final String FCT_FILE_NAME ="fct_file_name" ;

    public static final String FCT_FILE_PATH ="fct_file_path" ;

    public static final String FCT_ZJWDWZ ="fct_zjwdwz" ;

    public static final String FCT_DZJ ="fct_dzj" ;

    public static final String FCT_SZMDZJ ="fct_szmdzj" ;

    public static final String FCT_ZDMGZJ ="fct_zdmgzj" ;

    public static final String FCT_XZDMSDZJ ="fct_xzdmsdzj" ;

    public static final String FCT_XZDMSDJQXZZJ ="fct_xzdmsdjqxzzj" ;

    public static final String FCT_XZDMZDZJ ="fct_xzdmzdzj" ;

    public static final String FCT_XZDMZDJQZJ ="fct_xzdmzdjqzj" ;

    public static final String FCT_XZDMXDZJ ="fct_xzdmxdzj" ;

    public static final String FCT_XZDMXDJQZJ ="fct_xzdmxdjqzj" ;

    public static final String FCT_FZDMSDZJ ="fct_fzdmsdzj" ;

    public static final String FCT_FZDMSDJQZJ ="fct_fzdmsdjqzj" ;

    public static final String FCT_FZDMXDZJ ="fct_fzdmxdzj" ;

    public static final String FCT_FZDMXDJQZJ ="fct_fzdmxdjqzj" ;

    public static final String FCT_JDWHKL ="fct_jdwhkl" ;

    public static final String FCT_YDWHKL ="fct_ydwhkl" ;

    public static final String FCT_SZZWXZ ="fct_szzwxz" ;

    public static final String FCT_GBXZ ="fct_gbxz" ;

    public static final String FCT_JQZG ="fct_jqzg" ;

    public static final String FCT_FQQZG ="fct_fqqzg" ;

    public static final String FCT_ZSMDZG ="fct_zsmdzg" ;

    public static final String FCT_YSMDZG ="fct_ysmdzg" ;

    public static final String FCT_ZKZZG ="fct_zkzzg" ;

    public static final String FCT_YKZZG ="fct_ykzzg" ;

    public static final String FCT_RGXGYCSM ="fct_rgxgycsm" ;

    public static final String FCT_DMLYKZ ="fct_dmlykz" ;

    public static final String FCT_ZJYCSM ="fct_zjycsm" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

    public static final String DISPLAY_INDEX ="display_index" ;

    public static final String CHECK_DATE2 ="check_date2" ;

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

    public static final String CHECK_DATE3 ="check_date3" ;

    public static final String AVR ="avr" ;

    public static final String MVR ="mvr" ;

    public static final String SBYDYCWZ ="sbydycwz" ;

    public static final String XBJY ="xbjy" ;

    public static final String EF ="ef" ;

    public static final String ZSSZWNJ ="zsszwnj" ;

    public static final String ZDMBHZJ ="zdmbhzj" ;

    public static final String ZDMDZJ ="zdmdzj" ;

    public static final String SZDMZJ ="szdmzj" ;

        }