package com.simple.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouList;
import com.simple.service.ShouhouListService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("shouhouList")
public class ShouhouListController extends BaseController
{
	@Autowired
    private ShouhouListService shouhouListService;

    private Logger logger = Logger.getLogger(ShouhouListController.class);

    @HoldBegin
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ShouhouList shouhouList,Integer pageNum, Integer pageSize) {
    	if (null == shouhouList) shouhouList = new ShouhouList();
    	if(shouhouList.getDealStatus() <=0 ) {
    		shouhouList.setDealStatus(null);
    	}
    	if(shouhouList.getMiss() <=0 ) {
    		shouhouList.setMiss(null);
    	}
    	shouhouList.setTransNo(StringUtils.trimToNull(shouhouList.getTransNo()));
    	shouhouList.setOrderNo(StringUtils.trimToNull(shouhouList.getOrderNo()));
    	shouhouList.setEventType(StringUtils.trimToNull(shouhouList.getEventType()));
    	shouhouList.setShop(StringUtils.trimToNull(shouhouList.getShop()));
    	shouhouList.setSortColumns(ShouhouList.Field.UpdateTime_DESC);
        final PageInfo<ShouhouList> page = shouhouListService.listAsPage(shouhouList, pageNum, pageSize);
        return new ResultData(page);
    }

   
    @PostMapping("add")
    public ResultData add(ShouhouList shouhouList) {
    	if (null ==StringUtils.trimToNull(shouhouList.getOrderNo())) {
    		return new ResultData(Result.ERROR, "订单号不能为空", null);
    	}
        Assert.notNull(shouhouList.getOrderNo(), "订单号不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
    	shouhouList.setCreateTime(new Date());
    	shouhouList.setCreateBy("123");
    	shouhouList.setUpdateTime(new Date());
    	shouhouList.setUpdateBy("123");
        shouhouListService.saveOrUpdate(shouhouList);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(ShouhouList shouhouList) {
    	Assert.notNull(shouhouList.getOrderNo(), "订单号不能为空");
    	shouhouList.setUpdateTime(new Date());
    	shouhouList.setUpdateBy("123");
        shouhouListService.saveOrUpdate(shouhouList);
        return new ResultData();
    }
    @HoldEnd
    
    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        shouhouListService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",shouhouListService.getById(id));
    }
	
	
	
}
