package com.example.demo.reply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReplyController {
	@Autowired
	private RepService service;
	
	@RequestMapping("/rep/write")
	public String write(Reply r) {
		System.out.println("ReplyController.write()");
		service.addReply(r);
		return "redirect:/rep/list?board_num="+r.getBoard_num();
	}
	
	@RequestMapping(value="/rep/list")
	public ModelAndView list(@RequestParam(value="board_num")int board_num){
		System.out.println("ReplyController.list()");
		ArrayList<Reply> list = 
				(ArrayList<Reply>) service.getReplyByBoardNum(board_num);
		ModelAndView mav = new ModelAndView("img/listRep");
		mav.addObject("list", list);
		return mav;
	}
}
