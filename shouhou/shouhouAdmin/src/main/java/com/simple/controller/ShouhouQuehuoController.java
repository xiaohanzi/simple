package com.simple.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouQuehuo;
import com.simple.service.ShouhouQuehuoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("shouhouQuehuo")
public class ShouhouQuehuoController extends BaseController
{
	@Autowired
    private ShouhouQuehuoService shouhouQuehuoService;

    private Logger logger = Logger.getLogger(ShouhouQuehuoController.class);

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        shouhouQuehuoService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",shouhouQuehuoService.getById(id));
    }
	
		    @HoldBegin
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ShouhouQuehuo shouhouQuehuo,Integer pageNum, Integer pageSize,int ck) {
    	if (null == shouhouQuehuo) shouhouQuehuo = new ShouhouQuehuo();
    	if (ck==0) {
    		shouhouQuehuo.setSortColumns(ShouhouQuehuo.Field.CreateTime_ASC);
    	}else {
    		shouhouQuehuo.setSortColumns(ShouhouQuehuo.Field.CreateTime_DESC);
    	}
    	
        final PageInfo<ShouhouQuehuo> page = shouhouQuehuoService.listAsPage(shouhouQuehuo, pageNum, pageSize);
        return new ResultData(page);
    }

    
    @PostMapping("add")
    public ResultData add( ShouhouQuehuo shouhouQuehuo) {
        //Assert.notNull(shouhouQuehuo.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
    	shouhouQuehuo.setCreateTime(new Date());
    	shouhouQuehuo.setUpdateTime(new Date());
        shouhouQuehuoService.saveOrUpdate(shouhouQuehuo);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update( ShouhouQuehuo shouhouQuehuo) {
    	shouhouQuehuo.setUpdateTime(new Date());
        shouhouQuehuoService.saveOrUpdate(shouhouQuehuo);
        return new ResultData();
    }   
    
    @GetMapping("/deliver")
    @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
   public ResultData deliver(String id) {
       ShouhouQuehuo quehuo = shouhouQuehuoService.getById(id);
       quehuo.setFinished(1);
       quehuo.setHandleStatus(2);
       quehuo.setUpdateTime(new Date());
       shouhouQuehuoService.saveOrUpdate(quehuo);
       return new ResultData(Result.SUCCESS, "更新成功", null);
   }
    
    
    
    //@HoldEnd


	
}
