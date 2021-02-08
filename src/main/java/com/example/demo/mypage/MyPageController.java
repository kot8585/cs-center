package com.example.demo.mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.Board;
import com.example.demo.board.BoardService;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import com.example.demo.reply.RepService;
import com.example.demo.reply.Reply;
import com.example.demo.shoppingcart.CartService;
import com.example.demo.shoppingcart.Shoppingcart;

@Controller
public class MyPageController {

	// shoppingcart 관련 service
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private RepService repService;
	
	@RequestMapping("/mypage/mypage")
	public void mypage() {
	}
	
	@RequestMapping("/mypage/shoppingcartForm")
	public ModelAndView shoppingcartForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("mypage/shoppingcartForm");
		HttpSession session = req.getSession(false);
		// 로그인 미구현		
		String id = (String) session.getAttribute("id");
		// 추후 로그인 구현 후 세션의 id 값이 null이거나 공백이면 login.jsp 로 이동하게끔 설계
		ArrayList<Shoppingcart> list = cartService.getShoppingcartById(id);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/mypage/myOrderForm")
	public ModelAndView myOrderForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("mypage/myOrderForm");
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		ArrayList<Order> list = orderService.getMyOrderListById(id);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/mypage/myQuestionForm")
	public ModelAndView myQuestionForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("mypage/myQuestionForm");
		
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");

		
		ArrayList<Board> list = boardService.getMyQuestionListById(id);
		for (Board board : list) {
			ArrayList<Reply> reply = repService.getReplyByBoardNum(board.getNum());
			board.setReps(reply);
		}
		
		mav.addObject("list", list);
		return mav;
	}
	
}
