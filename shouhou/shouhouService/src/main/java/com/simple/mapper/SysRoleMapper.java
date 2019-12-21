package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.SysRole;

public interface SysRoleMapper extends CommonMapper<SysRole, String> {

	List<SysRole> findList(SysRole sysRole);
	
	
	List<SysRole> findRoleByUserId(String userId);
	int countByName(Map<String,Object> map);

	
	
	
}
