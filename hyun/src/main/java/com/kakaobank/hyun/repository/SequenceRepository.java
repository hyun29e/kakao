package com.kakaobank.hyun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kakaobank.hyun.entity.SequenceEntity;

/*
 * Sequence Repository 인터페이스
 * */
@Repository
public interface SequenceRepository extends JpaRepository<SequenceEntity, Long> {
	@Query(value = "SELECT sequence FROM SequenceEntity ORDER BY createDate DESC LIMIT 1")
    int selectLastSequence();
}
