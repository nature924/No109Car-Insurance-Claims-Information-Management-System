package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BaoxianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 保险订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("baoxian_order")
public class BaoxianOrderView extends BaoxianOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String baoxianOrderValue;

	//级联表 保险
		/**
		* 保险名称
		*/

		@ColumnInfo(comment="保险名称",type="varchar(200)")
		private String baoxianName;
		/**
		* 保险编号
		*/

		@ColumnInfo(comment="保险编号",type="varchar(200)")
		private String baoxianUuidNumber;
		/**
		* 保险照片
		*/

		@ColumnInfo(comment="保险照片",type="varchar(200)")
		private String baoxianPhoto;
		/**
		* 保险类型
		*/
		@ColumnInfo(comment="保险类型",type="int(11)")
		private Integer baoxianTypes;
			/**
			* 保险类型的值
			*/
			@ColumnInfo(comment="保险类型的字典表值",type="varchar(200)")
			private String baoxianValue;
		/**
		* 现价/积分
		*/
		@ColumnInfo(comment="现价/积分",type="decimal(10,2)")
		private Double baoxianNewMoney;
		/**
		* 保险介绍
		*/

		@ColumnInfo(comment="保险介绍",type="longtext")
		private String baoxianContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer baoxianDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public BaoxianOrderView() {

	}

	public BaoxianOrderView(BaoxianOrderEntity baoxianOrderEntity) {
		try {
			BeanUtils.copyProperties(this, baoxianOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getBaoxianOrderValue() {
		return baoxianOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setBaoxianOrderValue(String baoxianOrderValue) {
		this.baoxianOrderValue = baoxianOrderValue;
	}


	//级联表的get和set 保险

		/**
		* 获取： 保险名称
		*/
		public String getBaoxianName() {
			return baoxianName;
		}
		/**
		* 设置： 保险名称
		*/
		public void setBaoxianName(String baoxianName) {
			this.baoxianName = baoxianName;
		}

		/**
		* 获取： 保险编号
		*/
		public String getBaoxianUuidNumber() {
			return baoxianUuidNumber;
		}
		/**
		* 设置： 保险编号
		*/
		public void setBaoxianUuidNumber(String baoxianUuidNumber) {
			this.baoxianUuidNumber = baoxianUuidNumber;
		}

		/**
		* 获取： 保险照片
		*/
		public String getBaoxianPhoto() {
			return baoxianPhoto;
		}
		/**
		* 设置： 保险照片
		*/
		public void setBaoxianPhoto(String baoxianPhoto) {
			this.baoxianPhoto = baoxianPhoto;
		}
		/**
		* 获取： 保险类型
		*/
		public Integer getBaoxianTypes() {
			return baoxianTypes;
		}
		/**
		* 设置： 保险类型
		*/
		public void setBaoxianTypes(Integer baoxianTypes) {
			this.baoxianTypes = baoxianTypes;
		}


			/**
			* 获取： 保险类型的值
			*/
			public String getBaoxianValue() {
				return baoxianValue;
			}
			/**
			* 设置： 保险类型的值
			*/
			public void setBaoxianValue(String baoxianValue) {
				this.baoxianValue = baoxianValue;
			}

		/**
		* 获取： 现价/积分
		*/
		public Double getBaoxianNewMoney() {
			return baoxianNewMoney;
		}
		/**
		* 设置： 现价/积分
		*/
		public void setBaoxianNewMoney(Double baoxianNewMoney) {
			this.baoxianNewMoney = baoxianNewMoney;
		}

		/**
		* 获取： 保险介绍
		*/
		public String getBaoxianContent() {
			return baoxianContent;
		}
		/**
		* 设置： 保险介绍
		*/
		public void setBaoxianContent(String baoxianContent) {
			this.baoxianContent = baoxianContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getBaoxianDelete() {
			return baoxianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setBaoxianDelete(Integer baoxianDelete) {
			this.baoxianDelete = baoxianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "BaoxianOrderView{" +
			", baoxianOrderValue=" + baoxianOrderValue +
			", baoxianName=" + baoxianName +
			", baoxianUuidNumber=" + baoxianUuidNumber +
			", baoxianPhoto=" + baoxianPhoto +
			", baoxianNewMoney=" + baoxianNewMoney +
			", baoxianContent=" + baoxianContent +
			", baoxianDelete=" + baoxianDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
