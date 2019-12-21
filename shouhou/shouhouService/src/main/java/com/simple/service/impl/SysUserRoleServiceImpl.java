package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysUserRole;
import com.simple.mapper.SysUserRoleMapper;
import com.simple.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
    SysUserRoleMapper sysUserRoleMapper;


    @Override
    public PageInfo<SysUserRole> listAsPage(SysUserRole record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> sysUserRoleMapper.findList(record));
    }

    @Override
    public SysUserRole getById(String id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(SysUserRole record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysUserRoleMapper.insertSelective(record);
        } else {
            sysUserRoleMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        sysUserRoleMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    @Override
    public void batchInsert(List<SysUserRole> u2rs) {
        sysUserRoleMapper.insertList(u2rs);
    }
    
    
    
    
}
