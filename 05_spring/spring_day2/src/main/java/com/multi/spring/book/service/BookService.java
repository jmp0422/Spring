package com.multi.spring.book.service;

import java.util.List;

import com.multi.spring.book.model.dto.BookDTO;

public interface BookService {

	void insertBook(BookDTO bookDTO) throws Exception;


	List<BookDTO> selectList() throws Exception;


	BookDTO selectBook(int id) throws Exception;


	void deleteBook(String id) throws Exception;



}
