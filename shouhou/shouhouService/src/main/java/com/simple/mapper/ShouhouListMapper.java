package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ShouhouList;

public interface ShouhouListMapper extends CommonMapper<ShouhouList, String> {

	List<ShouhouList> findList(ShouhouList shouhouList);
	
	

	
	
	
}
