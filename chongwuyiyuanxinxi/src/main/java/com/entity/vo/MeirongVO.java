package com.entity.vo;

import com.entity.MeirongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirong")
public class MeirongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
