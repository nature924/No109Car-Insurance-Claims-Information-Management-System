package com.dao;

import com.entity.ShiguYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiguYuyueView;

/**
 * 理赔申请 Dao 接口
 *
 * @author 
 */
public interface ShiguYuyueDao extends BaseMapper<ShiguYuyueEntity> {

   List<ShiguYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
