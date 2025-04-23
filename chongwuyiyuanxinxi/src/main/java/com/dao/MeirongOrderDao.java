package com.dao;

import com.entity.MeirongOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongOrderView;

/**
 * 美容服务预约信息 Dao 接口
 *
 * @author 
 */
public interface MeirongOrderDao extends BaseMapper<MeirongOrderEntity> {

   List<MeirongOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
