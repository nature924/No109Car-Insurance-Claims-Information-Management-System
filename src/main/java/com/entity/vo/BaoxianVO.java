package com.entity.vo;

import com.entity.BaoxianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 保险
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoxian")
public class BaoxianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 保险名称
     */

    @TableField(value = "baoxian_name")
    private String baoxianName;


    /**
     * 保险编号
     */

    @TableField(value = "baoxian_uuid_number")
    private String baoxianUuidNumber;


    /**
     * 保险照片
     */

    @TableField(value = "baoxian_photo")
    private String baoxianPhoto;


    /**
     * 保险类型
     */

    @TableField(value = "baoxian_types")
    private Integer baoxianTypes;


    /**
     * 现价/积分
     */

    @TableField(value = "baoxian_new_money")
    private Double baoxianNewMoney;


    /**
     * 保险介绍
     */

    @TableField(value = "baoxian_content")
    private String baoxianContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "baoxian_delete")
    private Integer baoxianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：保险名称
	 */
    public String getBaoxianName() {
        return baoxianName;
    }


    /**
	 * 获取：保险名称
	 */

    public void setBaoxianName(String baoxianName) {
        this.baoxianName = baoxianName;
    }
    /**
	 * 设置：保险编号
	 */
    public String getBaoxianUuidNumber() {
        return baoxianUuidNumber;
    }


    /**
	 * 获取：保险编号
	 */

    public void setBaoxianUuidNumber(String baoxianUuidNumber) {
        this.baoxianUuidNumber = baoxianUuidNumber;
    }
    /**
	 * 设置：保险照片
	 */
    public String getBaoxianPhoto() {
        return baoxianPhoto;
    }


    /**
	 * 获取：保险照片
	 */

    public void setBaoxianPhoto(String baoxianPhoto) {
        this.baoxianPhoto = baoxianPhoto;
    }
    /**
	 * 设置：保险类型
	 */
    public Integer getBaoxianTypes() {
        return baoxianTypes;
    }


    /**
	 * 获取：保险类型
	 */

    public void setBaoxianTypes(Integer baoxianTypes) {
        this.baoxianTypes = baoxianTypes;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getBaoxianNewMoney() {
        return baoxianNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setBaoxianNewMoney(Double baoxianNewMoney) {
        this.baoxianNewMoney = baoxianNewMoney;
    }
    /**
	 * 设置：保险介绍
	 */
    public String getBaoxianContent() {
        return baoxianContent;
    }


    /**
	 * 获取：保险介绍
	 */

    public void setBaoxianContent(String baoxianContent) {
        this.baoxianContent = baoxianContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getBaoxianDelete() {
        return baoxianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setBaoxianDelete(Integer baoxianDelete) {
        this.baoxianDelete = baoxianDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
