package com.multi.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.spring.member.model.dao.MemberDAO;
import com.multi.spring.member.model.dto.MemberDTO;

@Controller
public class MemberController {

//	@Autowired //필드주입 -> new 객체 생성안해도됨
//	// 빈스캐닝을 통해 해당 인터페이스를 구현한 클래스(구현체)중 @Component + 기능(@Service, Repository) 으로 등록되어있는 빈을 찾아서 자동으로 주입(DI) 해준다
//	MemberDAO memberDAO;
//	// MemberDAO memberDAO = new MemberDAO();

	// 생성자 주입
	private final MemberDAO memberDAO;

	// --------------------------------------------------------- //@Autowired
	public MemberController(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@RequestMapping("/member")
	public void member() {

	}

	@RequestMapping("/insert")
	public void insert(@ModelAttribute MemberDTO memberDTO) { // 커맨드객체, commend

		System.out.println(memberDTO);
		memberDAO.insert(memberDTO);

		// return "insert"; // viewresolver에 의해 앞뒤로 경로와 확장자를 붙여서 클라이언트에 보여줄수있게 처리됨
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO) {

		System.out.println(memberDTO);
		int result = 1; // 결과값에따라 0 or 1
		if (result == 1) {
			return "ok";
		} else {
			return "redirect:member";
		}

	}

	@RequestMapping("/delete")
	public void delete(@RequestParam("id") String writer) { //@RequestParam 생략하려면 매개변수의 name과 동일하게 파라메터를 줘야함
		System.out.println("받은 아이디는 " + writer);

	}
}
