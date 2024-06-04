package com.multi.spring.book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.book.model.dto.BookDTO;
import com.multi.spring.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	// 생성자 주입
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/book")
	public void bookForm() {

	}
	
	@RequestMapping("insert")
	public void insertForm() {
			
	}

	@PostMapping("/insert")
	public String insertBook(BookDTO bookDTO , HttpSession session) throws Exception {
		System.out.println("insert ==> " + bookDTO);
		bookService.insertBook(bookDTO);
		
		return "redirect:/book/book";
	}
	
	@GetMapping("/delete")
	public String deleteMember(String id) throws Exception {
		bookService.deleteBook(id);
		return "redirect:/book/book";
	}
	
	@GetMapping("/list")
	public void selectList(Model model) throws Exception {
		List<BookDTO> list = bookService.selectList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/one")
	public void selectBook(int id, Model model1) throws Exception {
		BookDTO dto = bookService.selectBook(id);
		
		model1.addAttribute("dto", dto);
		System.out.println(dto);
	}
	
}
