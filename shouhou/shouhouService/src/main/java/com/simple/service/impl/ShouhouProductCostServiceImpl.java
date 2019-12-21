package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouProductCost;
import com.simple.mapper.ShouhouProductCostMapper;
import com.simple.service.ShouhouProductCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouProductCostServiceImpl implements ShouhouProductCostService {
	
	@Autowired
    ShouhouProductCostMapper shouhouProductCostMapper;


    @Override
    public PageInfo<ShouhouProductCost> listAsPage(ShouhouProductCost record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouProductCostMapper.findList(record));
    }

    @Override
    public ShouhouProductCost getById(String id) {
        return shouhouProductCostMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouProductCost record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouProductCostMapper.insertSelective(record);
        } else {
            shouhouProductCostMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouProductCostMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
