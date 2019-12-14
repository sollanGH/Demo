package com.sollan.mapper;

import java.util.List;

import com.sollan.bean.Country;
import com.sollan.bean.CountryVo;

public interface CountryMapper {
	
	//查询所有国家
	public List<Country> selectAll();
	
	//添加一个国家
	public void insertCountry(Country country);
	
	//查询所有CountryVo
	public List<CountryVo> selectAllCountryVo();
	
}
