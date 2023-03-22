package com.kakaobank.hyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakaobank.hyun.common.Message;
import com.kakaobank.hyun.service.KeyService;

/*
 * key 처리 RestController 클래스
 * */
@RestController
@RequestMapping("/kakaobank/api")
public class KeyController {
	@Autowired
	private KeyService keyService;
	
	/*
	 * GUID 채번
	 * http://localhost:8080/kakaobank/api/guid
	 * */
	@RequestMapping(value = "/guid", method = RequestMethod.GET)
	public String getGUID() {
		String uuid = "";
		try {
			uuid = keyService.getGUID();
		} catch (DuplicateKeyException e) { // uuid 중복 발생시 1회 재시도 (100만개의 ID를 100년동안 생성 할 시, 약 0.00009% 확률로 중복이 발생)
			e.printStackTrace();
			uuid = keyService.getGUID();
		}
		return ("".equals(uuid) ? Message.ERROR_10 : uuid);
	}
	
	/*
	 * Sequece 채번
	 * http://localhost:8080/kakaobank/api/sequence
	 * */
	@RequestMapping(value = "/sequence", method = RequestMethod.GET)
	public int getSequence() {
		return keyService.getSequence();
	}
}
