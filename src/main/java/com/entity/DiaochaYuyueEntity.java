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
 * 调查申请
 *
 * @author 
 * @email
 */
@TableName("diaocha_yuyue")
public class DiaochaYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DiaochaYuyueEntity() {

	}

	public DiaochaYuyueEntity(T t) {
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
    @TableField(value = "diaocha_yuyue_uuid_number")

    private String diaochaYuyueUuidNumber;


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
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="时间",type="timestamp")
    @TableField(value = "diaocha_yuyue_time")

    private Date diaochaYuyueTime;


    /**
     * 地点
     */
    @ColumnInfo(comment="地点",type="varchar(200)")
    @TableField(value = "diaocha_yuyue_address")

    private String diaochaYuyueAddress;


    /**
     * 严重程度
     */
    @ColumnInfo(comment="严重程度",type="varchar(200)")
    @TableField(value = "diaocha_yuyue_cehngdu")

    private String diaochaYuyueCehngdu;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="longtext")
    @TableField(value = "diaocha_yuyue_text")

    private String diaochaYuyueText;


    /**
     * 调查申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="调查申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "diaocha_yuyue_yesno_types")

    private Integer diaochaYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "diaocha_yuyue_yesno_text")

    private String diaochaYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "diaocha_yuyue_shenhe_time")

    private Date diaochaYuyueShenheTime;


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
    public String getDiaochaYuyueUuidNumber() {
        return diaochaYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setDiaochaYuyueUuidNumber(String diaochaYuyueUuidNumber) {
        this.diaochaYuyueUuidNumber = diaochaYuyueUuidNumber;
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
	 * 获取：时间
	 */
    public Date getDiaochaYuyueTime() {
        return diaochaYuyueTime;
    }
    /**
	 * 设置：时间
	 */

    public void setDiaochaYuyueTime(Date diaochaYuyueTime) {
        this.diaochaYuyueTime = diaochaYuyueTime;
    }
    /**
	 * 获取：地点
	 */
    public String getDiaochaYuyueAddress() {
        return diaochaYuyueAddress;
    }
    /**
	 * 设置：地点
	 */

    public void setDiaochaYuyueAddress(String diaochaYuyueAddress) {
        this.diaochaYuyueAddress = diaochaYuyueAddress;
    }
    /**
	 * 获取：严重程度
	 */
    public String getDiaochaYuyueCehngdu() {
        return diaochaYuyueCehngdu;
    }
    /**
	 * 设置：严重程度
	 */

    public void setDiaochaYuyueCehngdu(String diaochaYuyueCehngdu) {
        this.diaochaYuyueCehngdu = diaochaYuyueCehngdu;
    }
    /**
	 * 获取：理由
	 */
    public String getDiaochaYuyueText() {
        return diaochaYuyueText;
    }
    /**
	 * 设置：理由
	 */

    public void setDiaochaYuyueText(String diaochaYuyueText) {
        this.diaochaYuyueText = diaochaYuyueText;
    }
    /**
	 * 获取：调查申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：调查申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getDiaochaYuyueYesnoTypes() {
        return diaochaYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setDiaochaYuyueYesnoTypes(Integer diaochaYuyueYesnoTypes) {
        this.diaochaYuyueYesnoTypes = diaochaYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getDiaochaYuyueYesnoText() {
        return diaochaYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setDiaochaYuyueYesnoText(String diaochaYuyueYesnoText) {
        this.diaochaYuyueYesnoText = diaochaYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getDiaochaYuyueShenheTime() {
        return diaochaYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setDiaochaYuyueShenheTime(Date diaochaYuyueShenheTime) {
        this.diaochaYuyueShenheTime = diaochaYuyueShenheTime;
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
        return "DiaochaYuyue{" +
            ", id=" + id +
            ", diaochaYuyueUuidNumber=" + diaochaYuyueUuidNumber +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", diaochaYuyueTime=" + DateUtil.convertString(diaochaYuyueTime,"yyyy-MM-dd") +
            ", diaochaYuyueAddress=" + diaochaYuyueAddress +
            ", diaochaYuyueCehngdu=" + diaochaYuyueCehngdu +
            ", diaochaYuyueText=" + diaochaYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", diaochaYuyueYesnoTypes=" + diaochaYuyueYesnoTypes +
            ", diaochaYuyueYesnoText=" + diaochaYuyueYesnoText +
            ", diaochaYuyueShenheTime=" + DateUtil.convertString(diaochaYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
