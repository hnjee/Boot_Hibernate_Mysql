package com.hj.s1.board;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BoardFileVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileNum;
	@Column
	private String fileName;
	@Column
	private String oriName;
}
