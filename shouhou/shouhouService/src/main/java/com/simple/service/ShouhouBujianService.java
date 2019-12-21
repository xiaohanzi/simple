package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouBujian;

public interface ShouhouBujianService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<ShouhouBujian> listAsPage(ShouhouBujian record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    ShouhouBujian getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(ShouhouBujian record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
	

	
	
	
	
}
