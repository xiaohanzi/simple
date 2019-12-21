package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysPermission;

public interface SysPermissionService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<SysPermission> listAsPage(SysPermission record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    SysPermission getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(SysPermission record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 根据roleId查询菜单和按钮权限
     * @param roleId
     * @return
     */
    List<SysPermission> findPermissionByRoleId(String roleId);

    /**
     * 根据ruleId权限组查找相应权限
     * @param roleIds
     * @return
     */
    List<SysPermission> findPermissionByRoleIds(List<String> roleIds);
	
	

	
	
	
	
}
