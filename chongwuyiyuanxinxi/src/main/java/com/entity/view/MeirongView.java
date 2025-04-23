package com.entity.view;

import com.entity.MeirongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 美容服务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("meirong")
public class MeirongView extends MeirongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 项目类型的值
		*/
		private String meirongValue;



	public MeirongView() {

	}

	public MeirongView(MeirongEntity meirongEntity) {
		try {
			BeanUtils.copyProperties(this, meirongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 项目类型的值
			*/
			public String getMeirongValue() {
				return meirongValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setMeirongValue(String meirongValue) {
				this.meirongValue = meirongValue;
			}
















}
