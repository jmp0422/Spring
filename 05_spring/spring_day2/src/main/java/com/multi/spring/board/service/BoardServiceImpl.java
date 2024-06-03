package com.multi.spring.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.board.model.dao.BoardDAO;
import com.multi.spring.board.model.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoradService {
	
	private final BoardDAO boardDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		int result = boardDAO.insertBoard(sqlSession, boardDTO);
		if (result < 0) {
			throw new Exception("게시글 등록에 실패 하셨습니다");
		}
	}

	@Override
	public List<BoardDTO> selectBoardList() throws Exception {
		List<BoardDTO> list = boardDAO.selectBoardList(sqlSession);
		return list;
	}

	@Override
	public BoardDTO selectBoard(String title) throws Exception {
		BoardDTO dto = boardDAO.selectBoard(sqlSession, title);
		return dto;
	}

}
