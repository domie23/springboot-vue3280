package com.dao;

import com.entity.MeirongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongView;

/**
 * 美容服务 Dao 接口
 *
 * @author 
 */
public interface MeirongDao extends BaseMapper<MeirongEntity> {

   List<MeirongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
