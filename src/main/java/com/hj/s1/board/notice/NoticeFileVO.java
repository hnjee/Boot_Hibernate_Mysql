package com.hj.s1.board.notice;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hj.s1.board.BoardFileVO;
import com.hj.s1.board.qna.QnaFileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name="noticeFile")
public class NoticeFileVO extends BoardFileVO{
	@ManyToOne
	@JoinColumn(name="num")
	private NoticeVO noticeVO; 
}
