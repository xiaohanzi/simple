package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.UserInfo;

public interface UserInfoMapper extends CommonMapper<UserInfo, String> {

	List<UserInfo> findList(UserInfo userInfo);
	
	

	
	Integer hasButtonPermission(@Param("userId") String userId, @Param("permission") String permission);
	
	
}
