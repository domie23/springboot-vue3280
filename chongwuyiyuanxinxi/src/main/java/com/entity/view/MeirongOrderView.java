package com.entity.view;

import com.entity.MeirongOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 美容服务预约信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("meirong_order")
public class MeirongOrderView extends MeirongOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 时间类型的值
		*/
		private String guahaoValue;
		/**
		* 预约状态的值
		*/
		private String meirongOrderStatusValue;



		//级联表 meirong
			/**
			* 美容项目
			*/
			private String meirongName;
			/**
			* 项目类型
			*/
			private Integer meirongTypes;
				/**
				* 项目类型的值
				*/
				private String meirongValue;
			/**
			* 封面
			*/
			private String meirongPhoto;
			/**
			* 价格
			*/
			private Double meirongNewMoney;
			/**
			* 详情信息
			*/
			private String meirongContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public MeirongOrderView() {

	}

	public MeirongOrderView(MeirongOrderEntity meirongOrderEntity) {
		try {
			BeanUtils.copyProperties(this, meirongOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 时间类型的值
			*/
			public String getGuahaoValue() {
				return guahaoValue;
			}
			/**
			* 设置： 时间类型的值
			*/
			public void setGuahaoValue(String guahaoValue) {
				this.guahaoValue = guahaoValue;
			}
			/**
			* 获取： 预约状态的值
			*/
			public String getMeirongOrderStatusValue() {
				return meirongOrderStatusValue;
			}
			/**
			* 设置： 预约状态的值
			*/
			public void setMeirongOrderStatusValue(String meirongOrderStatusValue) {
				this.meirongOrderStatusValue = meirongOrderStatusValue;
			}




























				//级联表的get和set meirong

					/**
					* 获取： 美容项目
					*/
					public String getMeirongName() {
						return meirongName;
					}
					/**
					* 设置： 美容项目
					*/
					public void setMeirongName(String meirongName) {
						this.meirongName = meirongName;
					}

					/**
					* 获取： 项目类型
					*/
					public Integer getMeirongTypes() {
						return meirongTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setMeirongTypes(Integer meirongTypes) {
						this.meirongTypes = meirongTypes;
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

					/**
					* 获取： 封面
					*/
					public String getMeirongPhoto() {
						return meirongPhoto;
					}
					/**
					* 设置： 封面
					*/
					public void setMeirongPhoto(String meirongPhoto) {
						this.meirongPhoto = meirongPhoto;
					}

					/**
					* 获取： 价格
					*/
					public Double getMeirongNewMoney() {
						return meirongNewMoney;
					}
					/**
					* 设置： 价格
					*/
					public void setMeirongNewMoney(Double meirongNewMoney) {
						this.meirongNewMoney = meirongNewMoney;
					}

					/**
					* 获取： 详情信息
					*/
					public String getMeirongContent() {
						return meirongContent;
					}
					/**
					* 设置： 详情信息
					*/
					public void setMeirongContent(String meirongContent) {
						this.meirongContent = meirongContent;
					}













				//级联表的get和set yonghu

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
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
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
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
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

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
