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
 * @since 2021-05-06
 */

@Excel("heart_b_ctfc")
@Data
@Accessors(chain = true)
public class HeartBCtfc implements Serializable{

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
     * 图片名
     */
        
        @ExcelField(value ="图片名")
    private String fileName;

    /**
     * 图片地址
     */
        
        @ExcelField(value ="图片地址")
    private String fileUrl;

    /**
     * CT复查时间
     */
        
        @ExcelField(value ="CT复查时间", writeConverter = DateConverter.class)
    private Date ctDate;
    private transient String ctDateFrom;
    private transient String ctDateTo;

    /**
     * 支架末端位置(胸椎序号)
     */
        
        @ExcelField(value ="支架末端位置(胸椎序号)")
    private String zjwdwzCode;

    /**
     * 窦直径
     */
        
        @ExcelField(value ="窦直径")
    private BigDecimal dzj;

    /**
     * 升主脉动直径
     */
        
        @ExcelField(value ="升主脉动直径")
    private BigDecimal szmdzj;

    /**
     * 主动脉弓直径
     */
        
        @ExcelField(value ="主动脉弓直径")
    private BigDecimal zdmgzj;

    /**
     * 胸主动脉上段直径
     */
        
        @ExcelField(value ="胸主动脉上段直径")
    private BigDecimal xzdmsdzj;

    /**
     * 胸主动脉上段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉上段假腔/血肿直径")
    private BigDecimal xzdmsdjqxzzj;

    /**
     * 胸主动脉中段直径
     */
        
        @ExcelField(value ="胸主动脉中段直径")
    private BigDecimal xzdmzdzj;

    /**
     * 胸主动脉中段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉中段假腔/血肿直径")
    private BigDecimal xzdmzdjqzj;

    /**
     * 胸主动脉下段直径
     */
        
        @ExcelField(value ="胸主动脉下段直径")
    private BigDecimal xzdmxdzj;

    /**
     * 胸主动脉下段假腔/血肿直径
     */
        
        @ExcelField(value ="胸主动脉下段假腔/血肿直径")
    private BigDecimal xzdmxdjqzj;

    /**
     * 腹主动脉上段直径
     */
        
        @ExcelField(value ="腹主动脉上段直径")
    private BigDecimal fzdmsdzj;

    /**
     * 腹主动脉上段假腔/血肿直径
     */
        
        @ExcelField(value ="腹主动脉上段假腔/血肿直径")
    private BigDecimal fzdmsdjqzj;

    /**
     * 腹主动脉下段直径
     */
        
        @ExcelField(value ="腹主动脉下段直径")
    private BigDecimal fzdmxdzj;

    /**
     * 腹主动脉下段假腔/血肿直径
     */
        
        @ExcelField(value ="腹主动脉下段假腔/血肿直径")
    private BigDecimal fzdmxdjqzj;

    /**
     * 近端吻合口漏
     */
        
        @ExcelField(value ="近端吻合口漏")
    private String jdwhkl;

    /**
     * 远端吻合口漏
     */
        
        @ExcelField(value ="远端吻合口漏")
    private String ydwhkl;

    /**
     * 升主周围血肿
     */
        
        @ExcelField(value ="升主周围血肿")
    private String szzwxz;

    /**
     * 弓部血肿
     */
        
        @ExcelField(value ="弓部血肿")
    private String gbxz;

    /**
     * 假腔转归
     */
        
        @ExcelField(value ="假腔转归")
    private String jqzg;

    /**
     * 腹腔干转归
     */
        
        @ExcelField(value ="腹腔干转归")
    private String fqqzg;

    /**
     * 左肾脉动转归
     */
        
        @ExcelField(value ="左肾脉动转归")
    private String zsmdzg;

    /**
     * 右肾脉动转归
     */
        
        @ExcelField(value ="右肾脉动转归")
    private String ysmdzg;

    /**
     * 左髂总转归
     */
        
        @ExcelField(value ="左髂总转归")
    private String zkzzg;

    /**
     * 右髂总转归
     */
        
        @ExcelField(value ="右髂总转归")
    private String ykzzg;

    /**
     * 人工血管异常说明
     */
        
        @ExcelField(value ="人工血管异常说明")
    private String rgxgycsm;

    /**
     * 动脉瘤样扩张
     */
        
        @ExcelField(value ="动脉瘤样扩张")
    private String dmlykz;

    /**
     * 支架异常说明
     */
        
        @ExcelField(value ="支架异常说明")
    private String zjycsm;

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

    public static final String FILE_NAME ="file_name" ;

    public static final String FILE_URL ="file_url" ;

    public static final String CT_DATE ="ct_date" ;

    public static final String ZJWDWZ_CODE ="zjwdwz_code" ;

    public static final String DZJ ="dzj" ;

    public static final String SZMDZJ ="szmdzj" ;

    public static final String ZDMGZJ ="zdmgzj" ;

    public static final String XZDMSDZJ ="xzdmsdzj" ;

    public static final String XZDMSDJQXZZJ ="xzdmsdjqxzzj" ;

    public static final String XZDMZDZJ ="xzdmzdzj" ;

    public static final String XZDMZDJQZJ ="xzdmzdjqzj" ;

    public static final String XZDMXDZJ ="xzdmxdzj" ;

    public static final String XZDMXDJQZJ ="xzdmxdjqzj" ;

    public static final String FZDMSDZJ ="fzdmsdzj" ;

    public static final String FZDMSDJQZJ ="fzdmsdjqzj" ;

    public static final String FZDMXDZJ ="fzdmxdzj" ;

    public static final String FZDMXDJQZJ ="fzdmxdjqzj" ;

    public static final String JDWHKL ="jdwhkl" ;

    public static final String YDWHKL ="ydwhkl" ;

    public static final String SZZWXZ ="szzwxz" ;

    public static final String GBXZ ="gbxz" ;

    public static final String JQZG ="jqzg" ;

    public static final String FQQZG ="fqqzg" ;

    public static final String ZSMDZG ="zsmdzg" ;

    public static final String YSMDZG ="ysmdzg" ;

    public static final String ZKZZG ="zkzzg" ;

    public static final String YKZZG ="ykzzg" ;

    public static final String RGXGYCSM ="rgxgycsm" ;

    public static final String DMLYKZ ="dmlykz" ;

    public static final String ZJYCSM ="zjycsm" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }