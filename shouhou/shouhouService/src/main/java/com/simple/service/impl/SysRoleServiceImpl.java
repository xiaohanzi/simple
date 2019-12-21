package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRole;
import com.simple.mapper.SysRoleMapper;
import com.simple.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
    SysRoleMapper sysRoleMapper;


    @Override
    public PageInfo<SysRole> listAsPage(SysRole record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> sysRoleMapper.findList(record));
    }

    @Override
    public SysRole getById(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(SysRole record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysRoleMapper.insertSelective(record);
        } else {
            sysRoleMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        sysRoleMapper.deleteByPrimaryKey(id);
    }
    
    
    @Override
    public List<SysRole> findRoleByUserId(String userId) {
        return sysRoleMapper.findRoleByUserId(userId);
    }

	@Override
	public int countByName(String name,String id) {
		Map<String,Object> map = new HashMap<>(2);
		map.put("name", name);
		map.put("id", id);
		return sysRoleMapper.countByName(map);
	}
    
    
    
    
    
    
}
