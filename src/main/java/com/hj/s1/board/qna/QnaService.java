package com.hj.s1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	@Autowired
	private QnaRepository qnaRepository;
	
	pu
	
	public QnaVO boardWrite(QnaVO qnaVO)throws Exception{
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		return qnaRepository.save(qnaVO);
	}

}
