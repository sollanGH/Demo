package com.sollan.bean;

import java.util.List;

/**
 * 	�û���װ��
 * 	�������û����ڵġ����С���Ϣ
 */
public class UserVo extends User{
	
	
	private Country country;
	
	//list��������id���в�ѯ
	private List<Integer> idList;
	
	
	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public Country getCountry() {
		return country;
		
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserVo [country=" + country + ", getU_id()=" + getU_id() + ", getU_username()=" + getU_username()
				+ ", getU_sex()=" + getU_sex() + "]";
	}

	





}
