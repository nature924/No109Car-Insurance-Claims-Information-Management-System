package com.entity.model;

import com.entity.BaoxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 保险
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 保险名称
     */
    private String baoxianName;


    /**
     * 保险编号
     */
    private String baoxianUuidNumber;


    /**
     * 保险照片
     */
    private String baoxianPhoto;


    /**
     * 保险类型
     */
    private Integer baoxianTypes;


    /**
     * 现价/积分
     */
    private Double baoxianNewMoney;


    /**
     * 保险介绍
     */
    private String baoxianContent;


    /**
     * 逻辑删除
     */
    private Integer baoxianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
