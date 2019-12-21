package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWords;

public interface AnalysisWordsService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<AnalysisWords> listAsPage(AnalysisWords record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    AnalysisWords getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(AnalysisWords record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
    
    //@HoldBegin
    AnalysisWords findOne(String productId, String wordsName);
	
    
    //@HoldEnd
}
