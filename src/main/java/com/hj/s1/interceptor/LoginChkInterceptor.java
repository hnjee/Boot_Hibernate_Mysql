package com.hj.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hj.s1.member.MemberVO;

@Component
public class LoginChkInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//select, write : 회원만 접근 가능 
		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO!=null) {
			check=true;
		}else {
			request.setAttribute("path", "../member/memberLogin");
			request.setAttribute("result", "로그인하세요.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
}
