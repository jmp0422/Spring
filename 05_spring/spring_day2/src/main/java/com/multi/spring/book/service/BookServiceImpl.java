package com.multi.spring.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.book.model.dao.BookDAO;
import com.multi.spring.book.model.dto.BookDTO;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookDAO bookDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public void insertBook(BookDTO bookDTO) throws Exception {
		int result = bookDAO.insertBook(sqlSession, bookDTO);
		if (result < 0) {
			throw new Exception("북마크 등록에 실패 하셨습니다");
		}
	}
	
	

	@Override
	public void deleteBook(String id) throws Exception {
		int result = bookDAO.deleteBook(sqlSession, id);
		if (result < 0) {
			throw new Exception("삭제에 실패 하셨습니다");
		}
	}

	@Override
	public List<BookDTO> selectList() throws Exception {
		List<BookDTO> list = bookDAO.selectList(sqlSession);
		return list;
	}

	@Override
	public BookDTO selectBook(int id) throws Exception {
		BookDTO dto = bookDAO.selectBook(sqlSession, id);
		return dto;
	}

}
