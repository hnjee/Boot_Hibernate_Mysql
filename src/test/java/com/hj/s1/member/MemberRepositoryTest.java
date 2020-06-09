package com.hj.s1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hj.s1.member.memberFile.MemberFileVO;


@SpringBootTest
class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;
	
	//@Test
	void insertTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("Lee");
		memberVO.setPw("Lee");
		memberVO.setName("Lee");
		memberVO.setEmail("Lee@naver.com");
		memberVO.setPhone("01055555555");
		
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("Kim");
		memberVO2.setPw("Kim");
		memberVO2.setName("Kim");
		memberVO2.setEmail("Kim@naver.com");
		memberVO2.setPhone("01055555555");
		
		MemberVO memberVO3 = new MemberVO();
		memberVO2.setId("Park");
		memberVO2.setPw("Park");
		memberVO2.setName("Park");
		memberVO2.setEmail("Park@naver.com");
		memberVO2.setPhone("01055555555");
		
		MemberVO memberVO4 = new MemberVO();
		memberVO2.setId("Lim");
		memberVO2.setPw("Lim");
		memberVO2.setName("Lim");
		memberVO2.setEmail("Lim@naver.com");
		memberVO2.setPhone("01055555555");
		
		List<MemberVO> memberVOs = Arrays.asList(memberVO3,memberVO4);
		memberVOs = memberRepository.saveAll(memberVOs);
		
		assertNotNull(memberVOs);
	}
	
	//@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("hj");
		memberVO.setEmail("hj@naver.com");
		memberVO = memberRepository.save(memberVO);
		assertNotNull(memberVO);
	}
	
	//@Test
	void deleteTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("Lim");
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("Park");
		
		List<MemberVO> memberVOs = Arrays.asList(memberVO,memberVO2);
		memberRepository.deleteAll(memberVOs);
		
		assertNotNull(memberVOs);
	}
	
	//@Test
	void idCheck() {
		boolean check = memberRepository.existsById("Lee");
		System.out.println(check);
	}
	
	//@Test
	public void insertTest2() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("Lee11");
		memberVO.setPw("Lee11");
		memberVO.setName("Lee");
		memberVO.setAge(20);
		memberVO.setEmail("Lee@naver.com");
		memberVO.setPhone("01033222222");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO); 
		
		memberRepository.save(memberVO);
	}
	
	@Test 
	public void deleteTest2() {
		memberRepository.deleteById("iu33");
	}
}
