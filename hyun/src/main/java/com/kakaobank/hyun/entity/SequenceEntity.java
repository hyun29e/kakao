package com.kakaobank.hyun.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * Sequece Entity 클래스
 * */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "API_SEQUENCE")
@IdClass(SequenceEntity.class)
@SequenceGenerator(name = "API_SEQ_GENERATOR", sequenceName = "API_SEQ", initialValue = 1, allocationSize = 1)
public class SequenceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "API_SEQ_GENERATOR")
	private int sequence;
	
	@Id
	@CreatedDate
	private LocalDateTime createDate; // 생성일자
}