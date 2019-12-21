package com.simple.controller;

//@HoldBegin
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
//@HoldEnd
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.simple.common.excel.ObjectExcutor;
import com.simple.common.excel.ReadExcel;
import com.simple.common.excel.ResponseInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWordData;
import com.simple.domain.po.AnalysisWords;
import com.simple.service.AnalysisWordDataService;
import com.simple.service.AnalysisWordsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("analysisWords")
public class AnalysisWordsController extends BaseController
{
	@Autowired
    private AnalysisWordsService analysisWordsService;
	@Autowired
	private AnalysisWordDataService analysisWordDataService;

    private Logger logger = Logger.getLogger(AnalysisWordsController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute AnalysisWords analysisWords,Integer pageNum, Integer pageSize) {
    	if (null == analysisWords) analysisWords = new AnalysisWords();
        final PageInfo<AnalysisWords> page = analysisWordsService.listAsPage(analysisWords, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody AnalysisWords analysisWords) {
        //Assert.notNull(analysisWords.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        analysisWordsService.saveOrUpdate(analysisWords);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody AnalysisWords analysisWords) {
        analysisWordsService.saveOrUpdate(analysisWords);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        analysisWordsService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",analysisWordsService.getById(id));
    }
	


	 @HoldBegin
     @PostMapping("/uploadwords")
	 @ApiImplicitParams({
		 @ApiImplicitParam(name="begindate",value="日期",dataType="String", paramType = "query",required=true),
	 @ApiImplicitParam(name="productId",value="产品编号",dataType="String", paramType = "query",required=true)})
     public String uploadwords(String begindate,String productId,@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
 		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
 		ResponseInfo ri = ReadExcel.readReturnWorkBook(file.getInputStream(),new ObjectExcutor(){
 				@Override
 				public Object getObject(Map objectMap,List<String> cellValues) {
 						String wordsname = StringUtils.trimToNull(cellValues.get(0));
 						String peoplecounts = StringUtils.trimToNull(cellValues.get(6));
 						String paycounts = StringUtils.trimToNull(cellValues.get(9));
 						String cr = StringUtils.trimToNull(cellValues.get(12));
 						
 						StringBuffer errormsg = new StringBuffer();
 						
 						if (StringUtils.isBlank(productId)) {
 							errormsg.append("产品编号为空");
 						}
 						
 						if (StringUtils.isBlank(wordsname)) {
 							errormsg.append("关键词不能为空");
 						}
 						
 						int peoplecount = 0;
 						try {
 							peoplecount = Integer.parseInt(peoplecounts);
 						}catch(Exception e) {
 							errormsg.append("访客数非法");
 						}
 						
 						int paycount = 0;
 						try {
 							paycount = Integer.parseInt(paycounts);
 						}catch(Exception e) {
 							errormsg.append("支付买家数非法");
 						}
 						
 						double crd = 0.00;
 						try {
 							cr = cr.replace("%", "");
 							crd = Double.parseDouble(cr);
 						}catch(Exception e) {
 							errormsg.append("支付转化率非法");
 						} 						
 						
 						
 						if (errormsg.length()>0) {
 							//此处抛出的错误提示信息会在excel中写出来
 							throw new RuntimeException(errormsg.toString());
 						}else {
 							
 	 						AnalysisWords  awq = analysisWordsService.findOne(productId,wordsname);
 	 						if (null == awq) {
 	 							awq = new AnalysisWords();
 	 							awq.setWordsName(wordsname);
 	 							awq.setProductId(productId);
 	 							awq.setCreateTime(new Date());
 	 							analysisWordsService.saveOrUpdate(awq);
 	 						}
 	 						
 	 						AnalysisWords aw = analysisWordsService.findOne(productId,wordsname);
 	 						if (null == aw) {
 	 							return null;
 	 						}
 	 						AnalysisWordData awd = new AnalysisWordData();
 	 						try {
 	 							awd.setCr(crd);
 	 							awd.setCreateTime(DateUtils.parseDate(begindate+" 01:00:00", "yyyy-MM-dd HH:mm:ss"));
 	 	 						awd.setPayCounts(paycount);
 	 	 						awd.setPeopleCounts(peoplecount);
 	 	 						awd.setWordsId(aw.getId());
 	 	 						awd.setProductId(aw.getProductId());
 	 	 						awd.setWordsName(aw.getWordsName());
 	 							//此处设置objectMap,在重写executeListAdd的时候，需要查询出list之前的对象，根据objectMap来查询
 	 							//objectMap.put(p.getCardNo(), awd);
 	 							return awd;
 	 						} catch (ParseException e) {
 	 							e.printStackTrace();
 	 							return null;
 	 						}
 	 						
 						}
 				}
 			},suffix);
 		boolean isSuccess = ri.getStatus().getState();
 		if (isSuccess) {
 			//如果校验成功，则将数据写入到数据库
 			List<AnalysisWordData> ps = (List<AnalysisWordData>) ri.getData();
 			//将对象进行存储
 			if ( null != ps) {
 				for (AnalysisWordData awd : ps) {
 					analysisWordDataService.saveOrUpdate(awd);
 				}
 			}
 			return "success";//
 		}else {
 			//如果失败，则将错误文件提供下载
 			return ReadExcel.getErrorLogs((Workbook) ri.getData(), suffix, response);
 		}
 			
 	}
	 
	@GetMapping("calculateList")
        @ApiImplicitParams({
          @ApiImplicitParam(name="begin",value="开始日期",dataType="String", paramType = "query",required=true),
          @ApiImplicitParam(name="end",value="结束日期",dataType="String", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData calculateList(@ModelAttribute AnalysisWordData analysisWords,String begin,String end,Integer pageNum, Integer pageSize) {
    	if (null == analysisWords) analysisWords = new AnalysisWordData();
    	if(!StringUtils.isBlank(begin)) {
    		try {
				analysisWords.setCreateTimeGte(DateUtils.parseDate(begin, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	if(!StringUtils.isBlank(end)) {
    		try {
				analysisWords.setCreateTimeLte(DateUtils.parseDate(end, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
        final PageInfo<AnalysisWordData> page = analysisWordDataService.caluculateListAsPage(analysisWords, pageNum, pageSize);
        return new ResultData(page);
    }
	 
     //@HoldEnd
}
