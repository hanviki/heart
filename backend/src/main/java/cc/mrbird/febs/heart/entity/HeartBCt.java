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
 * 术前CT
 * </p>
 *
 * @author viki
 * @since 2021-05-21
 */

@Excel("heart_b_ct")
@Data
@Accessors(chain = true)
public class HeartBCt implements Serializable{

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
     * CT图片名称
     */
        
        @ExcelField(value ="CT图片名称")
    private String fileNamect;

    /**
     * CT图片地址
     */
        
        @ExcelField(value ="CT图片地址")
    private String filePathct;

    /**
     * 主动脉窦直径
     */
        
        @ExcelField(value ="主动脉窦直径")
    private BigDecimal ctZdmdzj;

    /**
     * 升主动脉直径
     */
        
        @ExcelField(value ="升主动脉直径")
    private BigDecimal ctSzdmzj;

    /**
     * 主动脉弓直径
     */
        
        @ExcelField(value ="主动脉弓直径")
    private BigDecimal ctZdmgzj;

    /**
     * 胸上主动脉直径
     */
        
        @ExcelField(value ="胸上主动脉直径")
    private BigDecimal ctXszdmzj;

    /**
     * 胸中主动脉直径
     */
        
        @ExcelField(value ="胸中主动脉直径")
    private BigDecimal ctXzzdmzj;

    /**
     * 胸下主动脉直径
     */
        
        @ExcelField(value ="胸下主动脉直径")
    private BigDecimal ctXxzdmzj;

    /**
     * 腹主动脉上段直径
     */
        
        @ExcelField(value ="腹主动脉上段直径")
    private BigDecimal ctFzdmsdzj;

    /**
     * 腹主动脉下段直径
     */
        
        @ExcelField(value ="腹主动脉下段直径")
    private BigDecimal ctFzdmxdzj;

    /**
     * 升主动脉假腔直径
     */
        
        @ExcelField(value ="升主动脉假腔直径")
    private BigDecimal ctSzdmjqzj;

    /**
     * 主动脉弓假腔直径
     */
        
        @ExcelField(value ="主动脉弓假腔直径")
    private BigDecimal ctZdmgjqzj;

    /**
     * 胸上假腔直径
     */
        
        @ExcelField(value ="胸上假腔直径")
    private BigDecimal ctXsjqzj;

    /**
     * 胸中假腔直径
     */
        
        @ExcelField(value ="胸中假腔直径")
    private BigDecimal ctXzjqzj;

    /**
     * 胸下假腔直径
     */
        
        @ExcelField(value ="胸下假腔直径")
    private BigDecimal ctXxjqzj;

    /**
     * 腹上假腔直径
     */
        
        @ExcelField(value ="腹上假腔直径")
    private BigDecimal ctFsjqzj;

    /**
     * 腹下假腔直径
     */
        
        @ExcelField(value ="腹下假腔直径")
    private BigDecimal ctFxjqzj;

    /**
     * 主动脉夹层阜外分型
     */
        
        @ExcelField(value ="主动脉夹层阜外分型")
    private String ctZdmjcfwfx;

    /**
     * 升主夹层病理
     */
        
        @ExcelField(value ="升主夹层病理")
    private String ctSzjcbl;

    /**
     * 主动脉弓假腔位置
     */
        
        @ExcelField(value ="主动脉弓假腔位置")
    private String ctZdmgjqwz;

    /**
     * 主动脉胸段病理
     */
        
        @ExcelField(value ="主动脉胸段病理")
    private String ctZdxdbl;

    /**
     * 主动脉胸段假腔位置
     */
        
        @ExcelField(value ="主动脉胸段假腔位置")
    private String ctZdxdjqwz;

    /**
     * 腹主动脉上段病理
     */
        
        @ExcelField(value ="腹主动脉上段病理")
    private String ctFzdmsdbl;

    /**
     * 腹主动脉假腔位置
     */
        
        @ExcelField(value ="腹主动脉假腔位置")
    private String ctFzdmjqwz;

    /**
     * 肾动脉下夹层病理
     */
        
        @ExcelField(value ="肾动脉下夹层病理")
    private String ctSdmxjcbl;

    /**
     * 肾下假腔位置
     */
        
        @ExcelField(value ="肾下假腔位置")
    private String ctSxjqwz;

    /**
     * 原发破口位置
     */
        
        @ExcelField(value ="原发破口位置")
    private String ctYfpkwz;

    /**
     * 原发破口大小
     */
        
        @ExcelField(value ="原发破口大小")
    private String ctYfpkdx;

    /**
     * 缺血或重度受压分支血管
     */
        
        @ExcelField(value ="缺血或重度受压分支血管")
    private String ctQxhzdsyfzxg;

    /**
     * 完全缺血器官
     */
        
        @ExcelField(value ="完全缺血器官")
    private String ctWqqxqg;

    /**
     * 夹层累及范围
     */
        
        @ExcelField(value ="夹层累及范围")
    private String ctJcljfw;

    /**
     * 主动脉夹层特殊征象
     */
        
        @ExcelField(value ="主动脉夹层特殊征象")
    private String ctZdmjctszx;

    /**
     * 假腔供血器官
     */
        
        @ExcelField(value ="假腔供血器官")
    private String ctJqgxqg;

    /**
     * 备注
     */
        
        @ExcelField(value ="备注")
    private String ctNote;

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

    public static final String FILE_NAMECT ="file_namect" ;

    public static final String FILE_PATHCT ="file_pathct" ;

    public static final String CT_ZDMDZJ ="ct_zdmdzj" ;

    public static final String CT_SZDMZJ ="ct_szdmzj" ;

    public static final String CT_ZDMGZJ ="ct_zdmgzj" ;

    public static final String CT_XSZDMZJ ="ct_xszdmzj" ;

    public static final String CT_XZZDMZJ ="ct_xzzdmzj" ;

    public static final String CT_XXZDMZJ ="ct_xxzdmzj" ;

    public static final String CT_FZDMSDZJ ="ct_fzdmsdzj" ;

    public static final String CT_FZDMXDZJ ="ct_fzdmxdzj" ;

    public static final String CT_SZDMJQZJ ="ct_szdmjqzj" ;

    public static final String CT_ZDMGJQZJ ="ct_zdmgjqzj" ;

    public static final String CT_XSJQZJ ="ct_xsjqzj" ;

    public static final String CT_XZJQZJ ="ct_xzjqzj" ;

    public static final String CT_XXJQZJ ="ct_xxjqzj" ;

    public static final String CT_FSJQZJ ="ct_fsjqzj" ;

    public static final String CT_FXJQZJ ="ct_fxjqzj" ;

    public static final String CT_ZDMJCFWFX ="ct_zdmjcfwfx" ;

    public static final String CT_SZJCBL ="ct_szjcbl" ;

    public static final String CT_ZDMGJQWZ ="ct_zdmgjqwz" ;

    public static final String CT_ZDXDBL ="ct_zdxdbl" ;

    public static final String CT_ZDXDJQWZ ="ct_zdxdjqwz" ;

    public static final String CT_FZDMSDBL ="ct_fzdmsdbl" ;

    public static final String CT_FZDMJQWZ ="ct_fzdmjqwz" ;

    public static final String CT_SDMXJCBL ="ct_sdmxjcbl" ;

    public static final String CT_SXJQWZ ="ct_sxjqwz" ;

    public static final String CT_YFPKWZ ="ct_yfpkwz" ;

    public static final String CT_YFPKDX ="ct_yfpkdx" ;

    public static final String CT_QXHZDSYFZXG ="ct_qxhzdsyfzxg" ;

    public static final String CT_WQQXQG ="ct_wqqxqg" ;

    public static final String CT_JCLJFW ="ct_jcljfw" ;

    public static final String CT_ZDMJCTSZX ="ct_zdmjctszx" ;

    public static final String CT_JQGXQG ="ct_jqgxqg" ;

    public static final String CT_NOTE ="ct_note" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }