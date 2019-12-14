package com.sollan.mapper;

import java.util.List;

import com.sollan.bean.User;
import com.sollan.bean.UserVo;

public interface UserMapper {

	/**
	 * 	Mapper��̬������4��ԭ��
	 * 
	 *  1.mapper.xml�е�namespaceҪ��ӿڵ�ȫ����һ��
	 *  2.�ӿڷ�����������mapper.xml��Ҫ���õ�SQL���idһ��
	 *  3.�ӿڵ��β�������Ҫ��mapper.xml�е�parameterType��������һ��
	 *  4.�ӿڵķ���ֵ��Ҫ��mapper.xml�е�resultType����һ��
	 *  
	 *  
	 *  һ��Mapped�ļ�		��Ӧ		һ���ӿ�
	 *  һ��SQL���		��Ӧ 	һ���ӿڷ���
	 *   SQL����			��Ӧ		��������
	 *   SQL����ֵ		��Ӧ		��������ֵ
	 *   
	 *  mapper��̬�������У�mybatis�Զ����ݷ���ֵ��ѡ�񷵻����ͣ�one����list��
	 */
	
	//ͨ��ID��ѯ�û�
	public User selectUserById(Integer id);
	
	//ͨ������ģ����ѯ�û�
	public List<User> selectUserByName(String name);
	
	//�����û�
	public void insertUser(User user);
	
	//�޸��û�����
	public void updateUser(User user);
	
	//����IDɾ���û�
	public void deleteUserById(Integer id);
	
	//ͨ��User��װ���ѯ�û�
	public User selectByUserVoId(UserVo vo);

	//��ѯ�û�������
	public Integer selectUserCount();
	
	//��ѯ�����û���װ��
	public List<UserVo> selectAllUserVo();
	
	
	
	//��������ѯ ͨ���û������е�������ѯ�û��б�
	public List<User> selectUsrListByUser(User u);

	//��������ѯ ͨ���û������е�������ѯ�û��б�Trim
	public List<User> selectUsrListByUserTrim(User u);
	
	//��̬SQL��Set���޸��û���Ϣ
	public void updateSetUser(User user);
	
	//��̬SQL��foreach��ʹ�ö��id��ȡ�û��б�by array
	public List<User> selectUserListByIds(Integer[] ids);

	//��̬SQL��foreach��ʹ�ö��id��ȡ�û��б�by userVo
	public List<User> selectUserListByUserVo(UserVo vo);
}





