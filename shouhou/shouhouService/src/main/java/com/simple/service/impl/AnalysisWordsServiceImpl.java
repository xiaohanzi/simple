package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWords;
import com.simple.mapper.AnalysisWordsMapper;
import com.simple.service.AnalysisWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisWordsServiceImpl implements AnalysisWordsService {
	
	@Autowired
    AnalysisWordsMapper analysisWordsMapper;


    @Override
    public PageInfo<AnalysisWords> listAsPage(AnalysisWords record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> analysisWordsMapper.findList(record));
    }

    @Override
    public AnalysisWords getById(String id) {
        return analysisWordsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AnalysisWords record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            analysisWordsMapper.insertSelective(record);
        } else {
            analysisWordsMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        analysisWordsMapper.deleteByPrimaryKey(id);
    }

   //@HoldBegin
	@Override
	public AnalysisWords findOne(String productId, String wordsName) {
		Map param = new HashMap();
		param.put("productId", productId);
		param.put("wordsName", wordsName);
		return analysisWordsMapper.findOne(param);
	}
	 //@HoldEnd
}
