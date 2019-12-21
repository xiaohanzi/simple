package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AnalysisWords;

public interface AnalysisWordsMapper extends CommonMapper<AnalysisWords, String> {

	List<AnalysisWords> findList(AnalysisWords analysisWords);
	
	//@HoldBegin
	AnalysisWords findOne(Map param);
	//@HoldEnd
}
