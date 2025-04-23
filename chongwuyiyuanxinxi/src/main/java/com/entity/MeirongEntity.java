package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 美容服务
 *
 * @author 
 * @email
 */
@TableName("meirong")
public class MeirongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirongEntity() {

	}

	public MeirongEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 美容项目
     */
    @TableField(value = "meirong_name")

    private String meirongName;


    /**
     * 项目类型
     */
    @TableField(value = "meirong_types")

    private Integer meirongTypes;


    /**
     * 封面
     */
    @TableField(value = "meirong_photo")

    private String meirongPhoto;


    /**
     * 价格
     */
    @TableField(value = "meirong_new_money")

    private Double meirongNewMoney;


    /**
     * 详情信息
     */
    @TableField(value = "meirong_content")

    private String meirongContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：美容项目
	 */
    public String getMeirongName() {
        return meirongName;
    }
    /**
	 * 获取：美容项目
	 */

    public void setMeirongName(String meirongName) {
        this.meirongName = meirongName;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getMeirongTypes() {
        return meirongTypes;
    }
    /**
	 * 获取：项目类型
	 */

    public void setMeirongTypes(Integer meirongTypes) {
        this.meirongTypes = meirongTypes;
    }
    /**
	 * 设置：封面
	 */
    public String getMeirongPhoto() {
        return meirongPhoto;
    }
    /**
	 * 获取：封面
	 */

    public void setMeirongPhoto(String meirongPhoto) {
        this.meirongPhoto = meirongPhoto;
    }
    /**
	 * 设置：价格
	 */
    public Double getMeirongNewMoney() {
        return meirongNewMoney;
    }
    /**
	 * 获取：价格
	 */

    public void setMeirongNewMoney(Double meirongNewMoney) {
        this.meirongNewMoney = meirongNewMoney;
    }
    /**
	 * 设置：详情信息
	 */
    public String getMeirongContent() {
        return meirongContent;
    }
    /**
	 * 获取：详情信息
	 */

    public void setMeirongContent(String meirongContent) {
        this.meirongContent = meirongContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Meirong{" +
            "id=" + id +
            ", meirongName=" + meirongName +
            ", meirongTypes=" + meirongTypes +
            ", meirongPhoto=" + meirongPhoto +
            ", meirongNewMoney=" + meirongNewMoney +
            ", meirongContent=" + meirongContent +
            ", createTime=" + createTime +
        "}";
    }
}
