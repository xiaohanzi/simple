package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouAlibaba;
import com.simple.mapper.ShouhouAlibabaMapper;
import com.simple.service.ShouhouAlibabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShouhouAlibabaServiceImpl implements ShouhouAlibabaService {
	
	@Autowired
    ShouhouAlibabaMapper shouhouAlibabaMapper;


    @Override
    public PageInfo<ShouhouAlibaba> listAsPage(ShouhouAlibaba record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> shouhouAlibabaMapper.findList(record));
    }

    @Override
    public ShouhouAlibaba getById(String id) {
        return shouhouAlibabaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ShouhouAlibaba record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            shouhouAlibabaMapper.insertSelective(record);
        } else {
            shouhouAlibabaMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        shouhouAlibabaMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
