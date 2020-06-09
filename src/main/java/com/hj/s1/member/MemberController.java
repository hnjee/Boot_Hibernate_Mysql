package com.hj.s1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/**/")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv) throws Exception{
		mv.addObject("memberVO", new MemberVO());
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult br, RedirectAttributes rd, ModelAndView mv) throws Exception{
		if(memberService.memberError(memberVO, br)) {
			mv.setViewName("member/memberJoin");
		}else {
			memberVO = memberService.memberJoin(memberVO);
			rd.addFlashAttribute("result", "회원가입 성공");
			mv.setViewName("redirect:../");
		}	
		return mv;
	}
	
	@GetMapping("memberLogin")
	public ModelAndView memberLogin(ModelAndView mv) throws Exception{
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, ModelAndView mv, RedirectAttributes rd, HttpSession session) throws Exception{
		memberVO = memberService.memberLogin(memberVO);
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			rd.addFlashAttribute("result", "로그인 성공");
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("result","로그인 실패");
			mv.addObject("path", "member/memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView memberLogout(ModelAndView mv, HttpSession session, RedirectAttributes rd) throws Exception{
		session.invalidate();
		rd.addFlashAttribute("result", "로그아웃 성공");
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView memberPage(ModelAndView mv) throws Exception{
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@GetMapping("memberUpdate")
	public ModelAndView memberUpdate(ModelAndView mv) throws Exception{
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, ModelAndView mv, RedirectAttributes rd, HttpSession session) throws Exception{
		memberVO = memberService.memberJoin(memberVO);
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			mv.addObject("result","수정 성공");
			mv.addObject("path", "member/memberPage");
			mv.setViewName("common/result");
		
		} else {
			mv.addObject("result","수정 실패");
			mv.addObject("path", "member/memberUpdate");
			mv.setViewName("common/result");
		}
		return mv;
	}
	@GetMapping("memberDelete")
	public ModelAndView memberDelete(ModelAndView mv, HttpSession session, RedirectAttributes rd) throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberService.memberDelete(memberVO);
		rd.addFlashAttribute("result", "탈퇴 완료");
		mv.setViewName("redirect:../");
		return mv;
	}
}
