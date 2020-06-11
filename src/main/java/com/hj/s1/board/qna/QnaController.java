package com.hj.s1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView boardList(@PageableDefault(size = 10, page = 0, direction=Direction.DESC, sort= {"num"}) Pageable pageable) throws Exception{
		ModelAndView mv = new ModelAndView();
		Page<QnaVO> page = qnaService.boardList(pageable);
		
//		System.out.println(page.getContent().size());	// 한 페이지에 나오는 VO수 
//		System.out.println(page.getSize());
//		System.out.println(page.getTotalElements()); 	// 총 VO 개수 
//		System.out.println(page.getTotalPages());		// 총 page 수
//		System.out.println(page.hasNext());				// 다음 페이지가 있는지 
//		System.out.println(page.hasPrevious());			// 이전 페이지가 있는지 
//		System.out.println("first: "+page.isFirst());	// 첫번째 페이지인지 
//		System.out.println("last: "+page.isLast());		// 마지막 페이지인지 
//		System.out.println("pageNumber: "+ page.getNumber());
		if(page.getNumber()>page.getTotalPages()-1) {
			mv.setViewName("redirect: /qnaList?page=0");
		} else {
			mv.setViewName("board/boardList");
		}
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
	public ModelAndView boardWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("boardVO", new QnaVO());
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaVO qnaVO, ModelAndView mv) throws Exception{
		qnaVO = qnaService.boardWrite(qnaVO);
		mv.setViewName("board/boardList");
		return mv;
	}
}
