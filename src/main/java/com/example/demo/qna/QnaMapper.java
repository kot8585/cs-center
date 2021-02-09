package com.example.demo.qna;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaMapper {

	void insert(Qna b);
	Qna select(int num);
	ArrayList<Qna> selectById(String id);
	List selectAll();
	void delete(int num);
	void update(Qna b);
	ArrayList<Qna> getMyQnaListById(String id);
	int getNum();
	String selectO_history(String writer);

}	
