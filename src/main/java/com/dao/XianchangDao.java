package com.dao;

import com.entity.XianchangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianchangView;

/**
 * 现场勘查 Dao 接口
 *
 * @author 
 */
public interface XianchangDao extends BaseMapper<XianchangEntity> {

   List<XianchangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
