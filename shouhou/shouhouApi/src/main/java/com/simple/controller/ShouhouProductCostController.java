package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
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
	
	
	
}
