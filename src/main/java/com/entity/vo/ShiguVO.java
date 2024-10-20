package com.entity.vo;

import com.entity.ShiguEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 事故调查
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shigu")
public class ShiguVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 事故调查名称
     */

    @TableField(value = "shigu_name")
    private String shiguName;


    /**
     * 事故调查编号
     */

    @TableField(value = "shigu_uuid_number")
    private String shiguUuidNumber;


    /**
     * 事故调查照片
     */

    @TableField(value = "shigu_photo")
    private String shiguPhoto;


    /**
     * 文件
     */

    @TableField(value = "shigu_file")
    private String shiguFile;


    /**
     * 事故调查类型
     */

    @TableField(value = "shigu_types")
    private Integer shiguTypes;


    /**
     * 事故调查介绍
     */

    @TableField(value = "shigu_content")
    private String shiguContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shigu_delete")
    private Integer shiguDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：事故调查名称
	 */
    public String getShiguName() {
        return shiguName;
    }


    /**
	 * 获取：事故调查名称
	 */

    public void setShiguName(String shiguName) {
        this.shiguName = shiguName;
    }
    /**
	 * 设置：事故调查编号
	 */
    public String getShiguUuidNumber() {
        return shiguUuidNumber;
    }


    /**
	 * 获取：事故调查编号
	 */

    public void setShiguUuidNumber(String shiguUuidNumber) {
        this.shiguUuidNumber = shiguUuidNumber;
    }
    /**
	 * 设置：事故调查照片
	 */
    public String getShiguPhoto() {
        return shiguPhoto;
    }


    /**
	 * 获取：事故调查照片
	 */

    public void setShiguPhoto(String shiguPhoto) {
        this.shiguPhoto = shiguPhoto;
    }
    /**
	 * 设置：文件
	 */
    public String getShiguFile() {
        return shiguFile;
    }


    /**
	 * 获取：文件
	 */

    public void setShiguFile(String shiguFile) {
        this.shiguFile = shiguFile;
    }
    /**
	 * 设置：事故调查类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }


    /**
	 * 获取：事故调查类型
	 */

    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 设置：事故调查介绍
	 */
    public String getShiguContent() {
        return shiguContent;
    }


    /**
	 * 获取：事故调查介绍
	 */

    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShiguDelete() {
        return shiguDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShiguDelete(Integer shiguDelete) {
        this.shiguDelete = shiguDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
