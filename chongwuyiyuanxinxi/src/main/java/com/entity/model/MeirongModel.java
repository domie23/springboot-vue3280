package com.entity.model;

import com.entity.MeirongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 美容项目
     */
    private String meirongName;


    /**
     * 项目类型
     */
    private Integer meirongTypes;


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


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：美容项目
	 */
    public String getMeirongName() {
        return meirongName;
    }


    /**
	 * 设置：美容项目
	 */
    public void setMeirongName(String meirongName) {
        this.meirongName = meirongName;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getMeirongTypes() {
        return meirongTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setMeirongTypes(Integer meirongTypes) {
        this.meirongTypes = meirongTypes;
    }
    /**
	 * 获取：封面
	 */
    public String getMeirongPhoto() {
        return meirongPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setMeirongPhoto(String meirongPhoto) {
        this.meirongPhoto = meirongPhoto;
    }
    /**
	 * 获取：价格
	 */
    public Double getMeirongNewMoney() {
        return meirongNewMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setMeirongNewMoney(Double meirongNewMoney) {
        this.meirongNewMoney = meirongNewMoney;
    }
    /**
	 * 获取：详情信息
	 */
    public String getMeirongContent() {
        return meirongContent;
    }


    /**
	 * 设置：详情信息
	 */
    public void setMeirongContent(String meirongContent) {
        this.meirongContent = meirongContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
