package com.example.demo.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	  @RequestMapping("/review/reviewForm")
	   public void reviewForm(HttpServletRequest req) {
	      HttpSession session = req.getSession();
	      String id = (String) session.getAttribute("id");
	      System.out.println("ReviewController.reviewForm()");
	      System.out.println(id);
	   }
	
	
	
	
	@RequestMapping("/review/write")
	public String write(Review r) {
		System.out.println("ReviewController.write()");
		service.addReview(r);
	
		return "redirect:/member/main";
		
	
		 
	}
	
}


