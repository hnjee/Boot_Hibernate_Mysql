package com.hj.s1.board.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hj.s1.util.Pager;

@Controller
@RequestMapping("/notice/**/")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	//selectList
	@GetMapping("noticeList")
	//@PageableDefault(page = 0, size = 10, sort = {"num"}, direction = Direction.DESC) Pageable pageable
	public ModelAndView selectList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.selectList(pager);
		//									(page, size, Sort, column)
		//Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "num");
	
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList"); //../WEB-INF/views/board/boardSelect.jsp
		return mv;
	}
	
	//selectOne
	@GetMapping("noticeSelect")
	public ModelAndView selectOne(NoticeVO noticeVO, ModelAndView mv) throws Exception{
		noticeVO = noticeService.selectOne(noticeVO);
		mv.addObject("vo", noticeVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	//write
	@GetMapping("noticeWrite")
	public ModelAndView insert(ModelAndView mv) throws Exception{
		mv.addObject("path", "Write");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView insert(ModelAndView mv, NoticeVO noticeVO, MultipartFile[] files) throws Exception{	
		noticeVO = noticeService.insert(noticeVO, files);
		mv.setViewName("redirect:notice/noticeList");
		return mv;
	}
	
	//update
	@GetMapping("noticeUpdate")
	public ModelAndView update(ModelAndView mv, NoticeVO noticeVO) throws Exception{
		noticeVO = noticeService.selectOne(noticeVO);
		mv.addObject("path", "Update");
		mv.addObject("vo", noticeVO);
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView update2(ModelAndView mv, NoticeVO noticeVO) throws Exception{
		noticeVO = noticeService.update(noticeVO);
		mv.setViewName("redirect:notice/noticeList");
		return mv;
	}
	
	//delete
	@GetMapping("noticeDelete")
	public ModelAndView delete(ModelAndView mv, NoticeVO noticeVO) throws Exception{
		noticeService.delete(noticeVO);
		mv.setViewName("redirect:notice/noticeList");
		return mv;
	}
}
