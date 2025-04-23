package com.entity.vo;

import com.entity.MeirongOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容服务预约信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirong_order")
public class MeirongOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 美容服务
     */

    @TableField(value = "meirong_id")
    private Integer meirongId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 就诊识别码
     */

    @TableField(value = "meirong_order_uuid_number")
    private String meirongOrderUuidNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "meirong_order_time")
    private Date meirongOrderTime;


    /**
     * 时间类型
     */

    @TableField(value = "guahao_types")
    private Integer guahaoTypes;


    /**
     * 预约状态
     */

    @TableField(value = "meirong_order_status_types")
    private Integer meirongOrderStatusTypes;


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
	 * 设置：美容服务
	 */
    public Integer getMeirongId() {
        return meirongId;
    }


    /**
	 * 获取：美容服务
	 */

    public void setMeirongId(Integer meirongId) {
        this.meirongId = meirongId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：就诊识别码
	 */
    public String getMeirongOrderUuidNumber() {
        return meirongOrderUuidNumber;
    }


    /**
	 * 获取：就诊识别码
	 */

    public void setMeirongOrderUuidNumber(String meirongOrderUuidNumber) {
        this.meirongOrderUuidNumber = meirongOrderUuidNumber;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getMeirongOrderTime() {
        return meirongOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setMeirongOrderTime(Date meirongOrderTime) {
        this.meirongOrderTime = meirongOrderTime;
    }
    /**
	 * 设置：时间类型
	 */
    public Integer getGuahaoTypes() {
        return guahaoTypes;
    }


    /**
	 * 获取：时间类型
	 */

    public void setGuahaoTypes(Integer guahaoTypes) {
        this.guahaoTypes = guahaoTypes;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getMeirongOrderStatusTypes() {
        return meirongOrderStatusTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setMeirongOrderStatusTypes(Integer meirongOrderStatusTypes) {
        this.meirongOrderStatusTypes = meirongOrderStatusTypes;
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
