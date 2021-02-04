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
		System.out.println("OrderController.orderForm()");
		ModelAndView mav = new ModelAndView("order/orderForm");
		System.out.println(o.getP_num());
		Product p = productService.getProductByNum(o.getP_num());
		System.out.println("product : "+p.toString());
		System.out.println(o.getM_id());
		Member m = memberService.getMember(o.getM_id()); 
		System.out.println("member :" + m.toString());
		o.setP(p);
		o.setM(m);
		mav.addObject("order", o);
		return mav;
	}
	
	@RequestMapping("/order/order")
	public String order(Order o) {
		System.out.println("OrderController.order()");
		System.out.println(o.toString());
		orderService.addOrder(o);
		return "/member/main";
	}
	
}
