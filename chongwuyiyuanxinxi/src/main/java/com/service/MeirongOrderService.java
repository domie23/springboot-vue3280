package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeirongOrderEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 美容服务预约信息 服务类
 */
public interface MeirongOrderService extends IService<MeirongOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}