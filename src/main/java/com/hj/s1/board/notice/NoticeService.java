package com.hj.s1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hj.s1.board.qna.QnaFileVO;
import com.hj.s1.board.qna.QnaVO;
import com.hj.s1.util.FileManager;
import com.hj.s1.util.FilePathGenerator;
import com.hj.s1.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.notice}")
	private String filePath;
	

	//List
	public Page<NoticeVO> selectList(Pager pager) throws Exception{
		pager.makeRow();
		Pageable pageable = PageRequest.of((int)pager.getStartRow(), (int)pager.getSize(), Sort.Direction.DESC, "num");
		Page<NoticeVO> page = null;
		if(pager.getKind().equals("title")) {
			page = noticeRepository.findByTitleContaining(pager.getSearch(), pageable);
		}else if(pager.getKind().equals("contents")) {
			page = noticeRepository.findByContentsContaining(pager.getSearch(), pageable);
		}else {
			page = noticeRepository.findByWriterContaining(pager.getSearch(), pageable);
		}
		pager.makePage(page.getTotalPages());
	
		return page;	
		//		pager.makeRow();
//		//PageRequest.of(page, size, Sort, column)
//		Pageable pageable = PageRequest.of((int)pager.getStartRow(), (int)pager.getSize(), Sort.Direction.DESC, "num");
//		List<NoticeVO> ar = new ArrayList<NoticeVO>();
//		
//		if(pager.getKind().equals("writer")) {
//			pager.makePage(noticeRepository.countByWriterContaining(pager.getSearch()));
//			ar = noticeRepository.findByWriterContaining(pager.getSearch(), pageable);
//		} else if(pager.getKind().equals("contents")) {
//			pager.makePage(noticeRepository.countByContentsContaining(pager.getSearch()));
//			ar = noticeRepository.findByContentsContaining(pager.getSearch(), pageable);
//		} else {
//			pager.makePage(noticeRepository.countByTitleContaining(pager.getSearch()));
//			ar = noticeRepository.findByTitleContaining(pager.getSearch(), pageable);
//		}
//	    return ar;
		
//		pager.makeRow();
//		long total = noticeRepository.count();
//		pager.makePage(total);
//		return noticeRepository.findAll();
	}
	
	//Select
	public NoticeVO selectOne(NoticeVO noticeVO) throws Exception{
		Optional<NoticeVO> opt = noticeRepository.findById(noticeVO.getNum());
		noticeVO = opt.get();
		noticeVO.setHit(noticeVO.getHit()+1);
		noticeVO = noticeRepository.save(noticeVO);
		return noticeVO;
	}
	
	//Write
	public NoticeVO insert(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		List<NoticeFileVO> list = new ArrayList<NoticeFileVO>();
		
		//저장할 폴더 경로
		File file = filePathGenerator.getUseResourceLoader(filePath);
		
		//HDD에 저장
		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize()<=0) {
				continue;
			}else {
				NoticeFileVO noticeFileVO = new NoticeFileVO();
				String fileName = fileManager.saveFileCopy(multipartFile, file);
				noticeFileVO.setFileName(fileName);
				noticeFileVO.setOriName(multipartFile.getOriginalFilename());
				noticeFileVO.setNoticeVO(noticeVO);
				list.add(noticeFileVO);
			}
		}
		noticeVO.setNoticeFileVOs(list);
		noticeVO=noticeRepository.save(noticeVO);
		
		
		noticeVO.setHit(0L);
		return noticeRepository.save(noticeVO);
	
		
	}
	
	//Update
	public NoticeVO update(NoticeVO noticeVO) throws Exception{
		System.out.println("************"+noticeVO.getHit());
		return noticeRepository.save(noticeVO);
	}

	//Delete
	public void delete(NoticeVO noticeVO) throws Exception{
		noticeRepository.deleteById(noticeVO.getNum());
	}
}
