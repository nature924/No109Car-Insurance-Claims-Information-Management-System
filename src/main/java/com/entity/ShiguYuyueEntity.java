package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 理赔申请
 *
 * @author 
 * @email
 */
@TableName("shigu_yuyue")
public class ShiguYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiguYuyueEntity() {

	}

	public ShiguYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "shigu_yuyue_uuid_number")

    private String shiguYuyueUuidNumber;


    /**
     * 事故
     */
    @ColumnInfo(comment="事故",type="int(11)")
    @TableField(value = "shigu_id")

    private Integer shiguId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 事故调查员
     */
    @ColumnInfo(comment="事故调查员",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="longtext")
    @TableField(value = "shigu_yuyue_text")

    private String shiguYuyueText;


    /**
     * 理赔申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="理赔申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "shigu_yuyue_yesno_types")

    private Integer shiguYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "shigu_yuyue_yesno_text")

    private String shiguYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shigu_yuyue_shenhe_time")

    private Date shiguYuyueShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名编号
	 */
    public String getShiguYuyueUuidNumber() {
        return shiguYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setShiguYuyueUuidNumber(String shiguYuyueUuidNumber) {
        this.shiguYuyueUuidNumber = shiguYuyueUuidNumber;
    }
    /**
	 * 获取：事故
	 */
    public Integer getShiguId() {
        return shiguId;
    }
    /**
	 * 设置：事故
	 */

    public void setShiguId(Integer shiguId) {
        this.shiguId = shiguId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：事故调查员
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：事故调查员
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：理由
	 */
    public String getShiguYuyueText() {
        return shiguYuyueText;
    }
    /**
	 * 设置：理由
	 */

    public void setShiguYuyueText(String shiguYuyueText) {
        this.shiguYuyueText = shiguYuyueText;
    }
    /**
	 * 获取：理赔申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：理赔申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getShiguYuyueYesnoTypes() {
        return shiguYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setShiguYuyueYesnoTypes(Integer shiguYuyueYesnoTypes) {
        this.shiguYuyueYesnoTypes = shiguYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getShiguYuyueYesnoText() {
        return shiguYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setShiguYuyueYesnoText(String shiguYuyueYesnoText) {
        this.shiguYuyueYesnoText = shiguYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShiguYuyueShenheTime() {
        return shiguYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setShiguYuyueShenheTime(Date shiguYuyueShenheTime) {
        this.shiguYuyueShenheTime = shiguYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShiguYuyue{" +
            ", id=" + id +
            ", shiguYuyueUuidNumber=" + shiguYuyueUuidNumber +
            ", shiguId=" + shiguId +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", shiguYuyueText=" + shiguYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", shiguYuyueYesnoTypes=" + shiguYuyueYesnoTypes +
            ", shiguYuyueYesnoText=" + shiguYuyueYesnoText +
            ", shiguYuyueShenheTime=" + DateUtil.convertString(shiguYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
