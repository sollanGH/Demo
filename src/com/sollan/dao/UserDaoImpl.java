package com.sollan.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sollan.bean.User;

public class UserDaoImpl implements UserDao{

	//sqlSession����
	private SqlSessionFactory ssf;
	
	//ͨ����������ȡһ������
	public UserDaoImpl(SqlSessionFactory ssf) {
		this.ssf = ssf;
	}


	/**
	 *	��ѯ����Ҫ���� 
	 */
	@Override
	public User getUserById(Integer id) {

		// ����һ��sqlSession 
		SqlSession session = ssf.openSession();

		// ���ز�ѯ����
		return session.selectOne("UserMapper.selectUserById",id);
	}
	
}
