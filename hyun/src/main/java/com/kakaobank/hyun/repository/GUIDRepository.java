package com.kakaobank.hyun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kakaobank.hyun.entity.GUIDEntity;

/*
 * GUID Repository 인터페이스
 * */
@Repository
public interface GUIDRepository extends JpaRepository<GUIDEntity, Long>{
}
