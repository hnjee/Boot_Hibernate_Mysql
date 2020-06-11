package com.hj.s1.board.qna;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class QnaService {
	@Autowired
	private QnaRepository qnaRepository;
	
	public Page<QnaVO> boardList(Pageable pageable) throws Exception{
		return qnaRepository.findAll(pageable);
	}
	
	public QnaVO boardSelect(QnaVO qnaVO) throws Exception{
		Optional<QnaVO>	opt = qnaRepository.findById(qnaVO.getNum());
		return opt.get();
	}
	
	public QnaVO boardWrite(QnaVO qnaVO)throws Exception{
		qnaVO.setRef(0L);
		qnaVO.setStep(0L);
		qnaVO.setDepth(0L);
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		return qnaRepository.save(qnaVO);
	}

}
