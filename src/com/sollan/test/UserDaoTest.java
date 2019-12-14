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
	// sqlSession工厂
	private static SqlSessionFactory ssf;

	/**
	 * 获取一个工厂
	 */
	static {
		String resource = "sqlMapConfig.xml";
		InputStream in;
		try {
			// 1.读取配置文件
			in = Resources.getResourceAsStream(resource);
			// 2.需要sqlSessionFactoryBulider
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3.创建sqlSessionfactory
			ssf = ssfb.build(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void DaoTest() {
		//将创建好的工厂传递给UserDaoImpl
		UserDao dao = new UserDaoImpl(ssf);
		
		User user = dao.getUserById(1);
		System.out.println(user);
	}

}
