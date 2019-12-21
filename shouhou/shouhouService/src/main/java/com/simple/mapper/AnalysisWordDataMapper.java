package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import com.simple.domain.po.AnalysisWordData;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

public interface AnalysisWordDataMapper extends CommonMapper<AnalysisWordData, String> {

	List<AnalysisWordData> findList(AnalysisWordData analysisWordData);
	
	

	
	
				//@HoldBegin
	List<AnalysisWordData> caluculateList(AnalysisWordData analysisWordData);
	//@HoldEnd


}
