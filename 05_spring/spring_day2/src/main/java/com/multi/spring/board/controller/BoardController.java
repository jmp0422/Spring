package com.multi.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.board.service.BoradService;

@Controller
@RequestMapping("/board") 
public class BoardController {
	
	// 생성자 주입
	@Autowired
	BoradService boardService;
	
	public BoardController(BoradService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}

	@RequestMapping("/bbs")
	public void boardMain() {
	
	}
	
	
	@RequestMapping("/bbs_insert_form")
	public void insertForm() {
			
	}
	
	@RequestMapping("/bbs_one_form")
	public void oneForm() {
			
	}
	

	
	@PostMapping("/insert")
	public String insertBoard(BoardDTO boardDTO , HttpSession session) throws Exception {
		System.out.println("insert ==> " + boardDTO);
		boardService.insertBoard(boardDTO);
		session.setAttribute("msg", "게시판등록성공");
		return "redirect:/board/bbs";
	}
	
	@GetMapping("/bbs_list")
	public void selectBoardList(Model model) throws Exception {
		List<BoardDTO> list = boardService.selectBoardList();
		
		model.addAttribute("list", list);
	}
	
	
	@GetMapping("/bbs_one")
	public void selectBoard(String title, Model model1) throws Exception {
		BoardDTO dto = boardService.selectBoard(title);
		
		model1.addAttribute("bag", dto);
		System.out.println(dto);
	}
}
