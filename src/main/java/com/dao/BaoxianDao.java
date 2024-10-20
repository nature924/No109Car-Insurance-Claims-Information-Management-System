package com.dao;

import com.entity.BaoxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxianView;

/**
 * 保险 Dao 接口
 *
 * @author 
 */
public interface BaoxianDao extends BaseMapper<BaoxianEntity> {

   List<BaoxianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
