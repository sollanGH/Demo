package com.sollan.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sollan.bean.Country;
import com.sollan.bean.CountryVo;
import com.sollan.bean.User;
import com.sollan.bean.UserVo;
import com.sollan.mapper.CountryMapper;
import com.sollan.mapper.UserMapper;

public class MapperTest {

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

	/* --ͨ��ID��ѯ�û�-------------------------------------------------------------------*/
	@Test
	public void Test1() throws IOException {
		// �ӿ���+ Mapper�ļ���namespace
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectUserById(1);
		System.out.println(user);

	}
	
	
	
	/* --ͨ������ģ����ѯ�û�-------------------------------------------------------------------*/
	@Test
	public void Test2() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserByName("��");
		for (User user : list) {
			System.out.println(user);
		}

	}

	
	/* --�����û�-------------------------------------------------------------------*/
	@Test
	public void Test3() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User("��������", "�L�ɤޤ���", "Ů", new Date(), 5);
		mapper.insertUser(user);
		session.commit();

	}

	
	
	/* --�޸��û�����-------------------------------------------------------------------*/
	@Test
	public void Test4() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setU_id(15);
		user.setU_username("�ޤ���");
		mapper.updateUser(user);
		session.commit();
	}

	
	
	/* --����IDɾ���û�-------------------------------------------------------------------*/
	@Test
	public void Test5() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUserById(47);
		session.commit();
	}

	
	
	/* --��ѯ�û�������-------------------------------------------------------------------*/
	@Test
	public void Test6() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer count = mapper.selectUserCount();
		System.out.println("�û�����Ϊ��" + count);
	}

	
	/* --����resultMap�ֶ�ӳ��-------------------------------------------------------------------*/
	@Test
	public void Test7() throws IOException {
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		Country country = new Country(null, "����", "����");
		mapper.insertCountry(country);
		session.commit();

	}

	
	/* --��ѯUserVo��װ��-------------------------------------------------------------------*/
	@Test
	public void Test8() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserVo> list = mapper.selectAllUserVo();
		for (UserVo userVo : list) {
			System.out.println(userVo);
		}
	}

	
	/* --��ѯUserVo��װ��-------------------------------------------------------------------*/
	@Test
	public void Test9() throws IOException {
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		List<CountryVo> list = mapper.selectAllCountryVo();
		for (CountryVo countryVo : list) {
			System.out.println(countryVo);
		}
	}

	/* --��������ѯ ͨ���û������е�������ѯ�û��б�-------------------------------------------------------------------*/
	@Test
	public void Test10() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_username("��");
		u.setU_sex("1");
		u.setU_cid(1);
		List<User> listByUser = mapper.selectUsrListByUser(u);
		for (User user : listByUser) {
			System.out.println(user);
		}
	}

	/* --Trim����-------------------------------------------------------------------*/
	@Test
	public void selectUsrListByUserTrim() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_username("��");
		u.setU_sex("1");
		u.setU_cid(1);
		List<User> listByUser = mapper.selectUsrListByUserTrim(u);
		for (User user : listByUser) {
			System.out.println(user);
		}
	}
	
	
	/* --Set����-------------------------------------------------------------------*/
	@Test
	public void updateSetUser() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_id(1);
		u.setU_username("��������");
		u.setU_password("�����ԭ");
		u.setU_sex("��");
		mapper.updateSetUser(u);
		session.commit();
	}
	
	/* --ForEach����-------------------------------------------------------------------*/
	@Test
	public void Test11() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer[] ids= {1,3,5};
		List<User> user = mapper.selectUserListByIds(ids);
		for (User u : user) {
			System.out.println(u);
		}
	}
	
	@Test
	public void Test12() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> idList =new ArrayList<Integer>();
		idList.add(4);
		idList.add(5);
		idList.add(6);
		UserVo vo=new UserVo();
		vo.setIdList(idList);
		List<User> user = mapper.selectUserListByUserVo(vo);
		for (User u : user) {
			System.out.println(u);
		}
	}
	
	
	

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
