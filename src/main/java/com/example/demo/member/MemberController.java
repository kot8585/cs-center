package com.example.demo.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/")
	public String root() throws Exception {
		System.out.println("MemberController.root()");
		return "redirect:/member/main";
	}
	
	@RequestMapping("/member/main")
	public void main() {
		System.out.println("MemberController.main()");
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
		System.out.println(m2.getId());
		if (m2 == null || !m2.getPassword().equals(m.getPassword())) {
			System.out.println("로그인 실패");
			return "member/loginForm";
		} else { // 로그인 성공시
			HttpSession session = req.getSession();
			session.setAttribute("id", m2.getId());
	
			return "/mypage/mypage";
		}
	}
	@RequestMapping("/member/findForm")
	public void findForm() {
		
	}
	
	@RequestMapping("/member/find")
	public ModelAndView find(@RequestParam("email")String email, @RequestParam("name")String name) {
		System.out.println(email);
		System.out.println(name);
		
		String result="";
		Member m = service.getIdPwd(email, name);
		System.out.println(m.getId());
		System.out.println(m.getPassword());
		ModelAndView mav = new ModelAndView("member/findResult");
		if(m == null) {
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
		System.out.println("MemController.logout()");
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}

	@RequestMapping(value = "/member/out")
	public String out(HttpServletRequest req) {
		System.out.println("MemController.out()");
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}
}
