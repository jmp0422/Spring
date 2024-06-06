package com.multi.spring.sign.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.sign.model.dto.SignDTO;
import com.multi.spring.sign.service.SignService;



@Controller
@RequestMapping("/sign")
public class SignController {
	
	@Autowired
	SignService signService;


	@GetMapping("/main")
	public void signmain() {

	}
	
	
	@PostMapping("/insert")
	public void insertSign(SignDTO signDTO, HttpServletRequest request, // 경로 가져올떄 사용
			MultipartFile image, Model model) throws Exception {
		
		

		System.out.println("singleFile : " + image);

		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");

		System.out.println("root : " + root);

		String filePath = root + "\\uploadFiles";

		File mkdir = new File(filePath);
		if (!mkdir.exists()) {
			mkdir.mkdirs();
		}

		/* 파일명 변경 처리 */
		String originFileName = image.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext; // 확장자이름은 그대로두고 랜덤하게 뒤에 붙여서 시스템이름 만들기

		/* 파일을 저장한다. */
		try {
			image.transferTo(new File(filePath + "\\" + savedName));

			model.addAttribute("savedName", savedName);

			System.out.println("img넣기 전>> " + signDTO);
			signDTO.setImg(savedName);
			System.out.println("img넣은 후>> " + signDTO);
			signService.insertSign(signDTO);
			model.addAttribute("signDTO", signDTO);
			System.out.println("insertMovie 후>> " + signDTO);
		} catch (Exception e) {
			e.printStackTrace();
			/* 실패시 파일 삭제 */
			new File(filePath + "\\" + savedName).delete();
			model.addAttribute("message", "파일 업로드 실패!!");
		}
	}
	
	@GetMapping("/list")
	public void selectList(Model model) throws Exception {
		List<SignDTO> list = signService.selectList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/one")
	public void selectSign(String name, String birth, Model model) throws Exception {
		SignDTO dto = signService.selectSign(name,birth);
		
		model.addAttribute("dto", dto);
		System.out.println(dto);
	}
	
	@GetMapping("/delete")
	public String deleteSign(String name, String birth, Model model) throws Exception {
		signService.deleteSign(name,birth);
		
		return "redirect:/sign/main";
	}
	
	


}
