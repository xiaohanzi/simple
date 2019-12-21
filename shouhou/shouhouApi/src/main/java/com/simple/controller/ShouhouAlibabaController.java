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
import com.simple.domain.po.ShouhouAlibaba;
import com.simple.service.ShouhouAlibabaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("shouhouAlibaba")
public class ShouhouAlibabaController extends BaseController
{
	@Autowired
    private ShouhouAlibabaService shouhouAlibabaService;

    private Logger logger = Logger.getLogger(ShouhouAlibabaController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ShouhouAlibaba shouhouAlibaba,Integer pageNum, Integer pageSize) {
    	if (null == shouhouAlibaba) shouhouAlibaba = new ShouhouAlibaba();
        final PageInfo<ShouhouAlibaba> page = shouhouAlibabaService.listAsPage(shouhouAlibaba, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody ShouhouAlibaba shouhouAlibaba) {
        //Assert.notNull(shouhouAlibaba.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        shouhouAlibabaService.saveOrUpdate(shouhouAlibaba);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody ShouhouAlibaba shouhouAlibaba) {
        shouhouAlibabaService.saveOrUpdate(shouhouAlibaba);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        shouhouAlibabaService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",shouhouAlibabaService.getById(id));
    }
	
	
	
}
