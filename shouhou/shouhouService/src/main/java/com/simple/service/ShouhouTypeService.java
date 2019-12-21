package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouType;

public interface ShouhouTypeService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<ShouhouType> listAsPage(ShouhouType record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    ShouhouType getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(ShouhouType record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
	

	
	
	
	
}
