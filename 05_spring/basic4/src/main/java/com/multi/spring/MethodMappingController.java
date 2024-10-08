package com.multi.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingController {

	//@RequestMapping("/menu/regist") 
	@RequestMapping(value = "/menu/regist", method = RequestMethod.POST) //포스트방식 / POST를 GET으로바꾸면 겟방식도됨
	public String registMenu(Model model) {
		//1. Model 객체 사용하는 방법
		
		// Model 이라는 객체를 사용 하여 응답뷰로 전달하고자 하는 데이터를 맵형식(key,value) 로 담을수 있다.
		// scope 는 request 이다.
				
		System.out.println("메소드 호출 확인 - registMenu");
		model.addAttribute("message", "신규메뉴등록!");
		
		return "mappingResult";
	}
	//@RequestMapping("/menu/modify")
	@RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
	public String modifyMenu(Model model) {
		System.out.println("메소드 호출 확인 - modifyMenu");
		model.addAttribute("message", "메뉴수정!");
		
		return "mappingResult";
	}
	
	// 확인 요청 메소드별 전용 어노테이션 (4.3 버전 이상 ) 
	 /* 요청메소드            어노테이션
	 * POST         @PostMapping          C            BODY         행이추가
	 * GET          @GetMapping           R            HEADER 사용 
	 * PUT          @PutMapping           U            BODY         행이그대로 
	 * DELETE       @DeleteMapping        D            BODY
	 * */
	
	@GetMapping("/menu/delete")
	//@RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
	public String getDeleteMenu(Model model) {
		
		model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출함...");

		return "mappingResult";
	}
	
	
	@PostMapping("/menu/delete")
	public String postDeleteMenu(Model model) {
		
		model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
}
