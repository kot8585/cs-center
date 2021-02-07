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
		//  java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique constraint (HR.SYS_C007378) violated : 기본 키 두 개 생성 https://moonong.tistory.com/48 
		String m_id = req.getParameter("m_id");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		int cost = Integer.parseInt(req.getParameter("cost"));
		Shoppingcart cart = new Shoppingcart();
		cart.setM_id(m_id);
		cart.setP_num(p_num);
		cart.setCost(cost);
		service.addCart(cart);
	}
}
