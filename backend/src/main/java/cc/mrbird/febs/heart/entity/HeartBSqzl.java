package cc.mrbird.febs.heart.entity;

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
 * 术前资料
 * </p>
 *
 * @author viki
 * @since 2021-05-25
 */

@Excel("heart_b_sqzl")
@Data
@Accessors(chain = true)
public class HeartBSqzl implements Serializable{

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
     * 意识状态
     */
        
        @ExcelField(value ="意识状态")
    private String yszt;

    /**
     * 皮肤黏膜
     */
        
        @ExcelField(value ="皮肤黏膜")
    private String pfnm;

    /**
     * 饮食
     */
        
        @ExcelField(value ="饮食")
    private String yinshi;

    /**
     * 排便
     */
        
        @ExcelField(value ="排便")
    private String paibian;

    /**
     * 排便备注
     */
        
        @ExcelField(value ="排便备注")
    private String paibianNote;

    /**
     * 辅助排便
     */
        
        @ExcelField(value ="辅助排便")
    private String paibianHelp;

    /**
     * 排尿
     */
        
        @ExcelField(value ="排尿")
    private String painiao;

    /**
     * 过敏史药物
     */
        
        @ExcelField(value ="过敏史药物")
    private String guominshi;

    /**
     * 过敏史备注
     */
        
        @ExcelField(value ="过敏史备注")
    private String guominshiNote;

    /**
     * 过敏史食物
     */
        
        @ExcelField(value ="过敏史食物")
    private String gmsSw;

    /**
     * 过敏史食物备注
     */
        
        @ExcelField(value ="过敏史食物备注")
    private String gmsSwNote;

    /**
     * 吸烟史
     */
        
        @ExcelField(value ="吸烟史")
    private String xiyanshi;

    /**
     * 吸烟史备注
     */
        
        @ExcelField(value ="吸烟史备注")
    private String xiyanshiNote;

    /**
     * 饮酒史
     */
        
        @ExcelField(value ="饮酒史")
    private String yinjiushi;

    /**
     * 慢性病
     */
        
        @ExcelField(value ="慢性病")
    private String manxingbing;

    /**
     * 备注
     */
        
        @ExcelField(value ="备注")
    private String manxingbingNote;

    /**
     * Barthel指数
     */
        
        @ExcelField(value ="Barthel指数")
    private String barthel;

    /**
     * Braden评分
     */
        
        @ExcelField(value ="Braden评分")
    private String braden;

    /**
     * 压疮
     */
        
        @ExcelField(value ="压疮")
    private String yachuang;

    /**
     * Caprini评分
     */
        
        @ExcelField(value ="Caprini评分")
    private String caprini;

    /**
     * 疼痛时长
     */
        
        @ExcelField(value ="疼痛时长")
    private String painTime;

    /**
     * 疼痛评分
     */
        
        @ExcelField(value ="疼痛评分")
    private String painScore;

    /**
     * 疼痛处理
     */
        
        @ExcelField(value ="疼痛处理")
    private String painHadle;

    /**
     * 疼痛处理备注
     */
        
        @ExcelField(value ="疼痛处理备注")
    private String painHadlenote;

    /**
     * 疼痛处理后再次评分
     */
        
        @ExcelField(value ="疼痛处理后再次评分")
    private String painScoreAgain;

    /**
     * 营养风险筛查评估（NRS2002）
     */
        
        @ExcelField(value ="营养风险筛查评估（NRS2002）")
    private String yingyangfxsc;

    /**
     * 营养风险筛查评估备注
     */
        
        @ExcelField(value ="营养风险筛查评估备注")
    private String yingyangfxscNote;

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

    public static final String YSZT ="yszt" ;

    public static final String PFNM ="pfnm" ;

    public static final String YINSHI ="yinshi" ;

    public static final String PAIBIAN ="paibian" ;

    public static final String PAIBIAN_NOTE ="paibian_note" ;

    public static final String PAIBIAN_HELP ="paibian_help" ;

    public static final String PAINIAO ="painiao" ;

    public static final String GUOMINSHI ="guominshi" ;

    public static final String GUOMINSHI_NOTE ="guominshi_note" ;

    public static final String GMS_SW ="gms_sw" ;

    public static final String GMS_SW_NOTE ="gms_sw_note" ;

    public static final String XIYANSHI ="xiyanshi" ;

    public static final String XIYANSHI_NOTE ="xiyanshi_note" ;

    public static final String YINJIUSHI ="yinjiushi" ;

    public static final String MANXINGBING ="manxingbing" ;

    public static final String MANXINGBING_NOTE ="manxingbing_note" ;

    public static final String BARTHEL ="barthel" ;

    public static final String BRADEN ="braden" ;

    public static final String YACHUANG ="yachuang" ;

    public static final String CAPRINI ="caprini" ;

    public static final String PAIN_TIME ="pain_time" ;

    public static final String PAIN_SCORE ="pain_score" ;

    public static final String PAIN_HADLE ="pain_hadle" ;

    public static final String PAIN_HADLENOTE ="pain_hadlenote" ;

    public static final String PAIN_SCORE_AGAIN ="pain_score_again" ;

    public static final String YINGYANGFXSC ="yingyangfxsc" ;

    public static final String YINGYANGFXSC_NOTE ="yingyangfxsc_note" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

        }