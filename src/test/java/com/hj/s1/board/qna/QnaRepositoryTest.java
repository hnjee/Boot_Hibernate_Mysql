package com.hj.s1.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QnaRepositoryTest {
	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private QnaService qnaService;
	
	@Test
	public void insertTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("title2");
		qnaVO.setContents("contents2");
		qnaVO.setWriter("writer2");
		qnaVO = qnaService.boardWrite(qnaVO);
		assertNotNull(qnaVO);
	}
}
