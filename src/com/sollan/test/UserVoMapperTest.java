package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sollan.bean.User;
import com.sollan.bean.UserVo;
import com.sollan.mapper.UserMapper;

public class UserVoMapperTest {
	/**
	 * 通过姓名模糊查询用户
	 */
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);

		// 创建sqlSessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 接口名 Mapper文件的namespace
		UserMapper mapper = session.getMapper(UserMapper.class);

		UserVo vo=new UserVo();
		User u=new User();
		u.setU_id(8);
//		vo.setUser(u);
		
		User user = mapper.selectByUserVoId(vo);
			System.out.println(user);
	}
	
	
}
