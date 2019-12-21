package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWordData;
import com.simple.mapper.AnalysisWordDataMapper;
import com.simple.service.AnalysisWordDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisWordDataServiceImpl implements AnalysisWordDataService {
	
	@Autowired
    AnalysisWordDataMapper analysisWordDataMapper;


    @Override
    public PageInfo<AnalysisWordData> listAsPage(AnalysisWordData record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> analysisWordDataMapper.findList(record));
    }

    @Override
    public AnalysisWordData getById(String id) {
        return analysisWordDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AnalysisWordData record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            analysisWordDataMapper.insertSelective(record);
        } else {
            analysisWordDataMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        analysisWordDataMapper.deleteByPrimaryKey(id);
    }
    
    //@HoldBegin
	@Override
	public PageInfo<AnalysisWordData> caluculateListAsPage(AnalysisWordData record, Integer pageIndex, Integer pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		List<AnalysisWordData> userList = analysisWordDataMapper.caluculateList(record);
		PageInfo<AnalysisWordData> pageInfo = new PageInfo<AnalysisWordData>(userList);
		 return pageInfo;
	}
	//@HoldEnd


    
}
