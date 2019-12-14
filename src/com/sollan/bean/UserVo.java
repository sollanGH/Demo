package com.sollan.bean;

import java.util.List;

/**
 * 	用户包装类
 * 	包含了用户所在的【城市】信息
 */
public class UserVo extends User{
	
	
	private Country country;
	
	//list将传入多个id进行查询
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
