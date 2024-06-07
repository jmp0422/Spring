package com.multi.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.model.dao.WeatherDAO;
import com.multi.spring.model.dto.WeatherDTO;

@Controller //ReplyController replyController = new ReplyController();
public class WeatherController {

	@Autowired
	WeatherDAO weatherDAO;
	
	@RequestMapping("insert5") //ajax호출!
	//ajax호출은 views/insert4.jsp를 만들지 않으면 ajax호출 404에러가 뜬다. 
	public void insert(WeatherDTO weatherDTO, Model model) {
			
		int result = weatherDAO.insert(weatherDTO);
		

		model.addAttribute("result", result);
	}
}
