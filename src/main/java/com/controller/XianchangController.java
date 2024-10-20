
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 现场勘查
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xianchang")
public class XianchangController {
    private static final Logger logger = LoggerFactory.getLogger(XianchangController.class);

    private static final String TABLE_NAME = "xianchang";

    @Autowired
    private XianchangService xianchangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxianService baoxianService;//保险
    @Autowired
    private BaoxianOrderService baoxianOrderService;//保险订单
    @Autowired
    private DiaochaYuyueService diaochaYuyueService;//调查申请
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ShiguService shiguService;//事故调查
    @Autowired
    private ShiguYuyueService shiguYuyueService;//理赔申请
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//事故调查员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("事故调查员".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("xianchangDeleteStart",1);params.put("xianchangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xianchangService.queryPage(params);

        //字典表数据转换
        List<XianchangView> list =(List<XianchangView>)page.getList();
        for(XianchangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XianchangEntity xianchang = xianchangService.selectById(id);
        if(xianchang !=null){
            //entity转view
            XianchangView view = new XianchangView();
            BeanUtils.copyProperties( xianchang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xianchang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 事故调查员
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(xianchang.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XianchangEntity xianchang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xianchang:{}",this.getClass().getName(),xianchang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xianchang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("事故调查员".equals(role))
            xianchang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XianchangEntity> queryWrapper = new EntityWrapper<XianchangEntity>()
            .eq("yonghu_id", xianchang.getYonghuId())
            .eq("yuangong_id", xianchang.getYuangongId())
            .eq("xianchang_name", xianchang.getXianchangName())
            .eq("xianchang_types", xianchang.getXianchangTypes())
            .eq("xianchang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianchangEntity xianchangEntity = xianchangService.selectOne(queryWrapper);
        if(xianchangEntity==null){
            xianchang.setXianchangDelete(1);
            xianchang.setInsertTime(new Date());
            xianchang.setCreateTime(new Date());
            xianchangService.insert(xianchang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XianchangEntity xianchang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xianchang:{}",this.getClass().getName(),xianchang.toString());
        XianchangEntity oldXianchangEntity = xianchangService.selectById(xianchang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xianchang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("事故调查员".equals(role))
//            xianchang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xianchang.getXianchangPhoto()) || "null".equals(xianchang.getXianchangPhoto())){
                xianchang.setXianchangPhoto(null);
        }
        if("".equals(xianchang.getXianchangFile()) || "null".equals(xianchang.getXianchangFile())){
                xianchang.setXianchangFile(null);
        }

            xianchangService.updateById(xianchang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XianchangEntity> oldXianchangList =xianchangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XianchangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XianchangEntity xianchangEntity = new XianchangEntity();
            xianchangEntity.setId(id);
            xianchangEntity.setXianchangDelete(2);
            list.add(xianchangEntity);
        }
        if(list != null && list.size() >0){
            xianchangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XianchangEntity> xianchangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XianchangEntity xianchangEntity = new XianchangEntity();
//                            xianchangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xianchangEntity.setYuangongId(Integer.valueOf(data.get(0)));   //事故调查员 要改的
//                            xianchangEntity.setXianchangName(data.get(0));                    //现场勘查名称 要改的
//                            xianchangEntity.setXianchangUuidNumber(data.get(0));                    //现场勘查编号 要改的
//                            xianchangEntity.setXianchangPhoto("");//详情和图片
//                            xianchangEntity.setXianchangTypes(Integer.valueOf(data.get(0)));   //现场勘查类型 要改的
//                            xianchangEntity.setXianchangFile(data.get(0));                    //文件 要改的
//                            xianchangEntity.setXianchangContent("");//详情和图片
//                            xianchangEntity.setXianchangDelete(1);//逻辑删除字段
//                            xianchangEntity.setInsertTime(date);//时间
//                            xianchangEntity.setCreateTime(date);//时间
                            xianchangList.add(xianchangEntity);


                            //把要查询是否重复的字段放入map中
                                //现场勘查编号
                                if(seachFields.containsKey("xianchangUuidNumber")){
                                    List<String> xianchangUuidNumber = seachFields.get("xianchangUuidNumber");
                                    xianchangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xianchangUuidNumber = new ArrayList<>();
                                    xianchangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xianchangUuidNumber",xianchangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //现场勘查编号
                        List<XianchangEntity> xianchangEntities_xianchangUuidNumber = xianchangService.selectList(new EntityWrapper<XianchangEntity>().in("xianchang_uuid_number", seachFields.get("xianchangUuidNumber")).eq("xianchang_delete", 1));
                        if(xianchangEntities_xianchangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XianchangEntity s:xianchangEntities_xianchangUuidNumber){
                                repeatFields.add(s.getXianchangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [现场勘查编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xianchangService.insertBatch(xianchangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xianchangService.queryPage(params);

        //字典表数据转换
        List<XianchangView> list =(List<XianchangView>)page.getList();
        for(XianchangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XianchangEntity xianchang = xianchangService.selectById(id);
            if(xianchang !=null){


                //entity转view
                XianchangView view = new XianchangView();
                BeanUtils.copyProperties( xianchang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xianchang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(xianchang.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XianchangEntity xianchang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xianchang:{}",this.getClass().getName(),xianchang.toString());
        Wrapper<XianchangEntity> queryWrapper = new EntityWrapper<XianchangEntity>()
            .eq("yonghu_id", xianchang.getYonghuId())
            .eq("yuangong_id", xianchang.getYuangongId())
            .eq("xianchang_name", xianchang.getXianchangName())
            .eq("xianchang_uuid_number", xianchang.getXianchangUuidNumber())
            .eq("xianchang_types", xianchang.getXianchangTypes())
            .eq("xianchang_delete", xianchang.getXianchangDelete())
//            .notIn("xianchang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianchangEntity xianchangEntity = xianchangService.selectOne(queryWrapper);
        if(xianchangEntity==null){
            xianchang.setXianchangDelete(1);
            xianchang.setInsertTime(new Date());
            xianchang.setCreateTime(new Date());
        xianchangService.insert(xianchang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

