package com.example.demo.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.reply.RepService;
import com.example.demo.reply.Reply;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private RepService repService;
	
	public static String basePath = "C:\\shopimg\\";
	/*게시물 리스트 뽑기
	 * author : 문효정
	 */
	@RequestMapping("/board/list")
	public ModelAndView list() {
		System.out.println("/board/list()");
		ArrayList<Board> list = (ArrayList<Board>) service.getAllBoard();
		//for(int i=0; i<list.size(); i++) {
		//	//해당 게시물의 댓글 가져오기
		//	Board b = list.get(i);
		//	ArrayList<Reply> reps = (ArrayList<Reply>) repService.getReplyByBoardNum(b.getNum());
		//	b.setReps(reps);
		//}
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/board/writeForm")
	public void writeForm() {
		System.out.println("/board/writeForm");
	}
	
	@PostMapping("/board/write")
	public String write(Board b) {
		System.out.println("/board/write");
		int num = service.getNum();
		b.setNum(num);
		saveImg(num, b.getFile1());
		saveImg(num, b.getFile2());
		saveImg(num, b.getFile3());
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	public void saveImg(int num, MultipartFile file) { //이미지 저장하기
		System.out.println("BoardController.saveImg()");
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
	
	@RequestMapping("/board/detail")
	public ModelAndView detail(@RequestParam int num) {
		System.out.println("/board/detail");
		ModelAndView mav = new ModelAndView("board/detail");
		Board b = service.getBoardByNum(num);
		String path = basePath + b.getNum() + "\\";
		File imgDir = new File(path);
		if(imgDir.exists()) {
			String[] files  = imgDir.list();
			for (int j = 0; j < files.length; j++) {
				mav.addObject("file" + j, files[j]);
			}
		}
		mav.addObject("b", b);
		return mav;
	}
}
