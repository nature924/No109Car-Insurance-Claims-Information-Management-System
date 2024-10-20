package com.dao;

import com.entity.BaoxianOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxianOrderView;

/**
 * 保险订单 Dao 接口
 *
 * @author 
 */
public interface BaoxianOrderDao extends BaseMapper<BaoxianOrderEntity> {

   List<BaoxianOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
