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
	 * ͨ������ģ����ѯ�û�
	 */
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		// ��ȡ�����ļ�
		InputStream in = Resources.getResourceAsStream(resource);

		// ����sqlSessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// ����һ��sqlSession
		SqlSession session = ssf.openSession();

		// �ӿ��� Mapper�ļ���namespace
		UserMapper mapper = session.getMapper(UserMapper.class);

		UserVo vo=new UserVo();
		User u=new User();
		u.setU_id(8);
//		vo.setUser(u);
		
		User user = mapper.selectByUserVoId(vo);
			System.out.println(user);
	}
	
	
}
