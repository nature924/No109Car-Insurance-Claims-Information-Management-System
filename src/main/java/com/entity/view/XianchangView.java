package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XianchangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 现场勘查
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xianchang")
public class XianchangView extends XianchangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 现场勘查类型的值
	*/
	@ColumnInfo(comment="现场勘查类型的字典表值",type="varchar(200)")
	private String xianchangValue;

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
	//级联表 事故调查员
		/**
		* 事故调查员编号
		*/

		@ColumnInfo(comment="事故调查员编号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 事故调查员姓名
		*/

		@ColumnInfo(comment="事故调查员姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 事故调查员手机号
		*/

		@ColumnInfo(comment="事故调查员手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 事故调查员身份证号
		*/

		@ColumnInfo(comment="事故调查员身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 事故调查员头像
		*/

		@ColumnInfo(comment="事故调查员头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 事故调查员邮箱
		*/

		@ColumnInfo(comment="事故调查员邮箱",type="varchar(200)")
		private String yuangongEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public XianchangView() {

	}

	public XianchangView(XianchangEntity xianchangEntity) {
		try {
			BeanUtils.copyProperties(this, xianchangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 现场勘查类型的值
	*/
	public String getXianchangValue() {
		return xianchangValue;
	}
	/**
	* 设置： 现场勘查类型的值
	*/
	public void setXianchangValue(String xianchangValue) {
		this.xianchangValue = xianchangValue;
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
	//级联表的get和set 事故调查员

		/**
		* 获取： 事故调查员编号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 事故调查员编号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 事故调查员姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 事故调查员姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 事故调查员手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 事故调查员手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 事故调查员身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 事故调查员身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 事故调查员头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 事故调查员头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 事故调查员邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 事故调查员邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "XianchangView{" +
			", xianchangValue=" + xianchangValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			"} " + super.toString();
	}
}
