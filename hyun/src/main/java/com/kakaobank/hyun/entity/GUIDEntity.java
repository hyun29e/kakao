package com.kakaobank.hyun.entity;

import com.kakaobank.hyun.utill.KeyUtill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * GUID Entity 클래스
 * */
@Data
@Entity
@Table(name = "API_GUID")
public class GUIDEntity extends BaseTimeEntity {
	@Id
	@Column(nullable = false, updatable = false, length = 30) // not null, 수정 불가, 길이 30 
	private String guid;
	
	public GUIDEntity() {
		this.guid = (new KeyUtill().makeGUID()); // GUID 채번
	}
}