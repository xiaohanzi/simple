package com.simple.service;

import java.util.*;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.UserInfo;

public interface UserInfoService {

	/**
     * 根据实体查询分页列表
     *
     * @param record
     * @param offset
     * @param limit
     * @return
     */
	PageInfo<UserInfo> listAsPage(UserInfo record, Integer pageIndex, Integer pageSize);
	
	/**
     * 根据Id获得实体
     *
     * @param id
     * @return
     */
    UserInfo getById(String id);
    
        /**
     * 保存或更新实体
     *
     * @param record
     */
    void saveOrUpdate(UserInfo record);

    /**
     * 根据Id删除实体
     *
     * @param id
     */
    void deleteById(String id);
    
	
	

	
    /**
     * 查询用户名总数，用于校验用户名是否重复
     * @param username
     */
    long cntByUserName(String username);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    UserInfo getByName(String username);

    /**
     * 删除用户相关数据(用户记录，角色关联)
     * @param id
     */
    void deleteUser(String id);

    /**
     * 检查用户按钮是否有权限
     * @param userId
     * @param permission
     * @return 是否有权限(true: 有| false: 没有)
     */
    boolean hasButtonPermission(String userId, String permission);
	
	
	
}
