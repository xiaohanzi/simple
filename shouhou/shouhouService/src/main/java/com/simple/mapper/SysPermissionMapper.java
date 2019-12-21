package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysPermission;

public interface SysPermissionMapper extends CommonMapper<SysPermission, String> {

	List<SysPermission> findList(SysPermission sysPermission);
	
	List<SysPermission> findPermissionByRoleId(String roleId);
	List<SysPermission> findPermissionByRoleIds(@Param("roleIds") List<String> roleIds);
	

	
	
	
}
