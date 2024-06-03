package com.multi.spring.board.service;

import java.util.List;

import com.multi.spring.board.model.dto.BoardDTO;


public interface BoradService {

	void insertBoard(BoardDTO boardDTO) throws Exception;

	List<BoardDTO> selectBoardList() throws Exception;

	BoardDTO selectBoard(String title) throws Exception;

}