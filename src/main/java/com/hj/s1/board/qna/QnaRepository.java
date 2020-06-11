package com.hj.s1.board.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<QnaVO, Long> {
	//title 검색
	Page<QnaVO> findByTitleContaining(String search, Pageable pageable);	
	//contents 검색 	
	Page<QnaVO> findByContentsContaining(String search, Pageable pageable);	
	//writer 검색
	Page<QnaVO> findByWriterContaining(String search, Pageable pageable);
}
