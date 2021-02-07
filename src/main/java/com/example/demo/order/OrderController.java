package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.product.Product;
import com.example.demo.product.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/order/orderForm")
	public ModelAndView orderForm(Order o) {
		ModelAndView mav = new ModelAndView("order/orderForm");
		Product p = productService.getProductByNum(o.getP_num());
		Member m = memberService.getMember(o.getM_id()); 
		o.setP(p);
		o.setM(m);
		mav.addObject("order", o);
		return mav;
	}
	
	@RequestMapping("/order/order")
	public String order(Order o) {
		orderService.addOrder(o);
		return "/member/main";
	}
	
}
