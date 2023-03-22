package com.kakaobank.hyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kakaobank.hyun.entity.GUIDEntity;
import com.kakaobank.hyun.entity.SequenceEntity;
import com.kakaobank.hyun.repository.GUIDRepository;
import com.kakaobank.hyun.repository.SequenceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/*
 * key 처리 Service 클래스
 * */
@Service
@Transactional
public class KeyService {
	@Autowired
	private GUIDRepository guidRepository;
	
	@Autowired
	private SequenceRepository sequenceRepository;
	
	@PersistenceContext
	private EntityManager em;

	// 채번 후 UUID 반환
	public String getGUID() {
		GUIDEntity guidEntity = new GUIDEntity(); 
		guidRepository.save(guidEntity);
		return guidEntity.getGuid();
	}
	
	// 채번 후 sequece 반환
	public int getSequence() {
		SequenceEntity sequenceEntity = new SequenceEntity();
		sequenceRepository.save(sequenceEntity);
		return sequenceRepository.selectLastSequence();
	}
	
	// 매일 정각 Sequece 초기화
	@Scheduled(cron = "0 0 0 * * *")
	public void initSequence() {
		em.createNativeQuery("ALTER SEQUENCE API_SEQ RESTART WITH 1").executeUpdate();
	}
}
