package com.hj.s1.board.qna;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hj.s1.board.notice.NoticeVO;

import lombok.Data;

@Data
@Entity
@Table(name="qnaFile")
public class QnaFileVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileNum;
	private String fileName;
	private String oriName;
	
	@ManyToOne
	@JoinColumn(name="num")
	private QnaVO qnaVO;
}
