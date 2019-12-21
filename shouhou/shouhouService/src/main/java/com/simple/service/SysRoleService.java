package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRole;

public interface SysRoleService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<SysRole> listAsPage(SysRole record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    SysRole getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(SysRole record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
    /**
     * 根据userId查找Role集合
     * @param userId
     * @return
     */
    List<SysRole> findRoleByUserId(String userId);

    /**
     * 根据名称查询数量
     * @param name 名称
     * @return
     */
    int countByName(String name,String id);
	

	
	
	
	
}
