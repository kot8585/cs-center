package com.example.demo.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.Board;
import com.example.demo.reply.Reply;



@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	public static String basePath = "C:\\shopimg\\";
	
	
	@RequestMapping("/product/list")
	public ModelAndView List() {
		System.out.println("ProductController.List()");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductAll();
		
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list", list);
		return mav;
	}
		
		
	}
	
	
	

