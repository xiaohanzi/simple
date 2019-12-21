package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouBujian;
import com.simple.mapper.ShouhouBujianMapper;
import com.simple.service.ShouhouBujianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouBujianServiceImpl implements ShouhouBujianService {
	
	@Autowired
    ShouhouBujianMapper shouhouBujianMapper;


    @Override
    public PageInfo<ShouhouBujian> listAsPage(ShouhouBujian record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouBujianMapper.findList(record));
    }

    @Override
    public ShouhouBujian getById(String id) {
        return shouhouBujianMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouBujian record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouBujianMapper.insertSelective(record);
        } else {
            shouhouBujianMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouBujianMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
