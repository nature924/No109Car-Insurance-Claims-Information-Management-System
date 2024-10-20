package com.entity.vo;

import com.entity.BaoxianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 保险订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoxian_order")
public class BaoxianOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "baoxian_order_uuid_number")
    private String baoxianOrderUuidNumber;


    /**
     * 保险
     */

    @TableField(value = "baoxian_id")
    private Integer baoxianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "baoxian_order_true_price")
    private Double baoxianOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "baoxian_order_types")
    private Integer baoxianOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：订单编号
	 */
    public String getBaoxianOrderUuidNumber() {
        return baoxianOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setBaoxianOrderUuidNumber(String baoxianOrderUuidNumber) {
        this.baoxianOrderUuidNumber = baoxianOrderUuidNumber;
    }
    /**
	 * 设置：保险
	 */
    public Integer getBaoxianId() {
        return baoxianId;
    }


    /**
	 * 获取：保险
	 */

    public void setBaoxianId(Integer baoxianId) {
        this.baoxianId = baoxianId;
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
	 * 设置：实付价格
	 */
    public Double getBaoxianOrderTruePrice() {
        return baoxianOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setBaoxianOrderTruePrice(Double baoxianOrderTruePrice) {
        this.baoxianOrderTruePrice = baoxianOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getBaoxianOrderTypes() {
        return baoxianOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setBaoxianOrderTypes(Integer baoxianOrderTypes) {
        this.baoxianOrderTypes = baoxianOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
