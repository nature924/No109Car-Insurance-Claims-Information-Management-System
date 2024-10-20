package com.entity.model;

import com.entity.ShiguYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 理赔申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiguYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String shiguYuyueUuidNumber;


    /**
     * 事故
     */
    private Integer shiguId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 理由
     */
    private String shiguYuyueText;


    /**
     * 理赔申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer shiguYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String shiguYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiguYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
