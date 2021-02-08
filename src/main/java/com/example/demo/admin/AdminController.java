package com.example.demo.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.Board;
import com.example.demo.board.BoardService;
import com.example.demo.member.Member;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import com.example.demo.product.Product;
import com.example.demo.product.ProductService;
import com.example.demo.reply.Reply;

@Controller
public class AdminController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static String basePath = "C:\\shopimg\\";
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/admin")
	public String admin_root() {
		return "redirect:/admin/loginForm";
	}
	
	@RequestMapping("/admin/loginForm")
	public String admin_loginForm() {
		return "admin/adminLoginForm";
	}
	
	@RequestMapping("/admin/login")
	public String login(Admin ad, HttpServletRequest req) {
		Admin admin = adminService.getAdmin(ad.getId());
		if (admin == null || !admin.getPassword().equals(ad.getPassword())) {
			log.error("로그인 실패 : " + ad.toString());
			return "/admin/loginForm";
		} else { // 로그인 성공시
			HttpSession session = req.getSession();
			session.setAttribute("id", admin.getId());
			return "/admin/admin";
		}
	}
	
	@RequestMapping("/admin/orderList")
	public ModelAndView orderList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/orderList");
		ArrayList<Order> list = orderService.getAllOrderList();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/admin/productList")
	public ModelAndView productList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/productList");
		ArrayList<Product> list = (ArrayList<Product>) productService.getProductAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/admin/boardList")
	public ModelAndView boardList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/boardList");
		ArrayList<Board> list = (ArrayList<Board>) boardService.getAllBoard();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/admin/write")
	public String writeForm(HttpServletRequest req) {
		return "/admin/writeForm";
	}
	
	@PostMapping("/admin/write")
	public String write(Product p) {
		int num = productService.getNum();
		p.setNum(num);
		saveImg(num, p.getFile1());
		saveImg(num, p.getFile2());
		saveImg(num, p.getFile3());
		productService.addProduct(p);
		return "/admin/admin";
	}
	
	public void saveImg(int num, MultipartFile file) { //이미지 저장하기
		String fileName = file.getOriginalFilename();
		if(fileName != null && !fileName.equals("")) {
			File dir = new File(basePath + num);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File f = new File(basePath + num + "\\" + fileName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/admin/writeBoard")
	public void writeForm() {
	}
	
	@PostMapping("/admin/writeBoard")
	public String write(Board b) {
		int num = boardService.getNum();
		b.setNum(num);
		saveImg(num, b.getFile1());
		saveImg(num, b.getFile2());
		saveImg(num, b.getFile3());
		boardService.addBoard(b);
		return "/admin/admin";
	}
	
	
	@RequestMapping("/admin/detail")
	public ModelAndView detail(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView("admin/detail");
	    Product p = productService.getProductByNum(num);
	      
	    String path = basePath + p.getNum() + "\\";
	    File imgDir = new File(path);
	    if(imgDir.exists()) {
	       String[] files = imgDir.list();
	       for(int j = 0; j < files.length; j++) {
	          mav.addObject("file" + j, files[j]);
	       }
	    }
	      
	    mav.addObject("p", p);
	    return mav;
	}
	
	@RequestMapping("/admin/edit")
	public String edit(Product p) {
		productService.editProduct(p);
		return "/admin/admin";
	}
	
	@RequestMapping("/admin/boardDetail")
	public ModelAndView boardDetail(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView("admin/boardDetail");
		Board b = boardService.getBoardByNum(num);
		
		String path = basePath + b.getNum() + "\\";
		File imgDir = new File(path);
		if(imgDir.exists()) {
			String[] files  = imgDir.list();
			for (int j = 0; j < files.length; j++) {
				mav.addObject("file" + j, files[j]); 
			}
			b.setPath(files[0]);
		}
		mav.addObject("b", b);
		return mav;
	}
}
