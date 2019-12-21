package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRolePermission;
import com.simple.mapper.SysRolePermissionMapper;
import com.simple.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
	
	@Autowired
    SysRolePermissionMapper sysRolePermissionMapper;


    @Override
    public PageInfo<SysRolePermission> listAsPage(SysRolePermission record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> sysRolePermissionMapper.findList(record));
    }

    @Override
    public SysRolePermission getById(String id) {
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(SysRolePermission record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysRolePermissionMapper.insertSelective(record);
        } else {
            sysRolePermissionMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        sysRolePermissionMapper.deleteByPrimaryKey(id);
    }
    
    
    
	@Override
	public void savePermissions(String roleId, String[] perId) {
		Map<String,Object> map = new HashMap<>();
		map.put("roleId", roleId);
		sysRolePermissionMapper.deleteByRoleId(map);
		 for(String pId:perId){
			   SysRolePermission permission =new SysRolePermission();
			   permission.setId(roleId);
			   permission.setPermissionId(pId);
			   sysRolePermissionMapper.insert(permission);
		   }
		
	}
    
    
    
    
    
}
