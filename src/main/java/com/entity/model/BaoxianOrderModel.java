package com.entity.model;

import com.entity.BaoxianOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 保险订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxianOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String baoxianOrderUuidNumber;


    /**
     * 保险
     */
    private Integer baoxianId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double baoxianOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer baoxianOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：订单编号
	 */
    public String getBaoxianOrderUuidNumber() {
        return baoxianOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setBaoxianOrderUuidNumber(String baoxianOrderUuidNumber) {
        this.baoxianOrderUuidNumber = baoxianOrderUuidNumber;
    }
    /**
	 * 获取：保险
	 */
    public Integer getBaoxianId() {
        return baoxianId;
    }


    /**
	 * 设置：保险
	 */
    public void setBaoxianId(Integer baoxianId) {
        this.baoxianId = baoxianId;
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
	 * 获取：实付价格
	 */
    public Double getBaoxianOrderTruePrice() {
        return baoxianOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setBaoxianOrderTruePrice(Double baoxianOrderTruePrice) {
        this.baoxianOrderTruePrice = baoxianOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getBaoxianOrderTypes() {
        return baoxianOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setBaoxianOrderTypes(Integer baoxianOrderTypes) {
        this.baoxianOrderTypes = baoxianOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
