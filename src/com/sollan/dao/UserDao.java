package com.sollan.dao;

import com.sollan.bean.User;

public interface UserDao {
	
	//根据id查询用户
	public User getUserById(Integer id) ;
}
