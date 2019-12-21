package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRolePermission;

public interface SysRolePermissionMapper extends CommonMapper<SysRolePermission, String> {

	List<SysRolePermission> findList(SysRolePermission sysRolePermission);
	
	

	void deleteByRoleId(Map<String,Object> map);
	
	
	
}
