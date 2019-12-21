package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisProduct;
import com.simple.mapper.AnalysisProductMapper;
import com.simple.service.AnalysisProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisProductServiceImpl implements AnalysisProductService {
	
	@Autowired
    AnalysisProductMapper analysisProductMapper;


    @Override
    public PageInfo<AnalysisProduct> listAsPage(AnalysisProduct record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> analysisProductMapper.findList(record));
    }

    @Override
    public AnalysisProduct getById(String id) {
        return analysisProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AnalysisProduct record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            analysisProductMapper.insertSelective(record);
        } else {
            analysisProductMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        analysisProductMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
