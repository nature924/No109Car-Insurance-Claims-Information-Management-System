
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
 * 理赔申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shiguYuyue")
public class ShiguYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ShiguYuyueController.class);

    private static final String TABLE_NAME = "shiguYuyue";

    @Autowired
    private ShiguYuyueService shiguYuyueService;


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
    private XianchangService xianchangService;//现场勘查
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
        CommonUtil.checkMap(params);
        PageUtils page = shiguYuyueService.queryPage(params);

        //字典表数据转换
        List<ShiguYuyueView> list =(List<ShiguYuyueView>)page.getList();
        for(ShiguYuyueView c:list){
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
        ShiguYuyueEntity shiguYuyue = shiguYuyueService.selectById(id);
        if(shiguYuyue !=null){
            //entity转view
            ShiguYuyueView view = new ShiguYuyueView();
            BeanUtils.copyProperties( shiguYuyue , view );//把实体数据重构到view中
            //级联表 事故调查
            //级联表
            ShiguEntity shigu = shiguService.selectById(shiguYuyue.getShiguId());
            if(shigu != null){
            BeanUtils.copyProperties( shigu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShiguId(shigu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shiguYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 事故调查员
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(shiguYuyue.getYuangongId());
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
    public R save(@RequestBody ShiguYuyueEntity shiguYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiguYuyue:{}",this.getClass().getName(),shiguYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shiguYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("事故调查员".equals(role))
            shiguYuyue.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShiguYuyueEntity> queryWrapper = new EntityWrapper<ShiguYuyueEntity>()
            .eq("shigu_id", shiguYuyue.getShiguId())
            .eq("yonghu_id", shiguYuyue.getYonghuId())
            .eq("yuangong_id", shiguYuyue.getYuangongId())
            .in("shigu_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiguYuyueEntity shiguYuyueEntity = shiguYuyueService.selectOne(queryWrapper);
        if(shiguYuyueEntity==null){
            shiguYuyue.setInsertTime(new Date());
            shiguYuyue.setShiguYuyueYesnoTypes(1);
            shiguYuyue.setCreateTime(new Date());
            shiguYuyueService.insert(shiguYuyue);
            return R.ok();
        }else {
            if(shiguYuyueEntity.getShiguYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shiguYuyueEntity.getShiguYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiguYuyueEntity shiguYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shiguYuyue:{}",this.getClass().getName(),shiguYuyue.toString());
        ShiguYuyueEntity oldShiguYuyueEntity = shiguYuyueService.selectById(shiguYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shiguYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("事故调查员".equals(role))
//            shiguYuyue.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shiguYuyueService.updateById(shiguYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShiguYuyueEntity shiguYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shiguYuyueEntity:{}",this.getClass().getName(),shiguYuyueEntity.toString());

        ShiguYuyueEntity oldShiguYuyue = shiguYuyueService.selectById(shiguYuyueEntity.getId());//查询原先数据
        YonghuEntity yonghuEntity = yonghuService.selectById(oldShiguYuyue.getYonghuId());
        if(shiguYuyueEntity.getShiguYuyueYesnoTypes() == 2){//通过
//            shiguYuyueEntity.setShiguYuyueTypes();
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney()+500);
            yonghuService.updateById(yonghuEntity);
        }else if(shiguYuyueEntity.getShiguYuyueYesnoTypes() == 3){//拒绝
//            shiguYuyueEntity.setShiguYuyueTypes();
        }
        shiguYuyueEntity.setShiguYuyueShenheTime(new Date());//审核时间
        shiguYuyueService.updateById(shiguYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShiguYuyueEntity> oldShiguYuyueList =shiguYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shiguYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShiguYuyueEntity> shiguYuyueList = new ArrayList<>();//上传的东西
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
                            ShiguYuyueEntity shiguYuyueEntity = new ShiguYuyueEntity();
//                            shiguYuyueEntity.setShiguYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            shiguYuyueEntity.setShiguId(Integer.valueOf(data.get(0)));   //事故 要改的
//                            shiguYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shiguYuyueEntity.setYuangongId(Integer.valueOf(data.get(0)));   //事故调查员 要改的
//                            shiguYuyueEntity.setShiguYuyueText(data.get(0));                    //理由 要改的
//                            shiguYuyueEntity.setInsertTime(date);//时间
//                            shiguYuyueEntity.setShiguYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            shiguYuyueEntity.setShiguYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            shiguYuyueEntity.setShiguYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shiguYuyueEntity.setCreateTime(date);//时间
                            shiguYuyueList.add(shiguYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("shiguYuyueUuidNumber")){
                                    List<String> shiguYuyueUuidNumber = seachFields.get("shiguYuyueUuidNumber");
                                    shiguYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shiguYuyueUuidNumber = new ArrayList<>();
                                    shiguYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shiguYuyueUuidNumber",shiguYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<ShiguYuyueEntity> shiguYuyueEntities_shiguYuyueUuidNumber = shiguYuyueService.selectList(new EntityWrapper<ShiguYuyueEntity>().in("shigu_yuyue_uuid_number", seachFields.get("shiguYuyueUuidNumber")));
                        if(shiguYuyueEntities_shiguYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShiguYuyueEntity s:shiguYuyueEntities_shiguYuyueUuidNumber){
                                repeatFields.add(s.getShiguYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shiguYuyueService.insertBatch(shiguYuyueList);
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
        PageUtils page = shiguYuyueService.queryPage(params);

        //字典表数据转换
        List<ShiguYuyueView> list =(List<ShiguYuyueView>)page.getList();
        for(ShiguYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShiguYuyueEntity shiguYuyue = shiguYuyueService.selectById(id);
            if(shiguYuyue !=null){


                //entity转view
                ShiguYuyueView view = new ShiguYuyueView();
                BeanUtils.copyProperties( shiguYuyue , view );//把实体数据重构到view中

                //级联表
                    ShiguEntity shigu = shiguService.selectById(shiguYuyue.getShiguId());
                if(shigu != null){
                    BeanUtils.copyProperties( shigu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShiguId(shigu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shiguYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(shiguYuyue.getYuangongId());
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
    public R add(@RequestBody ShiguYuyueEntity shiguYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shiguYuyue:{}",this.getClass().getName(),shiguYuyue.toString());
        Wrapper<ShiguYuyueEntity> queryWrapper = new EntityWrapper<ShiguYuyueEntity>()
            .eq("shigu_yuyue_uuid_number", shiguYuyue.getShiguYuyueUuidNumber())
            .eq("shigu_id", shiguYuyue.getShiguId())
            .eq("yonghu_id", shiguYuyue.getYonghuId())
            .eq("yuangong_id", shiguYuyue.getYuangongId())
            .eq("shigu_yuyue_text", shiguYuyue.getShiguYuyueText())
            .in("shigu_yuyue_yesno_types", new Integer[]{1,2})
            .eq("shigu_yuyue_yesno_text", shiguYuyue.getShiguYuyueYesnoText())
//            .notIn("shigu_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiguYuyueEntity shiguYuyueEntity = shiguYuyueService.selectOne(queryWrapper);
        if(shiguYuyueEntity==null){
            shiguYuyue.setInsertTime(new Date());
            shiguYuyue.setShiguYuyueYesnoTypes(1);
            shiguYuyue.setCreateTime(new Date());
        shiguYuyueService.insert(shiguYuyue);

            return R.ok();
        }else {
            if(shiguYuyueEntity.getShiguYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shiguYuyueEntity.getShiguYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

