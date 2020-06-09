package com.hj.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public MemberVO memberJoin(MemberVO memberVO) throws Exception{
		return memberRepository.save(memberVO);
	}
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	public void memberDelete(MemberVO memberVO) throws Exception{
		memberRepository.deleteById(memberVO.getId());
	}
	
	//사용자정의 검증 메서드
	public boolean memberError (MemberVO memberVO, BindingResult br) throws Exception{
		boolean res = false; //에러없으면 false
		//1. 기본 제공 검증
		if(br.hasErrors()) {
			res = true;
		}
		
		//2. pw 일치 검증 
		if(!memberVO.getPw().equals(memberVO.getPwChk())){
			br.rejectValue("pwChk", "memberVO.password.notSame");
			res = true;
		}
		
		//3. 중복 id 검증
		boolean idChk = memberRepository.existsById(memberVO.getId());
		if(idChk) {
			br.rejectValue("id", "memberVO.id.same");
			res = true;
		}
		return res;
	}
}
