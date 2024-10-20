package com.dao;

import com.entity.DiaochaYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DiaochaYuyueView;

/**
 * 调查申请 Dao 接口
 *
 * @author 
 */
public interface DiaochaYuyueDao extends BaseMapper<DiaochaYuyueEntity> {

   List<DiaochaYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
