package com.example.demo.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.product.Product;
import com.example.demo.product.ProductService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@Autowired
	private ProductService pservice;
	
	  @RequestMapping("/review/reviewForm")
	   public ModelAndView reviewForm(HttpServletRequest req, @RequestParam("pnum") int pnum) {
	      HttpSession session = req.getSession();
	      String id = (String) session.getAttribute("id");
	      Product p = pservice.getProductByNum(pnum);
	      ModelAndView mav = new ModelAndView("review/reviewForm");
		  mav.addObject("p", p);
		  return mav;
	   
	   }
	
	
	
	
	@RequestMapping("/review/write")
	public String write(Review r, HttpServletRequest req) {
		service.addReview(r);
		return "redirect:/member/main";
	}
	
	@RequestMapping("/review/reviewlist")
	   public ModelAndView viewlist() {
	      ArrayList<Review> reviewlist = (ArrayList<Review>) service.getAll();
	      ModelAndView mav = new ModelAndView("review/reviewlist");
	      mav.addObject("list", reviewlist);
	      return mav;
	   }
	
	@RequestMapping("/review/reviewDetail")
	public void detail() {

	}
	
}


