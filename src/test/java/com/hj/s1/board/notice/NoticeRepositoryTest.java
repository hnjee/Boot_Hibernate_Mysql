package com.hj.s1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeRepositoryTest {
	@Autowired
	private NoticeRepository noticeRepository;
	private NoticeVO noticeVO;
	private List<NoticeFileVO> noticeFileVOs; 
	
	//@BeforeEach
	public void beforeEach() {
		noticeVO = new NoticeVO();
		noticeVO.setTitle("title");
		noticeVO.setWriter("writer");
		noticeVO.setContents("contents");
		List<NoticeFileVO> noticeFileVOs = new ArrayList<NoticeFileVO>();
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileName("fileName");
		noticeFileVO.setFileName("oriName");
		noticeFileVOs.add(noticeFileVO);
		
		NoticeFileVO noticeFileVO2 = new NoticeFileVO();
		noticeFileVO2.setFileName("fileName2");
		noticeFileVO2.setFileName("oriName2");
		noticeFileVOs.add(noticeFileVO2);
		
		noticeVO.setNoticeFileVOs(noticeFileVOs);
	}
	
	//insert
	//@Test
	public void insertTest()throws Exception{
		for(int i=0; i<100; i++) {
			noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setContents("contents"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO = noticeRepository.save(noticeVO);
		}
		
		assertNotNull(noticeVO);
	}
	
	//update
	//@Test
	public void updateTest()throws Exception{
		noticeVO.setNum(5);
		noticeVO.setTitle("update Title");
		noticeVO = noticeRepository.save(noticeVO);
		assertNotNull(noticeVO);
	}
	
	//delete
	//@Test
	public void deleteTest()throws Exception{
		noticeRepository.deleteById(2L);
		boolean check = noticeRepository.existsById(2L);
		assertEquals(false, check);
	}
	
	//selectList
	//@Test
	public void selectListTest()throws Exception{
		 List<NoticeVO> ar = noticeRepository.findAll();
		 for(NoticeVO noticeVO:ar) {
			 System.out.println(noticeVO.getTitle());
		 }
		 assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void selectOneTest()throws Exception{
		Optional<NoticeVO> opt = noticeRepository.findById(1L);
		noticeVO = opt.get();
		assertNotNull(noticeVO);
		System.out.println(noticeVO.getTitle());	
	}
	
	@Test
	public void customTest() {
		List<NoticeVO> ar = noticeRepository.findByTitleContainingOrderByNumDesc("2");
		for(NoticeVO noticeVO:ar) {
			System.out.println("Num : "+noticeVO.getTitle());
		}
	}
}
