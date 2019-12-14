package com.sollan.bean;

import java.util.List;

public class CountryVo extends Country{

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public CountryVo(Integer id, String c_countryname, String c_capital, List<User> userList) {
		super(id, c_countryname, c_capital);
		this.userList = userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return super.toString() + "userList="+userList;
	}
}
