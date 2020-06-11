package com.hj.s1.board.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hj.s1.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="qna")
public class QnaVO extends BoardVO{
	@Column
	private Long ref;
	@Column
	private Long step;
	@Column
	private Long depth;
	
	//자기자신To상대 
	//mappedBy="변수명"
	@OneToMany(mappedBy="qnaVO", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<QnaFileVO> QnaFileVOs;
}
