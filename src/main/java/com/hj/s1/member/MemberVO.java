package com.hj.s1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name="member")
public class MemberVO {
	@Id //primary key
	@Size(max=10, min=4)
	private String id;
	
	@Size(max=10, min=4)
	@Column //일반 컬럼명 
	private String pw;

	@Transient //테이블에서 제외해라 
	private String pwChk;
	
	@NotEmpty
	@Column
	private String name;
	
	@Email
	@NotEmpty
	@Column
	private String email;
	
	@NotEmpty
	@Column
	private String phone;
	
	@Range(min=0, max=200)
	@NotNull
	@Column
	private Integer age;
	
	//mappedBy="join하는 Entity에 선언된 자기 자신의 Entity변수명"
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	private MemberFileVO memberFileVO;
}
