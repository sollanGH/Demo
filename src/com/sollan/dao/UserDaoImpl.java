package com.sollan.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sollan.bean.User;

public class UserDaoImpl implements UserDao{

	//sqlSession工厂
	private SqlSessionFactory ssf;
	
	//通过构造器获取一个工厂
	public UserDaoImpl(SqlSessionFactory ssf) {
		this.ssf = ssf;
	}


	/**
	 *	查询的主要方法 
	 */
	@Override
	public User getUserById(Integer id) {

		// 生产一个sqlSession 
		SqlSession session = ssf.openSession();

		// 返回查询对象
		return session.selectOne("UserMapper.selectUserById",id);
	}
	
}
