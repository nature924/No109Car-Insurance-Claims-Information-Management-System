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
 * 保险订单
 *
 * @author 
 * @email
 */
@TableName("baoxian_order")
public class BaoxianOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxianOrderEntity() {

	}

	public BaoxianOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "baoxian_order_uuid_number")

    private String baoxianOrderUuidNumber;


    /**
     * 保险
     */
    @ColumnInfo(comment="保险",type="int(11)")
    @TableField(value = "baoxian_id")

    private Integer baoxianId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "baoxian_order_true_price")

    private Double baoxianOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "baoxian_order_types")

    private Integer baoxianOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
        return "BaoxianOrder{" +
            ", id=" + id +
            ", baoxianOrderUuidNumber=" + baoxianOrderUuidNumber +
            ", baoxianId=" + baoxianId +
            ", yonghuId=" + yonghuId +
            ", baoxianOrderTruePrice=" + baoxianOrderTruePrice +
            ", baoxianOrderTypes=" + baoxianOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
