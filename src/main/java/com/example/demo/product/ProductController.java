package com.example.demo.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	public static String basePath = "C:\\shopimg\\";
	
	
	@RequestMapping(value="/product/list")
	public ModelAndView List() {
		ModelAndView mav = new ModelAndView("product/list");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductAll();
		mav.addObject("list", list);
		System.out.println("ProductController.List()");
		return mav;
	}
	
	
	
}
