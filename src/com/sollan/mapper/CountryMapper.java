package com.sollan.mapper;

import java.util.List;

import com.sollan.bean.Country;
import com.sollan.bean.CountryVo;

public interface CountryMapper {
	
	//��ѯ���й���
	public List<Country> selectAll();
	
	//���һ������
	public void insertCountry(Country country);
	
	//��ѯ����CountryVo
	public List<CountryVo> selectAllCountryVo();
	
}
