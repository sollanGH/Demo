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
	 * 	通过ID查询用户
	 */
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 5.操作数据库
		User user = session.selectOne("UserMapper.selectUserById", 1); // (参数1：要操作的sql语句 参数2：sql语句的参数)
		System.out.println(user);

		System.out.println();
	}
	
	
	/**
	 *	 模糊查询 Select like
	 *   1.传递的参数若不是对象，SQL语句中的${ }参数名叫什么无所谓
	 */
	@Test 
	public void Test2() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 5.操作数据库
		List<User> list = session.selectList("UserMapper.selectUserByName", "李");
		for (User u : list) {
			System.out.println(u);
		}
		System.out.println();
	}
	
	
	/**
	 * 	添加数据Insert
	 */
	@Test 
	public void Test3() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 5.添加数据
		User user =new User("李连杰","6666","男",new Date(),100);
		session.insert("UserMapper.inertUser", user);
		session.commit();	//由于开启了事务，修改数据库数据时要手动提交事务。
	}
	
	/**
	 * 	修改数据Update
	 *  1.当参数为一个对象时，对象的【属性值】要和SQL语句中的${ }【参数名】相对应
	 */
	@Test 
	public void Test4() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 5.修改数据
		User user=new User();
		user.setU_id(11);
		user.setU_username("雪姫");
		session.insert("UserMapper.updateUser", user);
		session.commit();
	}
	
	/**
	 * 	根据ID删除数据Delete
	 */
	@Test 
	public void Test5() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 1.读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 2.需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3.创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);

		// 4.生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 5.删除数据
		session.delete("UserMapper.deleteUserById", 10);
		session.commit();
	}
}
