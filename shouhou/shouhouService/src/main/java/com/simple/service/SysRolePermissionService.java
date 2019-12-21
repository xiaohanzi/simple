package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRolePermission;

public interface SysRolePermissionService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<SysRolePermission> listAsPage(SysRolePermission record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    SysRolePermission getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(SysRolePermission record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
	
    /**
     * 批量保存
     * @param roleId
     * @param perId
     */
    void savePermissions(String roleId,String[] perId);

	
	
	
	
}
