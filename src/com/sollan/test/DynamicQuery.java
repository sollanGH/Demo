package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis����̬��ѯ������
 * 
 */
public class DynamicQuery {

	private static SqlSession session;
	// ��ȡ��session
	static {
		String resource = "sqlMapConfig.xml";
		try {
			// ��ȡ�����ļ�
			InputStream in = Resources.getResourceAsStream(resource);
			// ����sqlSessionfactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			// ����һ��sqlSession
			session = ssf.openSession();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
