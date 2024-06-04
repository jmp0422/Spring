package com.multi.spring.book.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.book.model.dto.BookDTO;

@Repository
public class BookDAO {

	public int insertBook(SqlSessionTemplate sqlSession, BookDTO bookDTO) {
		return sqlSession.insert("bookMapper.insertBook", bookDTO);
	}

	public List<BookDTO> selectList(SqlSessionTemplate sqlSession) {
		return (List) sqlSession.selectList("bookMapper.selectList");
	}


	public BookDTO selectBook(SqlSessionTemplate sqlSession, int id) {
		return sqlSession.selectOne("bookMapper.selectBook", id);
	}

	public int deleteBook(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.delete("bookMapper.deleteBook", id);
	}




}
