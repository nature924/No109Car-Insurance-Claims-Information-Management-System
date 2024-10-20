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
 * 现场勘查
 *
 * @author 
 * @email
 */
@TableName("xianchang")
public class XianchangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XianchangEntity() {

	}

	public XianchangEntity(T t) {
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
     * 现场勘查名称
     */
    @ColumnInfo(comment="现场勘查名称",type="varchar(200)")
    @TableField(value = "xianchang_name")

    private String xianchangName;


    /**
     * 现场勘查编号
     */
    @ColumnInfo(comment="现场勘查编号",type="varchar(200)")
    @TableField(value = "xianchang_uuid_number")

    private String xianchangUuidNumber;


    /**
     * 现场勘查照片
     */
    @ColumnInfo(comment="现场勘查照片",type="varchar(200)")
    @TableField(value = "xianchang_photo")

    private String xianchangPhoto;


    /**
     * 现场勘查类型
     */
    @ColumnInfo(comment="现场勘查类型",type="int(11)")
    @TableField(value = "xianchang_types")

    private Integer xianchangTypes;


    /**
     * 文件
     */
    @ColumnInfo(comment="文件",type="varchar(200)")
    @TableField(value = "xianchang_file")

    private String xianchangFile;


    /**
     * 现场勘查备注
     */
    @ColumnInfo(comment="现场勘查备注",type="longtext")
    @TableField(value = "xianchang_content")

    private String xianchangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xianchang_delete")

    private Integer xianchangDelete;


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
	 * 获取：现场勘查名称
	 */
    public String getXianchangName() {
        return xianchangName;
    }
    /**
	 * 设置：现场勘查名称
	 */

    public void setXianchangName(String xianchangName) {
        this.xianchangName = xianchangName;
    }
    /**
	 * 获取：现场勘查编号
	 */
    public String getXianchangUuidNumber() {
        return xianchangUuidNumber;
    }
    /**
	 * 设置：现场勘查编号
	 */

    public void setXianchangUuidNumber(String xianchangUuidNumber) {
        this.xianchangUuidNumber = xianchangUuidNumber;
    }
    /**
	 * 获取：现场勘查照片
	 */
    public String getXianchangPhoto() {
        return xianchangPhoto;
    }
    /**
	 * 设置：现场勘查照片
	 */

    public void setXianchangPhoto(String xianchangPhoto) {
        this.xianchangPhoto = xianchangPhoto;
    }
    /**
	 * 获取：现场勘查类型
	 */
    public Integer getXianchangTypes() {
        return xianchangTypes;
    }
    /**
	 * 设置：现场勘查类型
	 */

    public void setXianchangTypes(Integer xianchangTypes) {
        this.xianchangTypes = xianchangTypes;
    }
    /**
	 * 获取：文件
	 */
    public String getXianchangFile() {
        return xianchangFile;
    }
    /**
	 * 设置：文件
	 */

    public void setXianchangFile(String xianchangFile) {
        this.xianchangFile = xianchangFile;
    }
    /**
	 * 获取：现场勘查备注
	 */
    public String getXianchangContent() {
        return xianchangContent;
    }
    /**
	 * 设置：现场勘查备注
	 */

    public void setXianchangContent(String xianchangContent) {
        this.xianchangContent = xianchangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXianchangDelete() {
        return xianchangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXianchangDelete(Integer xianchangDelete) {
        this.xianchangDelete = xianchangDelete;
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
        return "Xianchang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", xianchangName=" + xianchangName +
            ", xianchangUuidNumber=" + xianchangUuidNumber +
            ", xianchangPhoto=" + xianchangPhoto +
            ", xianchangTypes=" + xianchangTypes +
            ", xianchangFile=" + xianchangFile +
            ", xianchangContent=" + xianchangContent +
            ", xianchangDelete=" + xianchangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
