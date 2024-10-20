
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
 * 保险
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoxian")
public class BaoxianController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxianController.class);

    private static final String TABLE_NAME = "baoxian";

    @Autowired
    private BaoxianService baoxianService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxianOrderService baoxianOrderService;//保险订单
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
    private XianchangService xianchangService;//现场勘查
    @Autowired
    private YonghuService yonghuService;//用户
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
        params.put("baoxianDeleteStart",1);params.put("baoxianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = baoxianService.queryPage(params);

        //字典表数据转换
        List<BaoxianView> list =(List<BaoxianView>)page.getList();
        for(BaoxianView c:list){
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
        BaoxianEntity baoxian = baoxianService.selectById(id);
        if(baoxian !=null){
            //entity转view
            BaoxianView view = new BaoxianView();
            BeanUtils.copyProperties( baoxian , view );//把实体数据重构到view中
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
    public R save(@RequestBody BaoxianEntity baoxian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxian:{}",this.getClass().getName(),baoxian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BaoxianEntity> queryWrapper = new EntityWrapper<BaoxianEntity>()
            .eq("baoxian_name", baoxian.getBaoxianName())
            .eq("baoxian_types", baoxian.getBaoxianTypes())
            .eq("baoxian_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxianEntity baoxianEntity = baoxianService.selectOne(queryWrapper);
        if(baoxianEntity==null){
            baoxian.setBaoxianDelete(1);
            baoxian.setInsertTime(new Date());
            baoxian.setCreateTime(new Date());
            baoxianService.insert(baoxian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxianEntity baoxian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,baoxian:{}",this.getClass().getName(),baoxian.toString());
        BaoxianEntity oldBaoxianEntity = baoxianService.selectById(baoxian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(baoxian.getBaoxianPhoto()) || "null".equals(baoxian.getBaoxianPhoto())){
                baoxian.setBaoxianPhoto(null);
        }

            baoxianService.updateById(baoxian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BaoxianEntity> oldBaoxianList =baoxianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<BaoxianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            BaoxianEntity baoxianEntity = new BaoxianEntity();
            baoxianEntity.setId(id);
            baoxianEntity.setBaoxianDelete(2);
            list.add(baoxianEntity);
        }
        if(list != null && list.size() >0){
            baoxianService.updateBatchById(list);
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
            List<BaoxianEntity> baoxianList = new ArrayList<>();//上传的东西
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
                            BaoxianEntity baoxianEntity = new BaoxianEntity();
//                            baoxianEntity.setBaoxianName(data.get(0));                    //保险名称 要改的
//                            baoxianEntity.setBaoxianUuidNumber(data.get(0));                    //保险编号 要改的
//                            baoxianEntity.setBaoxianPhoto("");//详情和图片
//                            baoxianEntity.setBaoxianTypes(Integer.valueOf(data.get(0)));   //保险类型 要改的
//                            baoxianEntity.setBaoxianNewMoney(data.get(0));                    //现价/积分 要改的
//                            baoxianEntity.setBaoxianContent("");//详情和图片
//                            baoxianEntity.setBaoxianDelete(1);//逻辑删除字段
//                            baoxianEntity.setInsertTime(date);//时间
//                            baoxianEntity.setCreateTime(date);//时间
                            baoxianList.add(baoxianEntity);


                            //把要查询是否重复的字段放入map中
                                //保险编号
                                if(seachFields.containsKey("baoxianUuidNumber")){
                                    List<String> baoxianUuidNumber = seachFields.get("baoxianUuidNumber");
                                    baoxianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> baoxianUuidNumber = new ArrayList<>();
                                    baoxianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("baoxianUuidNumber",baoxianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //保险编号
                        List<BaoxianEntity> baoxianEntities_baoxianUuidNumber = baoxianService.selectList(new EntityWrapper<BaoxianEntity>().in("baoxian_uuid_number", seachFields.get("baoxianUuidNumber")).eq("baoxian_delete", 1));
                        if(baoxianEntities_baoxianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BaoxianEntity s:baoxianEntities_baoxianUuidNumber){
                                repeatFields.add(s.getBaoxianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [保险编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        baoxianService.insertBatch(baoxianList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<BaoxianView> returnBaoxianViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = baoxianOrderService.queryPage(params1);
        List<BaoxianOrderView> orderViewsList =(List<BaoxianOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(BaoxianOrderView orderView:orderViewsList){
            Integer baoxianTypes = orderView.getBaoxianTypes();
            if(typeMap.containsKey(baoxianTypes)){
                typeMap.put(baoxianTypes,typeMap.get(baoxianTypes)+1);
            }else{
                typeMap.put(baoxianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("baoxianTypes",type);
            PageUtils pageUtils1 = baoxianService.queryPage(params2);
            List<BaoxianView> baoxianViewList =(List<BaoxianView>)pageUtils1.getList();
            returnBaoxianViewList.addAll(baoxianViewList);
            if(returnBaoxianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = baoxianService.queryPage(params);
        if(returnBaoxianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnBaoxianViewList.size();//要添加的数量
            List<BaoxianView> baoxianViewList =(List<BaoxianView>)page.getList();
            for(BaoxianView baoxianView:baoxianViewList){
                Boolean addFlag = true;
                for(BaoxianView returnBaoxianView:returnBaoxianViewList){
                    if(returnBaoxianView.getId().intValue() ==baoxianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnBaoxianViewList.add(baoxianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnBaoxianViewList = returnBaoxianViewList.subList(0, limit);
        }

        for(BaoxianView c:returnBaoxianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnBaoxianViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = baoxianService.queryPage(params);

        //字典表数据转换
        List<BaoxianView> list =(List<BaoxianView>)page.getList();
        for(BaoxianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxianEntity baoxian = baoxianService.selectById(id);
            if(baoxian !=null){


                //entity转view
                BaoxianView view = new BaoxianView();
                BeanUtils.copyProperties( baoxian , view );//把实体数据重构到view中

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
    public R add(@RequestBody BaoxianEntity baoxian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,baoxian:{}",this.getClass().getName(),baoxian.toString());
        Wrapper<BaoxianEntity> queryWrapper = new EntityWrapper<BaoxianEntity>()
            .eq("baoxian_name", baoxian.getBaoxianName())
            .eq("baoxian_uuid_number", baoxian.getBaoxianUuidNumber())
            .eq("baoxian_types", baoxian.getBaoxianTypes())
            .eq("baoxian_delete", baoxian.getBaoxianDelete())
//            .notIn("baoxian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxianEntity baoxianEntity = baoxianService.selectOne(queryWrapper);
        if(baoxianEntity==null){
            baoxian.setBaoxianDelete(1);
            baoxian.setInsertTime(new Date());
            baoxian.setCreateTime(new Date());
        baoxianService.insert(baoxian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

