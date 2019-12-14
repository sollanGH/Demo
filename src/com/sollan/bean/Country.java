package com.sollan.bean;

public class Country {
	// 国家ID，命名没有与数据库中对应
	private Integer id;
	// 国家名称
	private String c_countryname;
	// 国家首都名
	private String c_capital;

	/**
	 * id与数据库属性不一致，将无法自动映射匹配 (数据库的叫c_id)
	 * 使用resultMap进行手动映射 
	 * 其余两个属性值与数据库属性同名，将可以自动映射
	 * 
	 * 
	 */

	public Country(Integer id, String c_countryname, String c_capital) {
		super();
		this.id = id;
		this.c_countryname = c_countryname;
		this.c_capital = c_capital;
	}

	

	public Country(String c_countryname, String c_capital) {
		super();
		this.c_countryname = c_countryname;
		this.c_capital = c_capital;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", c_countryname=" + c_countryname + ", c_capital=" + c_capital + "]";
	}

	public String getC_countryname() {
		return c_countryname;
	}

	public void setC_countryname(String c_countryname) {
		this.c_countryname = c_countryname;
	}

	public String getC_capital() {
		return c_capital;
	}

	public void setC_capital(String c_capital) {
		this.c_capital = c_capital;
	}
}
