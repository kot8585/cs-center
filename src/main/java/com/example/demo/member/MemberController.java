package com.example.demo.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:/member/main";
	}
	
	@RequestMapping("/member/main")
	public void main() {
	}
	

	@RequestMapping("/member/joinForm")
	public void joinForm() {
	}
	
	@RequestMapping("/member/join")
	public String join(Member m) {
		service.addMember(m);
		return "member/loginForm";
	}
	
	@RequestMapping("/member/loginForm")
	public void loginForm() {
	}
	
	@RequestMapping("/member/login")
	public String login(Member m, HttpServletRequest req) {
		Member m2 = service.getMember(m.getId());
		if (m2 == null || !m2.getPassword().equals(m.getPassword())) {
			log.error("로그인 실패 : " + m.toString());
			return "member/loginForm";
		} else { // 로그인 성공시
			HttpSession session = req.getSession();
			session.setAttribute("id", m2.getId());
			return "/member/main";
		}
	}
	
	@RequestMapping("/member/findForm")
	public void findForm() {
		
	}
	
	@RequestMapping("/member/find")
	public ModelAndView find(@RequestParam("email")String email, @RequestParam("name")String name) {
		String result="";
		Member m = service.getIdPwd(email, name);
		ModelAndView mav = new ModelAndView("member/findResult");
		if(m.getId() == null) {
			result = "등록된 아이디가 이메일 또는 이름이 아닙니다.";
			mav.addObject("result", result);
		} else {
			mav.addObject("m", m);
		}
		return mav;
	}
	
	
	@RequestMapping(value="/member/editForm")
	public ModelAndView editForm(HttpServletRequest req) {
		HttpSession session = req.getSession();
		ModelAndView mav = new ModelAndView("/member/editForm");
		String id = (String)session.getAttribute("id");
		Member m= service.getMember(id);
		mav.addObject("m", m);
		return mav;
	}
	
	@RequestMapping(value="/member/edit")
	public String edit(HttpServletRequest req, Member m) {
		HttpSession session = req.getSession();
		service.editMember(m);
		return "/mypage/mypage";
	}
	
	@RequestMapping(value = "/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}

	@RequestMapping(value = "/member/out")
	public String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}
}
