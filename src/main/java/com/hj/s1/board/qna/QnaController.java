package com.hj.s1.board.qna;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.hj.s1.member.MemberVO;
import com.hj.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	@GetMapping("qnaList")
								//size=perPage, page=curPage(0부터시작), direction=정렬, sort={"정렬기준컬럼명"}
	public ModelAndView boardList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		Page<QnaVO> page = qnaService.boardList(pager);
		
//		System.out.println(page.getContent().size());	// 한 페이지에 나오는 VO수 
//		System.out.println(page.getSize());
//		System.out.println(page.getTotalElements()); 	// 총 VO 개수 
//		System.out.println(page.getTotalPages());		// 총 page 수
//		System.out.println(page.hasNext());				// 다음 페이지가 있는지 
//		System.out.println(page.hasPrevious());			// 이전 페이지가 있는지 
//		System.out.println("first: "+page.isFirst());	// 첫번째 페이지인지 
//		System.out.println("last: "+page.isLast());		// 마지막 페이지인지 
//		System.out.println("pageNumber: "+ page.getNumber());

		mv.setViewName("board/boardList");
		mv.addObject("pager", pager);
		mv.addObject("page", page);
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.boardSelect(qnaVO);
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView boardWrite(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");	
		mv.addObject("writer", memberVO.getId());
		mv.addObject("path", "Write");
		mv.addObject("boardVO", new QnaVO());
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaVO qnaVO, ModelAndView mv, MultipartFile[] files) throws Exception{
		qnaVO = qnaService.boardWrite(qnaVO, files);
		mv.setViewName("redirect:/qna/qnaList");
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView boardDelete(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = qnaService.boardDelete(qnaVO);
		if(result) {
			mv.addObject("result", "삭제 완료");
		} else {
			mv.addObject("result", "삭제 실패");
		}
		mv.addObject("path", "../qna/qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView boardUpdate(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.boardSelect(qnaVO);
		mv.addObject("vo", qnaVO);
		mv.addObject("path", "Update");
		mv.setViewName("board/boardWrite");
		return mv;
	} 
	
	@PostMapping("qnaUpdate")
	public ModelAndView boardUpdate(ModelAndView mv, QnaVO qnaVO, MultipartFile[] files)throws Exception{
		qnaService.boardUpdate(qnaVO, files);
		mv.setViewName("redirect:./qnaList");
		return mv;
	} 
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaVO qnaVO, HttpSession session)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		mv.addObject("writer", memberVO.getId());
		mv.addObject("path", "Reply");
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.boardReply(qnaVO);
		mv.setViewName("redirect:./qnaList");
		return mv;
	}
}
