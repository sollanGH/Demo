package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sollan.bean.User;
import com.sollan.dao.UserDao;
import com.sollan.dao.UserDaoImpl;

public class UserDaoTest {
	// sqlSession����
	private static SqlSessionFactory ssf;

	/**
	 * ��ȡһ������
	 */
	static {
		String resource = "sqlMapConfig.xml";
		InputStream in;
		try {
			// 1.��ȡ�����ļ�
			in = Resources.getResourceAsStream(resource);
			// 2.��ҪsqlSessionFactoryBulider
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3.����sqlSessionfactory
			ssf = ssfb.build(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void DaoTest() {
		//�������õĹ������ݸ�UserDaoImpl
		UserDao dao = new UserDaoImpl(ssf);
		
		User user = dao.getUserById(1);
		System.out.println(user);
	}

}
