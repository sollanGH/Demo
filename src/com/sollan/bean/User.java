package com.sollan.bean;

import java.util.Date;

public class User {

	/**
	 * domain(实例)的数据类型需要使用包装型。
	 * 
	 */
	private Integer u_id;
	private String u_username;
	private String u_password;
	private String u_sex;
	private Date u_createTime;
	private Integer u_cid;

	public User() {
		super();
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public Date getU_createTime() {
		return u_createTime;
	}

	public void setU_createTime(Date u_createTime) {
		this.u_createTime = u_createTime;
	}

	public Integer getU_cid() {
		return u_cid;
	}

	public void setU_cid(Integer u_cid) {
		this.u_cid = u_cid;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_sex=" + u_sex
				+ ", u_createTime=" + u_createTime + ", u_cid=" + u_cid + "]";
	}

	public User(Integer u_id, String u_username, String u_password, String u_sex, Date u_createTime, Integer u_cid) {
		super();
		this.u_id = u_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_sex = u_sex;
		this.u_createTime = u_createTime;
		this.u_cid = u_cid;
	}

	public User(String u_username, String u_password, String u_sex, Date u_createTime, Integer u_cid) {
		super();
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_sex = u_sex;
		this.u_createTime = u_createTime;
		this.u_cid = u_cid;
	}


}
