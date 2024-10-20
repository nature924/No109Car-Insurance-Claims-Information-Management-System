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
 * 保险
 *
 * @author 
 * @email
 */
@TableName("baoxian")
public class BaoxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxianEntity() {

	}

	public BaoxianEntity(T t) {
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
     * 保险名称
     */
    @ColumnInfo(comment="保险名称",type="varchar(200)")
    @TableField(value = "baoxian_name")

    private String baoxianName;


    /**
     * 保险编号
     */
    @ColumnInfo(comment="保险编号",type="varchar(200)")
    @TableField(value = "baoxian_uuid_number")

    private String baoxianUuidNumber;


    /**
     * 保险照片
     */
    @ColumnInfo(comment="保险照片",type="varchar(200)")
    @TableField(value = "baoxian_photo")

    private String baoxianPhoto;


    /**
     * 保险类型
     */
    @ColumnInfo(comment="保险类型",type="int(11)")
    @TableField(value = "baoxian_types")

    private Integer baoxianTypes;


    /**
     * 现价/积分
     */
    @ColumnInfo(comment="现价/积分",type="decimal(10,2)")
    @TableField(value = "baoxian_new_money")

    private Double baoxianNewMoney;


    /**
     * 保险介绍
     */
    @ColumnInfo(comment="保险介绍",type="longtext")
    @TableField(value = "baoxian_content")

    private String baoxianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "baoxian_delete")

    private Integer baoxianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：保险名称
	 */
    public String getBaoxianName() {
        return baoxianName;
    }
    /**
	 * 设置：保险名称
	 */

    public void setBaoxianName(String baoxianName) {
        this.baoxianName = baoxianName;
    }
    /**
	 * 获取：保险编号
	 */
    public String getBaoxianUuidNumber() {
        return baoxianUuidNumber;
    }
    /**
	 * 设置：保险编号
	 */

    public void setBaoxianUuidNumber(String baoxianUuidNumber) {
        this.baoxianUuidNumber = baoxianUuidNumber;
    }
    /**
	 * 获取：保险照片
	 */
    public String getBaoxianPhoto() {
        return baoxianPhoto;
    }
    /**
	 * 设置：保险照片
	 */

    public void setBaoxianPhoto(String baoxianPhoto) {
        this.baoxianPhoto = baoxianPhoto;
    }
    /**
	 * 获取：保险类型
	 */
    public Integer getBaoxianTypes() {
        return baoxianTypes;
    }
    /**
	 * 设置：保险类型
	 */

    public void setBaoxianTypes(Integer baoxianTypes) {
        this.baoxianTypes = baoxianTypes;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getBaoxianNewMoney() {
        return baoxianNewMoney;
    }
    /**
	 * 设置：现价/积分
	 */

    public void setBaoxianNewMoney(Double baoxianNewMoney) {
        this.baoxianNewMoney = baoxianNewMoney;
    }
    /**
	 * 获取：保险介绍
	 */
    public String getBaoxianContent() {
        return baoxianContent;
    }
    /**
	 * 设置：保险介绍
	 */

    public void setBaoxianContent(String baoxianContent) {
        this.baoxianContent = baoxianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getBaoxianDelete() {
        return baoxianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setBaoxianDelete(Integer baoxianDelete) {
        this.baoxianDelete = baoxianDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Baoxian{" +
            ", id=" + id +
            ", baoxianName=" + baoxianName +
            ", baoxianUuidNumber=" + baoxianUuidNumber +
            ", baoxianPhoto=" + baoxianPhoto +
            ", baoxianTypes=" + baoxianTypes +
            ", baoxianNewMoney=" + baoxianNewMoney +
            ", baoxianContent=" + baoxianContent +
            ", baoxianDelete=" + baoxianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
