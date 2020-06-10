package com.hj.s1.board.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.hj.s1.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="notice")
@DynamicUpdate(value = true)
public class NoticeVO extends BoardVO{
	
	//자기자신To상대
	@OneToMany(mappedBy="noticeVO", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<NoticeFileVO> noticeFileVOs;
}
