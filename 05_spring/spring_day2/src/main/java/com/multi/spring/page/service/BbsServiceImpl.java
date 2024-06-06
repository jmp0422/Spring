package com.multi.spring.page.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.page.model.dao.BbsDAO;
import com.multi.spring.page.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDAO bbsDAO;
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<BbsDTO> selectAll(PageDTO pageDto) throws Exception {
		
		return bbsDAO.selectAll(sqlSession, pageDto);
	}

	@Override
	public int selectCount() throws Exception {
		return bbsDAO.selectCount(sqlSession);
	}

	

}
