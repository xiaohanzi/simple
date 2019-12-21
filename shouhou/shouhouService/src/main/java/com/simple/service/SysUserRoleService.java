package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysUserRole;

public interface SysUserRoleService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<SysUserRole> listAsPage(SysUserRole record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    SysUserRole getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(SysUserRole record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
	

    /**
     * 批量增加用户对应角色
     * @param u2rs
     */
    void batchInsert(List<SysUserRole> u2rs);
	
	
	
	
}
