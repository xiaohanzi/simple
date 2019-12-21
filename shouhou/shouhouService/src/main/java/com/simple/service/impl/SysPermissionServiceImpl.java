package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysPermission;
import com.simple.mapper.SysPermissionMapper;
import com.simple.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	
	@Autowired
    SysPermissionMapper sysPermissionMapper;


    @Override
    public PageInfo<SysPermission> listAsPage(SysPermission record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> sysPermissionMapper.findList(record));
    }

    @Override
    public SysPermission getById(String id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(SysPermission record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysPermissionMapper.insertSelective(record);
        } else {
            sysPermissionMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        sysPermissionMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public List<SysPermission> findPermissionByRoleId(String roleId) {
        return sysPermissionMapper.findPermissionByRoleId(roleId);
    }

    @Override
    public List<SysPermission> findPermissionByRoleIds(List<String> roleIds) {
        return sysPermissionMapper.findPermissionByRoleIds(roleIds);
    }
    
    
    
    
    
    
    
}
