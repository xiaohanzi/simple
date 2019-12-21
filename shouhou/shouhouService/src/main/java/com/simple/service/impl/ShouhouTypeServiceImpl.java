package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouType;
import com.simple.mapper.ShouhouTypeMapper;
import com.simple.service.ShouhouTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouTypeServiceImpl implements ShouhouTypeService {
	
	@Autowired
    ShouhouTypeMapper shouhouTypeMapper;


    @Override
    public PageInfo<ShouhouType> listAsPage(ShouhouType record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouTypeMapper.findList(record));
    }

    @Override
    public ShouhouType getById(String id) {
        return shouhouTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouType record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouTypeMapper.insertSelective(record);
        } else {
            shouhouTypeMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouTypeMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
