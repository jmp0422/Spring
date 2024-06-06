package com.multi.spring.page.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.page.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Repository
public class BbsDAO {

	public List<BbsDTO> selectAll(SqlSessionTemplate sqlSession, PageDTO pageDto) {

		return sqlSession.selectList("bbsMapper.selectAll", pageDto);
	}

	public int selectCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("bbsMapper.selectCount");
	}



}
