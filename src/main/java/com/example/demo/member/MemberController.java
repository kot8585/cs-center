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
	
	/**
	 * findForm.jsp로 이동하기 위한 메소드
	 */
	@RequestMapping("/member/findForm")
	public void findForm() {
		
	}
	
	/**
	 * 
	 * @param email 회원정보를 찾기 위해 입력 받은 email
	 * @param name 회원정보를 찾기 위해 입력 받은 name
	 * @return 회원찾기 폼에서 입력받은 정보로 회원정보를 찾아 findResult.jsp로 전달
	 */
	@RequestMapping("/member/find")
	public ModelAndView find(@RequestParam("email")String email, @RequestParam("name")String name) {
		// 폼에서 입력받은 email과 name을 통해 DB에서 Id와 Pwd를 불러와 객체에 해당 정보를 저장한다.
		Member m = service.getIdPwd(email, name);
	
		// 입력 받은 정보와 DB의 정보를 매칭하여 일치하지 않다면 경고 메시지를 findResult.jsp에 보내고, 일치하면 해당 정보를 findResult.jsp에 보낸다.
		ModelAndView mav = new ModelAndView("member/findResult");
		String result="";
		if(m == null) {
			result = "이메일 또는 이름이 등록되지 않았습니다.";
			mav.setViewName("member/failResult");
			mav.addObject("result", result);
			System.out.println(result);
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
