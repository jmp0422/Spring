package com.multi.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.board.model.dto.BoardDTO;

@Repository
public class BoardDAO {

	public int insertBoard(SqlSessionTemplate sqlSession, BoardDTO boardDTO) {
		return sqlSession.insert("boardMapper.insertBoard", boardDTO);
	}

	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession) {
		return (List) sqlSession.selectList("boardMapper.selectBoardList");
	}

	public BoardDTO selectBoard(SqlSessionTemplate sqlSession, String title) {
		return sqlSession.selectOne("boardMapper.selectBoard", title);
	}

}
