package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis【动态查询】测试
 * 
 */
public class DynamicQuery {

	private static SqlSession session;
	// 获取到session
	static {
		String resource = "sqlMapConfig.xml";
		try {
			// 读取配置文件
			InputStream in = Resources.getResourceAsStream(resource);
			// 创建sqlSessionfactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			// 生产一个sqlSession
			session = ssf.openSession();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
