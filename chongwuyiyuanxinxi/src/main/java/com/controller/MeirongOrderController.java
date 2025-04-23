
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
 * 美容服务预约信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongOrder")
public class MeirongOrderController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongOrderController.class);

    @Autowired
    private MeirongOrderService meirongOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private MeirongService meirongService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;



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
        else if("宠物医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = meirongOrderService.queryPage(params);

        //字典表数据转换
        List<MeirongOrderView> list =(List<MeirongOrderView>)page.getList();
        for(MeirongOrderView c:list){
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
        MeirongOrderEntity meirongOrder = meirongOrderService.selectById(id);
        if(meirongOrder !=null){
            //entity转view
            MeirongOrderView view = new MeirongOrderView();
            BeanUtils.copyProperties( meirongOrder , view );//把实体数据重构到view中

                //级联表
                MeirongEntity meirong = meirongService.selectById(meirongOrder.getMeirongId());
                if(meirong != null){
                    BeanUtils.copyProperties( meirong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeirongId(meirong.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(meirongOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
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
    public R save(@RequestBody MeirongOrderEntity meirongOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongOrder:{}",this.getClass().getName(),meirongOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            meirongOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        meirongOrder.setCreateTime(new Date());
        meirongOrderService.insert(meirongOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongOrderEntity meirongOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,meirongOrder:{}",this.getClass().getName(),meirongOrder.toString());
        //根据字段查询是否有相同数据
            meirongOrderService.updateById(meirongOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        meirongOrderService.deleteBatchIds(Arrays.asList(ids));
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
        try {
            List<MeirongOrderEntity> meirongOrderList = new ArrayList<>();//上传的东西
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
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MeirongOrderEntity meirongOrderEntity = new MeirongOrderEntity();
//                            meirongOrderEntity.setMeirongId(Integer.valueOf(data.get(0)));   //美容服务 要改的
//                            meirongOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            meirongOrderEntity.setMeirongOrderUuidNumber(data.get(0));                    //就诊识别码 要改的
//                            meirongOrderEntity.setMeirongOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            meirongOrderEntity.setGuahaoTypes(Integer.valueOf(data.get(0)));   //时间类型 要改的
//                            meirongOrderEntity.setMeirongOrderStatusTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            meirongOrderEntity.setCreateTime(date);//时间
                            meirongOrderList.add(meirongOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //就诊识别码
                                if(seachFields.containsKey("meirongOrderUuidNumber")){
                                    List<String> meirongOrderUuidNumber = seachFields.get("meirongOrderUuidNumber");
                                    meirongOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> meirongOrderUuidNumber = new ArrayList<>();
                                    meirongOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("meirongOrderUuidNumber",meirongOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //就诊识别码
                        List<MeirongOrderEntity> meirongOrderEntities_meirongOrderUuidNumber = meirongOrderService.selectList(new EntityWrapper<MeirongOrderEntity>().in("meirong_order_uuid_number", seachFields.get("meirongOrderUuidNumber")));
                        if(meirongOrderEntities_meirongOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MeirongOrderEntity s:meirongOrderEntities_meirongOrderUuidNumber){
                                repeatFields.add(s.getMeirongOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [就诊识别码] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        meirongOrderService.insertBatch(meirongOrderList);
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

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = meirongOrderService.queryPage(params);

        //字典表数据转换
        List<MeirongOrderView> list =(List<MeirongOrderView>)page.getList();
        for(MeirongOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongOrderEntity meirongOrder = meirongOrderService.selectById(id);
            if(meirongOrder !=null){


                //entity转view
                MeirongOrderView view = new MeirongOrderView();
                BeanUtils.copyProperties( meirongOrder , view );//把实体数据重构到view中

                //级联表
                    MeirongEntity meirong = meirongService.selectById(meirongOrder.getMeirongId());
                if(meirong != null){
                    BeanUtils.copyProperties( meirong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeirongId(meirong.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(meirongOrder.getYonghuId());
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
    public R add(@RequestBody MeirongOrderEntity meirongOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongOrder:{}",this.getClass().getName(),meirongOrder.toString());
            MeirongEntity meirongEntity = meirongService.selectById(meirongOrder.getMeirongId());
            if(meirongEntity == null){
                return R.error(511,"查不到该美容服务");
            }
            // Double meirongNewMoney = meirongEntity.getMeirongNewMoney();

            if(false){
            }
            else if(meirongEntity.getMeirongNewMoney() == null){
                return R.error(511,"美容服务价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - meirongEntity.getMeirongNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            meirongOrder.setYonghuId(userId); //设置订单支付人id
            meirongOrder.setMeirongOrderUuidNumber(String.valueOf(new Date().getTime()));
            meirongOrder.setCreateTime(new Date());
                meirongOrderService.insert(meirongOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String meirongOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Date meirongOrderTime = new Date(String.valueOf(params.get("meirongOrderTime")));//预约时间
        Integer guahaoTypes = Integer.valueOf(String.valueOf(params.get("guahaoTypes")));//时间类型
        Integer meirongOrderStatusTypes = Integer.valueOf(String.valueOf(params.get("meirongOrderStatusTypes")));//预约状态

        String data = String.valueOf(params.get("meirongs"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> meirongs = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<MeirongOrderEntity> meirongOrderList = new ArrayList<>();
        //商品表
        List<MeirongEntity> meirongList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : meirongs) {
           //取值
            Integer meirongId = Integer.valueOf(String.valueOf(map.get("meirongId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            MeirongEntity meirongEntity = meirongService.selectById(meirongId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));


            //订单信息表增加数据
            MeirongOrderEntity meirongOrderEntity = new MeirongOrderEntity<>();

            //赋值订单信息
            meirongOrderEntity.setMeirongId(meirongId);//美容服务
            meirongOrderEntity.setYonghuId(userId);//用户
            meirongOrderEntity.setMeirongOrderUuidNumber(meirongOrderUuidNumber);//就诊识别码
            meirongOrderEntity.setMeirongOrderTime(meirongOrderTime);//预约时间 ？？？？？？
            meirongOrderEntity.setGuahaoTypes(guahaoTypes);//时间类型 ？？？？？？
            meirongOrderEntity.setMeirongOrderStatusTypes(meirongOrderStatusTypes);//预约状态 ？？？？？？
            meirongOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(1 == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(meirongEntity.getMeirongNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额



                }
            }
            meirongOrderList.add(meirongOrderEntity);
            meirongList.add(meirongEntity);

        }
        meirongOrderService.insertBatch(meirongOrderList);
        meirongService.updateBatchById(meirongList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }



}
