package com.hj.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hj.s1.board.qna.QnaRepository;
import com.hj.s1.board.qna.QnaVO;
import com.hj.s1.member.MemberVO;

@Component
public class WriterChkInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private QnaRepository qnaRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		long num = Long.parseLong(request.getParameter("num"));
		QnaVO qnaVO = new QnaVO();
		qnaVO.setNum(num);
		qnaVO = qnaRepository.findById(num).get();
		
		if(qnaVO.getWriter().equals(memberVO.getId())) {
			check=true;
		} else {
			request.setAttribute("path", "../qna/qnaList");
			request.setAttribute("result", "작성자가 아닙니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
}
