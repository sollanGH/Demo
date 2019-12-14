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

	/* --通过ID查询用户-------------------------------------------------------------------*/
	@Test
	public void Test1() throws IOException {
		// 接口名+ Mapper文件的namespace
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectUserById(1);
		System.out.println(user);

	}
	
	
	
	/* --通过姓名模糊查询用户-------------------------------------------------------------------*/
	@Test
	public void Test2() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserByName("王");
		for (User user : list) {
			System.out.println(user);
		}

	}

	
	/* --增加用户-------------------------------------------------------------------*/
	@Test
	public void Test3() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User("长泽雅美", "長澤まさみ", "女", new Date(), 5);
		mapper.insertUser(user);
		session.commit();

	}

	
	
	/* --修改用户数据-------------------------------------------------------------------*/
	@Test
	public void Test4() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setU_id(15);
		user.setU_username("まさみ");
		mapper.updateUser(user);
		session.commit();
	}

	
	
	/* --根据ID删除用户-------------------------------------------------------------------*/
	@Test
	public void Test5() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUserById(47);
		session.commit();
	}

	
	
	/* --查询用户总条数-------------------------------------------------------------------*/
	@Test
	public void Test6() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer count = mapper.selectUserCount();
		System.out.println("用户数量为：" + count);
	}

	
	/* --测试resultMap手动映射-------------------------------------------------------------------*/
	@Test
	public void Test7() throws IOException {
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		Country country = new Country(null, "老挝", "万象");
		mapper.insertCountry(country);
		session.commit();

	}

	
	/* --查询UserVo包装类-------------------------------------------------------------------*/
	@Test
	public void Test8() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserVo> list = mapper.selectAllUserVo();
		for (UserVo userVo : list) {
			System.out.println(userVo);
		}
	}

	
	/* --查询UserVo包装类-------------------------------------------------------------------*/
	@Test
	public void Test9() throws IOException {
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		List<CountryVo> list = mapper.selectAllCountryVo();
		for (CountryVo countryVo : list) {
			System.out.println(countryVo);
		}
	}

	/* --多条件查询 通过用户对象中的条件查询用户列表-------------------------------------------------------------------*/
	@Test
	public void Test10() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_username("王");
		u.setU_sex("1");
		u.setU_cid(1);
		List<User> listByUser = mapper.selectUsrListByUser(u);
		for (User user : listByUser) {
			System.out.println(user);
		}
	}

	/* --Trim测试-------------------------------------------------------------------*/
	@Test
	public void selectUsrListByUserTrim() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_username("王");
		u.setU_sex("1");
		u.setU_cid(1);
		List<User> listByUser = mapper.selectUsrListByUserTrim(u);
		for (User user : listByUser) {
			System.out.println(user);
		}
	}
	
	
	/* --Set测试-------------------------------------------------------------------*/
	@Test
	public void updateSetUser() throws IOException {
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_id(1);
		u.setU_username("隔壁老王");
		u.setU_password("青青草原");
		u.setU_sex("男");
		mapper.updateSetUser(u);
		session.commit();
	}
	
	/* --ForEach测试-------------------------------------------------------------------*/
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
