package com.multi.spring.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.food.model.dto.FoodDTO;

@Controller
@RequestMapping("/book")
public class BookController {

	@GetMapping("/book")
	public void bookForm() {

	}

	
}
