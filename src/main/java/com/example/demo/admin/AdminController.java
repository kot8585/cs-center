package com.example.demo.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.Member;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/admin")
	public String admin_root() {
		System.out.println("AdminController.admin_root()");
		return "redirect:/admin/loginForm";
	}
	
	@RequestMapping("/admin/loginForm")
	public String admin_loginForm() {
		System.out.println("AdminController.admin_loginForm()");
		return "admin/adminLoginForm";
	}
	
	@RequestMapping("/admin/login")
	public String login(Admin ad, HttpServletRequest req) {
		System.out.println("AdminController.login()");
		Admin admin = adminService.getAdmin(ad.getId());
		System.out.println("admin ID : " + admin.getId());
		if (admin == null || !admin.getPassword().equals(ad.getPassword())) {
			System.out.println("로그인 실패");
			return "/admin/loginForm";
		} else { // 로그인 성공시
			HttpSession session = req.getSession();
			session.setAttribute("id", admin.getId());
			return "/admin/admin";
		}
	}
	
	@RequestMapping("/admin/orderList")
	public ModelAndView orderList(HttpServletRequest req) {
		System.out.println("AdminController.orderList()");
		ModelAndView mav = new ModelAndView("admin/orderList");
		ArrayList<Order> list = orderService.getAllOrderList();
		mav.addObject("list", list);
		return mav;
	}
}
