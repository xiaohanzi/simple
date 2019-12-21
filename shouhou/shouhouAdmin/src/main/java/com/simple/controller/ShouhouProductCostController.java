package com.simple.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.simple.common.excel.DownLoadExcel;
import com.simple.common.excel.DownLoadExcutor;
import com.simple.common.excel.EntityCellValues;
import com.simple.common.excel.ExcelUtil;
import com.simple.common.excel.ObjectExcutor;
import com.simple.common.excel.ReadExcel;
import com.simple.common.excel.ResponseInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWordData;
import com.simple.domain.po.AnalysisWords;
import com.simple.domain.po.ShouhouBujian;
import com.simple.domain.po.ShouhouProductCost;
import com.simple.service.ShouhouProductCostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("shouhouProductCost")
public class ShouhouProductCostController extends BaseController
{
	@Autowired
    private ShouhouProductCostService shouhouProductCostService;

    private Logger logger = Logger.getLogger(ShouhouProductCostController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ShouhouProductCost shouhouProductCost,Integer pageNum, Integer pageSize) {
    	if (null == shouhouProductCost) shouhouProductCost = new ShouhouProductCost();
    	if (null == shouhouProductCost.getProductCode() || "".equals(shouhouProductCost.getProductCode())) {
    		shouhouProductCost.setProductCode(null);
    	}
        final PageInfo<ShouhouProductCost> page = shouhouProductCostService.listAsPage(shouhouProductCost, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody ShouhouProductCost shouhouProductCost) {
        //Assert.notNull(shouhouProductCost.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        shouhouProductCostService.saveOrUpdate(shouhouProductCost);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody ShouhouProductCost shouhouProductCost) {
        shouhouProductCostService.saveOrUpdate(shouhouProductCost);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        shouhouProductCostService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",shouhouProductCostService.getById(id));
    }
	
	 @HoldBegin
	 //更新价格表
     @PostMapping("/uploadcosts")
     public String uploadwords(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
 		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
 		ResponseInfo ri = ReadExcel.readReturnWorkBook(file.getInputStream(),new ObjectExcutor(){
 				@Override
 				public Object getObject(Map objectMap,List<String> cellValues) {
 						String wordsname = StringUtils.trimToNull(cellValues.get(0));
 						String productcode = StringUtils.trimToNull(cellValues.get(1));
 						String cost = StringUtils.trimToNull(cellValues.get(2));
 						String realcost = StringUtils.trimToNull(cellValues.get(3));
 						
 						StringBuffer errormsg = new StringBuffer();
 						
 						double crd = 0.00;
 						try {
 							crd = Double.parseDouble(cost);
 						}catch(Exception e) {
 							errormsg.append("公账成本非法");
 						} 						
 						
						double rcrd = 0.00;
 						try {
 							rcrd = Double.parseDouble(realcost);
 						}catch(Exception e) {
 							errormsg.append("实际成本非法");
 						} 						
 						
 						if (errormsg.length()>0) {
 							//此处抛出的错误提示信息会在excel中写出来
 							throw new RuntimeException(errormsg.toString());
 						}else {
 							ShouhouProductCost awqq = new ShouhouProductCost();
 							awqq.setProductCode(productcode);
 							PageInfo<ShouhouProductCost> spcp = shouhouProductCostService.listAsPage(awqq, 1, 1);
 	 						if (null == spcp || null == spcp.getList() || spcp.getList().size() == 0) {
 	 							ShouhouProductCost awq = new ShouhouProductCost();
 	 							awq.setProductCode(productcode);
 	 							awq.setCost(crd);
 	 							awq.setRealCost(rcrd);
 	 							awq.setCreateTime(new Date());
 	 							shouhouProductCostService.saveOrUpdate(awq);
 	 							return awq;
 	 						}else {
 	 							return null;
 	 						}
 	 						
 						}
 				}
 			},suffix);
 		boolean isSuccess = ri.getStatus().getState();
 		if (isSuccess) {
// 			//如果校验成功，则将数据写入到数据库
// 			List<ShouhouProductCost> ps = (List<ShouhouProductCost>) ri.getData();
// 			//将对象进行存储
// 			if ( null != ps) {
// 				for (ShouhouProductCost awd : ps) {
// 					shouhouProductCostService.saveOrUpdate(awd);
// 				}
// 			}
 			return "success";//
 		}else {
 			//如果失败，则将错误文件提供下载
 			return ReadExcel.getErrorLogs((Workbook) ri.getData(), suffix, response);
 		}
 			
 	}
	 
	 
	 @PostMapping("/uploadcheck")
     public String uploadcheck(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
 		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
 		StringBuffer errormsg = new StringBuffer();
 		Map retMap = new HashMap();
 		ResponseInfo ri = ReadExcel.readReturnWorkBook(file.getInputStream(),new ObjectExcutor(){
 				@Override
 				public Object getObject(Map objectMap,List<String> cellValues) {
 						String productcode = StringUtils.trimToNull(cellValues.get(0));
 						
						ShouhouProductCost awqq = new ShouhouProductCost();
						awqq.setProductCode(productcode);
						PageInfo<ShouhouProductCost> spcp = shouhouProductCostService.listAsPage(awqq, 1, 1);
 						if (null == spcp || null == spcp.getList() || spcp.getList().size() == 0) {
 							if (!retMap.containsKey(productcode)) {
 								errormsg.append(productcode).append("，");
 								retMap.put(productcode, productcode);
 							}
 							
 						}
 						return null;
 				}
 			},suffix);
 		boolean isSuccess = ri.getStatus().getState();
 		if (isSuccess) {
 			ExcelUtil.pushJsonToResponse(response, errormsg.toString());
 			return "success";//
 		}else {
 			//如果失败，则将错误文件提供下载
 			ExcelUtil.pushJsonToResponse(response, ri.getStatus().getMessage());
 			return null;
 		}
 			
 	}
	 
	 
	  @GetMapping("/exportprice")
	   public void exportprice(HttpServletResponse response,String shopType) {
		   final String[] titles = new String[]{"产品编码","公账成本","实际成本"};
		   ShouhouProductCost awqq = new ShouhouProductCost();
		   PageInfo result = shouhouProductCostService.listAsPage(awqq, 1, 10000);
		   if (null != result && null != result.getList()) {
				DownLoadExcel.download(result.getList(), Arrays.asList(titles), new DownLoadExcutor(){	
					@Override
					public List<EntityCellValues> getCellValues(Object o) {
						ShouhouProductCost p = (ShouhouProductCost) o;
						List<String> sl = new ArrayList<String>();
						sl.add(p.getProductCode());
						sl.add(String.valueOf(p.getCost()));
						sl.add(String.valueOf(p.getRealCost()));
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
	 
	 //@HoldEnd
	
}
