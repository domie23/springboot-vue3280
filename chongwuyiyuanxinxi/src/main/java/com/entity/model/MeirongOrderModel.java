package com.entity.model;

import com.entity.MeirongOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容服务预约信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 美容服务
     */
    private Integer meirongId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 就诊识别码
     */
    private String meirongOrderUuidNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date meirongOrderTime;


    /**
     * 时间类型
     */
    private Integer guahaoTypes;


    /**
     * 预约状态
     */
    private Integer meirongOrderStatusTypes;


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
	 * 获取：美容服务
	 */
    public Integer getMeirongId() {
        return meirongId;
    }


    /**
	 * 设置：美容服务
	 */
    public void setMeirongId(Integer meirongId) {
        this.meirongId = meirongId;
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
	 * 获取：就诊识别码
	 */
    public String getMeirongOrderUuidNumber() {
        return meirongOrderUuidNumber;
    }


    /**
	 * 设置：就诊识别码
	 */
    public void setMeirongOrderUuidNumber(String meirongOrderUuidNumber) {
        this.meirongOrderUuidNumber = meirongOrderUuidNumber;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getMeirongOrderTime() {
        return meirongOrderTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setMeirongOrderTime(Date meirongOrderTime) {
        this.meirongOrderTime = meirongOrderTime;
    }
    /**
	 * 获取：时间类型
	 */
    public Integer getGuahaoTypes() {
        return guahaoTypes;
    }


    /**
	 * 设置：时间类型
	 */
    public void setGuahaoTypes(Integer guahaoTypes) {
        this.guahaoTypes = guahaoTypes;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getMeirongOrderStatusTypes() {
        return meirongOrderStatusTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setMeirongOrderStatusTypes(Integer meirongOrderStatusTypes) {
        this.meirongOrderStatusTypes = meirongOrderStatusTypes;
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
