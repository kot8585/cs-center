package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.reply.RepService;
import com.example.demo.reply.Reply;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private RepService repService;
	
	
	/*게시물 리스트 뽑기
	 * author : 문효정
	 */
	@RequestMapping("/board/list")
	public ModelAndView list() {
		System.out.println("/board/list()");
		ArrayList<Board> list = (ArrayList<Board>) service.getAllBoard();
		for(int i=0; i<list.size(); i++) {
			//해당 게시물의 댓글 가져오기
			Board b = list.get(i);
			ArrayList<Reply> reps = (ArrayList<Reply>) repService.getReplyByBoardNum(b.getNum());
			b.setReps(reps);
		}
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/board/writeForm")
	public void writeForm() {
		System.out.println("/board/writeForm");
	}
}
