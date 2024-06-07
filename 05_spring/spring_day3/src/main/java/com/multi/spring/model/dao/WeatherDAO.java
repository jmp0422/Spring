package com.multi.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.spring.model.dto.WeatherDTO;

@Repository
public class WeatherDAO {

	
	@Autowired
	SqlSessionTemplate sqlsession;//100
	
	
	public int insert(WeatherDTO dto) {
		return sqlsession.insert("weather.create", dto);
	}
	
}
