package com.hj.s1.board.qna;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hj.s1.board.BoardFileVO;
import com.hj.s1.board.notice.NoticeVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name="qnaFile")
public class QnaFileVO extends BoardFileVO{
	@ManyToOne
	@JoinColumn(name="num")
	private QnaVO qnaVO;
}
