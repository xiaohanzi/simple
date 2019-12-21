package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouList;
import com.simple.mapper.ShouhouListMapper;
import com.simple.service.ShouhouListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouListServiceImpl implements ShouhouListService {
	
	@Autowired
    ShouhouListMapper shouhouListMapper;


    @Override
    public PageInfo<ShouhouList> listAsPage(ShouhouList record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouListMapper.findList(record));
    }

    @Override
    public ShouhouList getById(String id) {
        return shouhouListMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouList record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouListMapper.insertSelective(record);
        } else {
            shouhouListMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouListMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
