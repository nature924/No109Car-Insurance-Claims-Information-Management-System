package com.entity.vo;

import com.entity.ShiguYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 理赔申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shigu_yuyue")
public class ShiguYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "shigu_yuyue_uuid_number")
    private String shiguYuyueUuidNumber;


    /**
     * 事故
     */

    @TableField(value = "shigu_id")
    private Integer shiguId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 理由
     */

    @TableField(value = "shigu_yuyue_text")
    private String shiguYuyueText;


    /**
     * 理赔申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "shigu_yuyue_yesno_types")
    private Integer shiguYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "shigu_yuyue_yesno_text")
    private String shiguYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shigu_yuyue_shenhe_time")
    private Date shiguYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getShiguYuyueUuidNumber() {
        return shiguYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setShiguYuyueUuidNumber(String shiguYuyueUuidNumber) {
        this.shiguYuyueUuidNumber = shiguYuyueUuidNumber;
    }
    /**
	 * 设置：事故
	 */
    public Integer getShiguId() {
        return shiguId;
    }


    /**
	 * 获取：事故
	 */

    public void setShiguId(Integer shiguId) {
        this.shiguId = shiguId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：理由
	 */
    public String getShiguYuyueText() {
        return shiguYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setShiguYuyueText(String shiguYuyueText) {
        this.shiguYuyueText = shiguYuyueText;
    }
    /**
	 * 设置：理赔申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：理赔申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getShiguYuyueYesnoTypes() {
        return shiguYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setShiguYuyueYesnoTypes(Integer shiguYuyueYesnoTypes) {
        this.shiguYuyueYesnoTypes = shiguYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getShiguYuyueYesnoText() {
        return shiguYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setShiguYuyueYesnoText(String shiguYuyueYesnoText) {
        this.shiguYuyueYesnoText = shiguYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShiguYuyueShenheTime() {
        return shiguYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShiguYuyueShenheTime(Date shiguYuyueShenheTime) {
        this.shiguYuyueShenheTime = shiguYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
