package com.example.demo.product;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	public static String basePath = "C:\\shopimg\\";
	
	@RequestMapping("/product/list")
	public ModelAndView List() {
		System.out.println("ProductController.List()");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductAll();
		System.out.println(list.toString());
		ModelAndView mav = new ModelAndView("product/list");
		mav.addObject("list", list);
		 for (int i = 0; i < list.size(); i++) {
	         String path = basePath + list.get(i).getNum() + "\\";
	         File imgDir = new File(path);   
	         String[] files = imgDir.list();
	         if(imgDir.exists()) {
	            for(int j = 0; j < files.length; j++) {
	               mav.addObject("file" + j, files[j]);
	            }
	         }
	      }
		return mav;
	}
		
	@RequestMapping("/product/detail")
	public ModelAndView detail(@RequestParam(value = "num") int num) {
		ModelAndView mav = new ModelAndView("product/detail");
		Product p = service.getProductByNum(num);
		System.out.println("ProductController.detail()");
		String path = basePath + p.getNum() + "\\";
		File imgDir = new File(path);
		if (imgDir.exists()) {
			String[] files = imgDir.list();
			for (int j = 0; j < files.length; j++) {
				mav.addObject("file" + j, files[j]);
				// "file0=j", file0.jpg
			}
		}
		mav.addObject("p", p);
		return mav;
	}
	
	@RequestMapping("/product/img")
	public ResponseEntity<byte []> getImg(String fname, int num) {
		System.out.println("ProductController.getImg()");
		String path = basePath + num + "\\" + fname;
		File f = new File(path);
		HttpHeaders header = new HttpHeaders();
		ResponseEntity<byte []> result = null;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<>
			(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
	
	
	

