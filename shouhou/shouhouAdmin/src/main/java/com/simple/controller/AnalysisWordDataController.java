package com.simple.controller;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWordData;
import com.simple.service.AnalysisWordDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("analysisWordData")
public class AnalysisWordDataController extends BaseController
{
	@Autowired
    private AnalysisWordDataService analysisWordDataService;

    private Logger logger = Logger.getLogger(AnalysisWordDataController.class);

    @HoldBegin
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute AnalysisWordData analysisWordData,String begin,String end,Integer pageNum, Integer pageSize) {
    	if (null == analysisWordData) analysisWordData = new AnalysisWordData();
    	analysisWordData.setSortColumns(AnalysisWordData.Field.CreateTime_DESC);
    	if(!StringUtils.isBlank(begin)) {
    		try {
    			analysisWordData.setCreateTimeGte(DateUtils.parseDate(begin, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	if(!StringUtils.isBlank(end)) {
    		try {
    			analysisWordData.setCreateTimeLte(DateUtils.parseDate(end, "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
        final PageInfo<AnalysisWordData> page = analysisWordDataService.listAsPage(analysisWordData, pageNum, pageSize);
        return new ResultData(page);
    }
    @HoldEnd

    @PostMapping("add")
    public ResultData add(@RequestBody AnalysisWordData analysisWordData) {
        //Assert.notNull(analysisWordData.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        analysisWordDataService.saveOrUpdate(analysisWordData);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody AnalysisWordData analysisWordData) {
        analysisWordDataService.saveOrUpdate(analysisWordData);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        analysisWordDataService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",analysisWordDataService.getById(id));
    }
	
	
	
}
