package com.sollan.mapper;

import java.util.List;

import com.sollan.bean.User;
import com.sollan.bean.UserVo;

public interface UserMapper {

	/**
	 * 	Mapper动态代理开发4大原则
	 * 
	 *  1.mapper.xml中的namespace要与接口的全包名一致
	 *  2.接口方法名必须与mapper.xml中要调用的SQL语句id一致
	 *  3.接口的形参类型需要与mapper.xml中的parameterType参数类型一致
	 *  4.接口的返回值需要与mapper.xml中的resultType类型一致
	 *  
	 *  
	 *  一个Mapped文件		对应		一个接口
	 *  一个SQL语句		对应 	一个接口方法
	 *   SQL参数			对应		方法参数
	 *   SQL返回值		对应		方法返回值
	 *   
	 *  mapper动态代理开发中，mybatis自动根据返回值来选择返回类型（one还是list）
	 */
	
	//通过ID查询用户
	public User selectUserById(Integer id);
	
	//通过姓名模糊查询用户
	public List<User> selectUserByName(String name);
	
	//增加用户
	public void insertUser(User user);
	
	//修改用户数据
	public void updateUser(User user);
	
	//根据ID删除用户
	public void deleteUserById(Integer id);
	
	//通过User包装类查询用户
	public User selectByUserVoId(UserVo vo);

	//查询用户总条数
	public Integer selectUserCount();
	
	//查询所有用户包装类
	public List<UserVo> selectAllUserVo();
	
	
	
	//多条件查询 通过用户对象中的条件查询用户列表
	public List<User> selectUsrListByUser(User u);

	//多条件查询 通过用户对象中的条件查询用户列表Trim
	public List<User> selectUsrListByUserTrim(User u);
	
	//动态SQL【Set】修改用户信息
	public void updateSetUser(User user);
	
	//动态SQL【foreach】使用多个id获取用户列表by array
	public List<User> selectUserListByIds(Integer[] ids);

	//动态SQL【foreach】使用多个id获取用户列表by userVo
	public List<User> selectUserListByUserVo(UserVo vo);
}





