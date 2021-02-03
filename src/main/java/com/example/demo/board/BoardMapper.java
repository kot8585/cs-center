package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	void insert(Board b);
	Board select(int num);
	List selectById(String id);
	List selectAll();
	void delete(int num);
	void update(Board b);
	ArrayList<Board> getMyQuestionListById(String id);
	
}	
