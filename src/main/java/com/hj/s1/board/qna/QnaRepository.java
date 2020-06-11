package com.hj.s1.board.qna;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<QnaVO, Long> {
	public int countByTitleContaining(String search);
	public int countByWriterContaining(String search);
	public int countByContentsContaining(String search);
	
	public List<QnaVO> findByTitleContaining(String search, Pageable pageable);	
	public List<QnaVO> findByWriterContaining(String search, Pageable pageable);	
	public List<QnaVO> findByContentsContaining(String search, Pageable pageable);	
}
