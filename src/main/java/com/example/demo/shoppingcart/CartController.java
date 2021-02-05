package com.example.demo.shoppingcart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	@Autowired
	private CartService service;
	
	@RequestMapping("/cart/addCart")
	public void addCart(HttpServletRequest req) {
		System.out.println("CartController.addCart()");
		
		String m_id = req.getParameter("m_id");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		int cost = Integer.parseInt(req.getParameter("cost"));
		System.out.println(m_id);
		System.out.println(p_num);
		System.out.println(cost);
		Shoppingcart cart = new Shoppingcart();
		cart.setM_id(m_id);
		cart.setP_num(p_num);
		cart.setCost(cost);
		service.addCart(cart);
	}
}
