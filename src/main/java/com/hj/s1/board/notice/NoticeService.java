package com.hj.s1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.hj.s1.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;

	
	
	//List
	public List<NoticeVO> selectList(Pager pager) throws Exception{
		pager.makeRow();
		//PageRequest.of(page, size, Sort, column)
		Pageable pageable = PageRequest.of((int)pager.getStartRow(), (int)pager.getPerPage(), Sort.Direction.DESC, "num");
		List<NoticeVO> ar = new ArrayList<NoticeVO>();
		
		if(pager.getKind().equals("writer")) {
			pager.makePage(noticeRepository.countByWriterContaining(pager.getSearch()));
			ar = noticeRepository.findByWriterContaining(pager.getSearch(), pageable);
		} else if(pager.getKind().equals("contents")) {
			pager.makePage(noticeRepository.countByContentsContaining(pager.getSearch()));
			ar = noticeRepository.findByContentsContaining(pager.getSearch(), pageable);
		} else {
			pager.makePage(noticeRepository.countByTitleContaining(pager.getSearch()));
			ar = noticeRepository.findByTitleContaining(pager.getSearch(), pageable);
		}
	    return ar;
		
//		pager.makeRow();
//		long total = noticeRepository.count();
//		pager.makePage(total);
//		return noticeRepository.findAll();
	}
	
	//Select
	public NoticeVO selectOne(NoticeVO noticeVO) throws Exception{
		Optional<NoticeVO> opt = noticeRepository.findById(noticeVO.getNum());
		return opt.get();
	}
	
	//Write
	public NoticeVO insert(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		
		return noticeRepository.save(noticeVO);
	}
	
	//Update
	public NoticeVO update(NoticeVO noticeVO) throws Exception{
		return noticeRepository.save(noticeVO);
	}

	//Delete
	public void delete(NoticeVO noticeVO) throws Exception{
		noticeRepository.deleteById(noticeVO.getNum());
	}
}
