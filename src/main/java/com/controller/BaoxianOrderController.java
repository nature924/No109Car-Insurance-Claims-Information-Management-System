
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
 * 保险订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoxianOrder")
public class BaoxianOrderController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxianOrderController.class);

    private static final String TABLE_NAME = "baoxianOrder";

    @Autowired
    private BaoxianOrderService baoxianOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxianService baoxianService;//保险
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
        CommonUtil.checkMap(params);
        PageUtils page = baoxianOrderService.queryPage(params);

        //字典表数据转换
        List<BaoxianOrderView> list =(List<BaoxianOrderView>)page.getList();
        for(BaoxianOrderView c:list){
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
        BaoxianOrderEntity baoxianOrder = baoxianOrderService.selectById(id);
        if(baoxianOrder !=null){
            //entity转view
            BaoxianOrderView view = new BaoxianOrderView();
            BeanUtils.copyProperties( baoxianOrder , view );//把实体数据重构到view中
            //级联表 保险
            //级联表
            BaoxianEntity baoxian = baoxianService.selectById(baoxianOrder.getBaoxianId());
            if(baoxian != null){
            BeanUtils.copyProperties( baoxian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setBaoxianId(baoxian.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(baoxianOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody BaoxianOrderEntity baoxianOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxianOrder:{}",this.getClass().getName(),baoxianOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            baoxianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        baoxianOrder.setCreateTime(new Date());
        baoxianOrder.setInsertTime(new Date());
        baoxianOrderService.insert(baoxianOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxianOrderEntity baoxianOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,baoxianOrder:{}",this.getClass().getName(),baoxianOrder.toString());
        BaoxianOrderEntity oldBaoxianOrderEntity = baoxianOrderService.selectById(baoxianOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            baoxianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            baoxianOrderService.updateById(baoxianOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BaoxianOrderEntity> oldBaoxianOrderList =baoxianOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        baoxianOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<BaoxianOrderEntity> baoxianOrderList = new ArrayList<>();//上传的东西
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
                            BaoxianOrderEntity baoxianOrderEntity = new BaoxianOrderEntity();
//                            baoxianOrderEntity.setBaoxianOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            baoxianOrderEntity.setBaoxianId(Integer.valueOf(data.get(0)));   //保险 要改的
//                            baoxianOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            baoxianOrderEntity.setBaoxianOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            baoxianOrderEntity.setBaoxianOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            baoxianOrderEntity.setInsertTime(date);//时间
//                            baoxianOrderEntity.setCreateTime(date);//时间
                            baoxianOrderList.add(baoxianOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("baoxianOrderUuidNumber")){
                                    List<String> baoxianOrderUuidNumber = seachFields.get("baoxianOrderUuidNumber");
                                    baoxianOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> baoxianOrderUuidNumber = new ArrayList<>();
                                    baoxianOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("baoxianOrderUuidNumber",baoxianOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<BaoxianOrderEntity> baoxianOrderEntities_baoxianOrderUuidNumber = baoxianOrderService.selectList(new EntityWrapper<BaoxianOrderEntity>().in("baoxian_order_uuid_number", seachFields.get("baoxianOrderUuidNumber")));
                        if(baoxianOrderEntities_baoxianOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BaoxianOrderEntity s:baoxianOrderEntities_baoxianOrderUuidNumber){
                                repeatFields.add(s.getBaoxianOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        baoxianOrderService.insertBatch(baoxianOrderList);
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
        PageUtils page = baoxianOrderService.queryPage(params);

        //字典表数据转换
        List<BaoxianOrderView> list =(List<BaoxianOrderView>)page.getList();
        for(BaoxianOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxianOrderEntity baoxianOrder = baoxianOrderService.selectById(id);
            if(baoxianOrder !=null){


                //entity转view
                BaoxianOrderView view = new BaoxianOrderView();
                BeanUtils.copyProperties( baoxianOrder , view );//把实体数据重构到view中

                //级联表
                    BaoxianEntity baoxian = baoxianService.selectById(baoxianOrder.getBaoxianId());
                if(baoxian != null){
                    BeanUtils.copyProperties( baoxian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBaoxianId(baoxian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(baoxianOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody BaoxianOrderEntity baoxianOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,baoxianOrder:{}",this.getClass().getName(),baoxianOrder.toString());
            BaoxianEntity baoxianEntity = baoxianService.selectById(baoxianOrder.getBaoxianId());
            if(baoxianEntity == null){
                return R.error(511,"查不到该保险");
            }
            // Double baoxianNewMoney = baoxianEntity.getBaoxianNewMoney();

            if(false){
            }
            else if(baoxianEntity.getBaoxianNewMoney() == null){
                return R.error(511,"现价/积分不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - baoxianEntity.getBaoxianNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            baoxianOrder.setBaoxianOrderTypes(101); //设置订单状态为已购买
            baoxianOrder.setBaoxianOrderTruePrice(baoxianEntity.getBaoxianNewMoney()*1); //设置实付价格
            baoxianOrder.setYonghuId(userId); //设置订单支付人id
            baoxianOrder.setBaoxianOrderUuidNumber(String.valueOf(new Date().getTime()));
            baoxianOrder.setInsertTime(new Date());
            baoxianOrder.setCreateTime(new Date());
                baoxianOrderService.insert(baoxianOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


}

