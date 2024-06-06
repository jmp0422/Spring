package com.multi.spring.sign.service;

import java.util.List;

import com.multi.spring.sign.model.dto.SignDTO;

public interface SignService {

	void insertSign(SignDTO signDTO) throws Exception;

	SignDTO selectSign(String name, String birth) throws Exception;

	List<SignDTO> selectList() throws Exception;

	void deleteSign(String name, String birth) throws Exception;

}
