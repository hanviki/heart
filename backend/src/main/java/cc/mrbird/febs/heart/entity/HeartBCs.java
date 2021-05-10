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
 * 超声
 * </p>
 *
 * @author viki
 * @since 2021-05-06
 */

@Excel("heart_b_cs")
@Data
@Accessors(chain = true)
public class HeartBCs implements Serializable{

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
     * 图片名称
     */
        
        @ExcelField(value ="图片名称")
    private String fileName;

    /**
     * 图片地址
     */
        
        @ExcelField(value ="图片地址")
    private String filePath;

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

    public static final String FILE_NAME ="file_name" ;

    public static final String FILE_PATH ="file_path" ;

    public static final String AVR ="avr" ;

    public static final String MVR ="mvr" ;

    public static final String SBYDYCWZ ="sbydycwz" ;

    public static final String XBJY ="xbjy" ;

    public static final String EF ="ef" ;

    public static final String ZSSZWNJ ="zsszwnj" ;

    public static final String ZDMBHZJ ="zdmbhzj" ;

    public static final String ZDMDZJ ="zdmdzj" ;

    public static final String SZDMZJ ="szdmzj" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }