package com.simple.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.common.excel.DownLoadExcel;
import com.simple.common.excel.DownLoadExcutor;
import com.simple.common.excel.EntityCellValues;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.ShouhouBujian;
import com.simple.domain.po.ShouhouType;
import com.simple.service.ShouhouBujianService;
import com.simple.service.ShouhouTypeService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("shouhouBujian")
public class ShouhouBujianController extends BaseController
{
	@Autowired
    private ShouhouBujianService shouhouBujianService;

    private Logger logger = Logger.getLogger(ShouhouBujianController.class);

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        shouhouBujianService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",shouhouBujianService.getById(id));
    }
	
		@HoldBegin
	@Autowired
    private ShouhouTypeService shouhouTypeService;
	@HoldEnd

     @HoldBegin
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="妞ゅ灚鏆�",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="濮ｅ繘銆夐弶鈩冩殶",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ShouhouBujian shouhouBujian,Integer pageNum, Integer pageSize,Integer hastransno) {
    	if (null == shouhouBujian) shouhouBujian = new ShouhouBujian();
    	if (null == hastransno || hastransno <=0 ) {
    		shouhouBujian.setTransnohave(null);
    	}else {
    		shouhouBujian.setTransnohave(hastransno);
    	}
    	shouhouBujian.setTransNo(StringUtils.trimToNull(shouhouBujian.getTransNo()));
    	shouhouBujian.setOrderNo(StringUtils.trimToNull(shouhouBujian.getOrderNo()));
    	shouhouBujian.setShop(StringUtils.trimToNull(shouhouBujian.getShop()));
    	shouhouBujian.setCusNameLike(StringUtils.trimToNull(shouhouBujian.getCusNameLike()));
    	if (null == shouhouBujian.getTransInfo() || shouhouBujian.getTransInfo() <=0 ) {
    		shouhouBujian.setTransInfo(null);
    	}
    	shouhouBujian.setSortColumns(ShouhouBujian.Field.CreateTime_DESC);
        final PageInfo<ShouhouBujian> page = shouhouBujianService.listAsPage(shouhouBujian, pageNum, pageSize);
        return new ResultData(page);
    }
     
     @GetMapping("todayList")
     @ApiImplicitParams({
 	  @ApiImplicitParam(name="pageNum",value="妞ゅ灚鏆�",dataType="int", paramType = "query",required=true),
 	  @ApiImplicitParam(name="pageSize",value="濮ｅ繘銆夐弶鈩冩殶",dataType="int", paramType = "query",required=true)})
	 public ResultData todayList(@ModelAttribute ShouhouBujian shouhouBujian,Integer pageNum, Integer pageSize) {
	 	if (null == shouhouBujian) shouhouBujian = new ShouhouBujian();
	 	shouhouBujian.setCreateTimeGte(getBeginTime());
	 	shouhouBujian.setCreateTimeLte(getEndTime());
	 	shouhouBujian.setTransnohave(1);
	 	shouhouBujian.setSortColumns(ShouhouBujian.Field.CreateTime_DESC);
	     final PageInfo<ShouhouBujian> page = shouhouBujianService.listAsPage(shouhouBujian, pageNum, pageSize);
	     return new ResultData(page);
	 }
     
    @HoldEnd

	@HoldBegin
    @PostMapping("add")
    public ResultData add( ShouhouBujian shouhouBujian) {
        //Assert.notNull(shouhouBujian.getName(), "鐟欐帟澹婇崥宥勭瑝閼虫垝璐熺粚锟�");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "闁插秴顦查惃鍕潡閼规彃鎮�");
	    shouhouBujian.setOrderNo(StringUtils.trimToNull(shouhouBujian.getOrderNo()));
	    Assert.notNull(shouhouBujian.getOrderNo(), "鐠併垹宕熼崣铚傜瑝閼虫垝璐熺粚锟�");
    	shouhouBujian.setCreateTime(new Date());
    	shouhouBujian.setCreateBy("123");
    	shouhouBujian.setUpdateTime(new Date());
    	shouhouBujian.setUpdateBy("123");
        shouhouBujianService.saveOrUpdate(shouhouBujian);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update( ShouhouBujian shouhouBujian) {
	    shouhouBujian.setOrderNo(StringUtils.trimToNull(shouhouBujian.getOrderNo()));
	    Assert.notNull(shouhouBujian.getOrderNo(), "鐠併垹宕熼崣铚傜瑝閼虫垝璐熺粚锟�");
    	shouhouBujian.setUpdateTime(new Date());
    	shouhouBujian.setUpdateBy("123");
        shouhouBujianService.saveOrUpdate(shouhouBujian);
        return new ResultData();
    }
    
   @GetMapping("/exportTms")
   public void exportTms(HttpServletResponse response,String shopType) {
	   final String[] titles = new String[]{"订单编号","收件人","固话","手机","地址","发货信息","宝贝数量","总重量","备注","代收金额","保价金额","业务类型","实付金额"};
	   ShouhouBujian sbq = new ShouhouBujian();
	   sbq.setCreateTimeGte(getBeginTime());
	   sbq.setCreateTimeLte(getEndTime());
	   sbq.setTransnohave(1);
	   List<String> _shops = new ArrayList<>();
	   _shops.add(shopType);
	   sbq.setShops(_shops);
	   PageInfo result = shouhouBujianService.listAsPage(sbq, 1, 10000);
	   if (null != result && null != result.getList()) {
		    Map<String,String> resonMap = getTypeName("bujian");
			DownLoadExcel.download(result.getList(), Arrays.asList(titles), new DownLoadExcutor(){	
				@Override
				public List<EntityCellValues> getCellValues(Object o) {
					ShouhouBujian p = (ShouhouBujian) o;
					List<String> sl = new ArrayList<String>();
					sl.add("");
					sl.add(p.getCusName());
					sl.add("");
					sl.add(p.getCusPhone());
					sl.add(p.getCusAddr());
					if (null != resonMap) {
						sl.add("【补发-"+resonMap.get(p.getReason())+"】 "+p.getContent());
					}else {
						sl.add("【补发-"+p.getReason()+"】 "+p.getContent());
					}
					sl.add("1");
					sl.add("");
					if(p.getEms().intValue()==1) {
						sl.add("发邮政  "+p.getOrderNo());
					}else {
						sl.add(p.getOrderNo());
					}
					sl.add("");
					sl.add("");
					sl.add("");
					sl.add("");
					//濮濄倕顦╂潻鏂挎礀list鐎电钖勯敍灞惧姬鐡掕櫕鐓＄拠銏㈡畱娑擄拷閺夆剝鏆熼幑顕�娓剁憰浣瑰閸掑棙鍨氭径姘嚋鐎电钖�
					//>>>1閿涘奔绗夐幏鍡楀瀻鐎电钖� 
					List<EntityCellValues> list = new ArrayList<EntityCellValues>();
					EntityCellValues ecv = new EntityCellValues();
					ecv.setO(p);
					ecv.setCellValues(sl);
					list.add(ecv);
					return list;
				}
			}, response);
	   }
   }
   
   
   @GetMapping("/exportTb")
   public void exportTb(HttpServletResponse response) {
	   ShouhouBujian sbq = new ShouhouBujian();
	   sbq.setCreateTimeGte(getBeginTime());
	   sbq.setCreateTimeLte(getEndTime());
	   sbq.setTransnohave(1);
	   List<String> _shops = new ArrayList<>();
	   _shops.add("tb-ydy");
	   _shops.add("tb-bd");
	   sbq.setShops(_shops);
	   PageInfo result = shouhouBujianService.listAsPage(sbq, 1, 10000);
	   if (null != result && null != result.getList()) {
		   Map<String,String> resonMap = getTypeName("bujian");
		   Map<String,String> shopMap = getTypeName("shop");
		   StringBuffer sb = new StringBuffer();
		   for (int i = 0 ; i< result.getList().size(); i ++) {
			   ShouhouBujian sbj = (ShouhouBujian) result.getList().get(i);
			   if (null != shopMap) {
				   sb.append(shopMap.get(sbj.getShop()));
			   }else {
				   sb.append(sbj.getShop());
			   }
			   sb.append(" ").append(sbj.getOrderNo()).append(" ").append(sbj.getContent()).append(" ");
			   if (null != resonMap) {
				   sb.append(resonMap.get(sbj.getReason()));
			   }else {
				   sb.append(sbj.getReason());
			   }
			   sb.append("<br>");
		   }
		   pushtoresponse(response,sb.toString());
	   }
   }
    
   private void pushtoresponse(HttpServletResponse response,String content) {
	   try {
           // 娓呯┖response
           response.reset();
           response.setContentType("text/html;charset=UTF-8");//璁剧疆鍝嶅簲鍐呭鍜岀紪鐮佽鍒�
           OutputStream out = response.getOutputStream();
           out.write(content.getBytes());//鍙互姝ｅ父鐜板疄鍑轰腑鏂�
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }
   
   private Map<String, String> getTypeName(String type) {
	   ShouhouType st = new ShouhouType();
	   st.setType(type);
	   PageInfo result = shouhouTypeService.listAsPage(st, 1,100);
	   if (null != result && null != result.getList()) {
		   Map<String,String> retMap = new HashMap<String,String>();
		   for (int i = 0 ; i< result.getList().size(); i ++) {
			   ShouhouType sts = (ShouhouType) result.getList().get(i);
			   retMap.put(sts.getValue(), sts.getName());
		   }
		   return retMap;
	   }
	   return null;
   }
   
   
   private static Date getBeginTime() {
	   Calendar cal=Calendar.getInstance();
	   cal.add(Calendar.DATE,-1);
	   cal.set(Calendar.HOUR_OF_DAY, 15);
	   cal.set(Calendar.MINUTE,0);
	   cal.set(Calendar.SECOND,0);
	   return cal.getTime();
   }
   
   private static Date getEndTime() {
	   Calendar cal=Calendar.getInstance();
	   cal.set(Calendar.HOUR_OF_DAY, 15);
	   cal.set(Calendar.MINUTE,0);
	   cal.set(Calendar.SECOND,0);
	   return cal.getTime();
   }
    //@HoldEnd


	
}
