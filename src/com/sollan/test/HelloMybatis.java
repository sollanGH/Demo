package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sollan.bean.User;

public class HelloMybatis {

	/**
	 * 	ͨ��ID��ѯ�û�
	 */
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.��ҪsqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.����sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.����һ��sqlSession
		SqlSession session = ssf.openSession();

		// 5.�������ݿ�
		User user = session.selectOne("UserMapper.selectUserById", 1); // (����1��Ҫ������sql��� ����2��sql���Ĳ���)
		System.out.println(user);

		System.out.println();
	}
	
	
	/**
	 *	 ģ����ѯ Select like
	 *   1.���ݵĲ��������Ƕ���SQL����е�${ }��������ʲô����ν
	 */
	@Test 
	public void Test2() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.��ҪsqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.����sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.����һ��sqlSession
		SqlSession session = ssf.openSession();

		// 5.�������ݿ�
		List<User> list = session.selectList("UserMapper.selectUserByName", "��");
		for (User u : list) {
			System.out.println(u);
		}
		System.out.println();
	}
	
	
	/**
	 * 	�������Insert
	 */
	@Test 
	public void Test3() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.��ҪsqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.����sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.����һ��sqlSession
		SqlSession session = ssf.openSession();

		// 5.�������
		User user =new User("������","6666","��",new Date(),100);
		session.insert("UserMapper.inertUser", user);
		session.commit();	//���ڿ����������޸����ݿ�����ʱҪ�ֶ��ύ����
	}
	
	/**
	 * 	�޸�����Update
	 *  1.������Ϊһ������ʱ������ġ�����ֵ��Ҫ��SQL����е�${ }�������������Ӧ
	 */
	@Test 
	public void Test4() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.��ҪsqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.����sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.����һ��sqlSession
		SqlSession session = ssf.openSession();

		// 5.�޸�����
		User user=new User();
		user.setU_id(11);
		user.setU_username("ѩ��");
		session.insert("UserMapper.updateUser", user);
		session.commit();
	}
	
	/**
	 * 	����IDɾ������Delete
	 */
	@Test 
	public void Test5() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.��ҪsqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.����sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.����һ��sqlSession
		SqlSession session = ssf.openSession();

		// 5.ɾ������
		session.delete("UserMapper.deleteUserById", 10);
		session.commit();
	}
}
