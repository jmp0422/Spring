package com.multi.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.multi.spring.member.model.dto.MemberDTO;
import com.multi.spring.member.service.MemberService;

@SessionAttributes("loginUser") // Model에 Attribute 추가할때 자동으로 설정된 키값을 세션에 등록 시키는 기능
@Controller
@RequestMapping("/member")  //member폴더안에 mvc가 다있다
public class MemberController {
	
	// 생성자 주입
	private final MemberService memberService;

	// --------------------------------------------------------- //@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}

	@RequestMapping("/member")
	public void memberMain() {
	
	}
	
	@RequestMapping("/delete_form")
	public void deleteForm() {
			
	}
	
	@RequestMapping("/insert_form")
	public void insertForm() {
			
	}
	
	@RequestMapping("/one_form")
	public void oneForm() {
			
	}
	
	@RequestMapping("/update_form")
	public void updateForm() {
			
	}
	
	@RequestMapping("/enrollForm")
	public String enrollForm() {
		return "member/enroll_form";
	}
	
	@PostMapping("/insert")
	public String insertMember(MemberDTO memberDTO , HttpSession session) throws Exception {
		System.out.println("insert ==> " + memberDTO);
		memberService.insertMember(memberDTO);
		session.setAttribute("msg", "회원가입성공");
		return "redirect:/member/member";
	}
	
	@GetMapping("/list")
	public void selectList(Model model) throws Exception {
		List<MemberDTO> list = memberService.selectList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/delete")
	public String deleteMember(String id) throws Exception {
		memberService.deleteMember(id);
		return "redirect:/member/member";
	}
	
	@PostMapping("/update")
	public String updateMember(MemberDTO memberDTO , HttpSession session) throws Exception {
		System.out.println("update ==> " + memberDTO);
		memberService.updateMember(memberDTO);
		session.setAttribute("msg", "회원수정성공");
		return "redirect:/member/member";
	}
	
	@GetMapping("/one")
	public void selectMember(String id, Model model) throws Exception {
		MemberDTO dto = memberService.selectMember(id);
		
		model.addAttribute("dto", dto);
	}
	
//	@PostMapping("/login")
//	public String loginMember(MemberDTO m, HttpSession session) {
//		
//		System.out.println("login ==> " + m);
//		
//		try {
//			MemberDTO dto = memberService.loginMember(m);
//			session.setAttribute("loginUser", dto);
//			
//			return "redirect:/";
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			return "common/errorPage";
//		}
//	}
//	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate(); //확인 세션종료 - 로그아웃시 사용
//		return "redirect:/"; // 홈으로나가기 이전메뉴같음
//	}
	
	@PostMapping("/login")
	public String loginMember(MemberDTO memberDTO, Model model) {
		
		System.out.println("login ==> " + memberDTO);
		
		try {
			MemberDTO dto = memberService.loginMember(memberDTO);
			model.addAttribute("loginUser", dto);
			return "redirect:/";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "common/errorPage";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete(); //현재 SessionAttributes 에 의해 저장된 오브젝트를 제거
		return "redirect:/"; // 홈으로나가기 이전메뉴같음
	}
	
}
