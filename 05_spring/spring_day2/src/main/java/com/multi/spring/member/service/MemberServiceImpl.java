package com.multi.spring.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.multi.spring.member.model.dao.MemberDAO;
import com.multi.spring.member.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

//	@Override
//	public void insertMember(MemberDTO memberDTO) throws Exception {
//		int result = memberDAO.insertMember(sqlSession, memberDTO);
//		if (result < 0) {
//			throw new Exception("회원가입에 실패 하셨습니다");
//		}
//
//	}

	@Override
	public List<MemberDTO> selectList() throws Exception {
		List<MemberDTO> list = memberDAO.selectList(sqlSession);
		return list;
	}

	@Override
	public void deleteMember(String id) throws Exception {
		int result = memberDAO.deleteMember(sqlSession, id);
		if (result < 0) {
			throw new Exception("회원삭제에 실패 하셨습니다");
		}

	}

	@Override
	public void updateMember(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.updateMember(sqlSession, memberDTO);
		if (result < 0) {
			throw new Exception("회원수정에 실패 하셨습니다");
		}
	}

	@Override
	public MemberDTO selectMember(String id) throws Exception {
		MemberDTO dto = memberDAO.selectMember(sqlSession, id);
		return dto;
	}



//	@Override
//	public MemberDTO loginMember(MemberDTO m) throws Exception {
//		MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
//		if (loginUser == null) {
//			throw new Exception("로그인에 실패 하셨습니다");
//		}
//		return loginUser;
//	}
	
	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		MemberDTO loginUser = memberDAO.loginMember(sqlSession, memberDTO);
		
		if(loginUser == null) {
			throw new Exception("로그인 정보확인 / 로그인에 실패 하셨습니다");
		}
		if(!bCryptPasswordEncoder.matches(memberDTO.getPw(), loginUser.getPw())){
			throw new Exception("암호 불일치!");
		}
		return loginUser;
	}
	
	@Override //회원가입
	public void insertMember(MemberDTO memberDTO) throws Exception {
		System.out.println("암호화전 : " + memberDTO.getPw());
		
		String encpw = bCryptPasswordEncoder.encode(memberDTO.getPw());
		
		System.out.println("암호화후 : " + encpw);
		
		memberDTO.setPw(encpw);
		int result = memberDAO.insertMember(sqlSession, memberDTO);
		if (result < 0) {
			throw new Exception("회원가입에 실패 하셨습니다");
		}

	}

		
	
}
