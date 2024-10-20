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
 * 事故调查
 *
 * @author 
 * @email
 */
@TableName("shigu")
public class ShiguEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiguEntity() {

	}

	public ShiguEntity(T t) {
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
     * 事故调查名称
     */
    @ColumnInfo(comment="事故调查名称",type="varchar(200)")
    @TableField(value = "shigu_name")

    private String shiguName;


    /**
     * 事故调查编号
     */
    @ColumnInfo(comment="事故调查编号",type="varchar(200)")
    @TableField(value = "shigu_uuid_number")

    private String shiguUuidNumber;


    /**
     * 事故调查照片
     */
    @ColumnInfo(comment="事故调查照片",type="varchar(200)")
    @TableField(value = "shigu_photo")

    private String shiguPhoto;


    /**
     * 文件
     */
    @ColumnInfo(comment="文件",type="varchar(200)")
    @TableField(value = "shigu_file")

    private String shiguFile;


    /**
     * 事故调查类型
     */
    @ColumnInfo(comment="事故调查类型",type="int(11)")
    @TableField(value = "shigu_types")

    private Integer shiguTypes;


    /**
     * 事故调查介绍
     */
    @ColumnInfo(comment="事故调查介绍",type="longtext")
    @TableField(value = "shigu_content")

    private String shiguContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shigu_delete")

    private Integer shiguDelete;


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
	 * 获取：事故调查名称
	 */
    public String getShiguName() {
        return shiguName;
    }
    /**
	 * 设置：事故调查名称
	 */

    public void setShiguName(String shiguName) {
        this.shiguName = shiguName;
    }
    /**
	 * 获取：事故调查编号
	 */
    public String getShiguUuidNumber() {
        return shiguUuidNumber;
    }
    /**
	 * 设置：事故调查编号
	 */

    public void setShiguUuidNumber(String shiguUuidNumber) {
        this.shiguUuidNumber = shiguUuidNumber;
    }
    /**
	 * 获取：事故调查照片
	 */
    public String getShiguPhoto() {
        return shiguPhoto;
    }
    /**
	 * 设置：事故调查照片
	 */

    public void setShiguPhoto(String shiguPhoto) {
        this.shiguPhoto = shiguPhoto;
    }
    /**
	 * 获取：文件
	 */
    public String getShiguFile() {
        return shiguFile;
    }
    /**
	 * 设置：文件
	 */

    public void setShiguFile(String shiguFile) {
        this.shiguFile = shiguFile;
    }
    /**
	 * 获取：事故调查类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }
    /**
	 * 设置：事故调查类型
	 */

    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 获取：事故调查介绍
	 */
    public String getShiguContent() {
        return shiguContent;
    }
    /**
	 * 设置：事故调查介绍
	 */

    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShiguDelete() {
        return shiguDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShiguDelete(Integer shiguDelete) {
        this.shiguDelete = shiguDelete;
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
        return "Shigu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", shiguName=" + shiguName +
            ", shiguUuidNumber=" + shiguUuidNumber +
            ", shiguPhoto=" + shiguPhoto +
            ", shiguFile=" + shiguFile +
            ", shiguTypes=" + shiguTypes +
            ", shiguContent=" + shiguContent +
            ", shiguDelete=" + shiguDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
