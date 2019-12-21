package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouQuehuo;
import com.simple.mapper.ShouhouQuehuoMapper;
import com.simple.service.ShouhouQuehuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouQuehuoServiceImpl implements ShouhouQuehuoService {
	
	@Autowired
    ShouhouQuehuoMapper shouhouQuehuoMapper;


    @Override
    public PageInfo<ShouhouQuehuo> listAsPage(ShouhouQuehuo record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouQuehuoMapper.findList(record));
    }

    @Override
    public ShouhouQuehuo getById(String id) {
        return shouhouQuehuoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouQuehuo record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouQuehuoMapper.insertSelective(record);
        } else {
            shouhouQuehuoMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouQuehuoMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
