package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BaoxianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 保险
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("baoxian")
public class BaoxianView extends BaoxianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 保险类型的值
	*/
	@ColumnInfo(comment="保险类型的字典表值",type="varchar(200)")
	private String baoxianValue;




	public BaoxianView() {

	}

	public BaoxianView(BaoxianEntity baoxianEntity) {
		try {
			BeanUtils.copyProperties(this, baoxianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "BaoxianView{" +
			", baoxianValue=" + baoxianValue +
			"} " + super.toString();
	}
}
