package com.example.demo.reply;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Reply {
	private int num;
	private int board_num;
	private String writer;
	private String content;
	private Date r_date;
	private String path;
	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;

	public Reply() {
		super();
	}

	public Reply(int num, int board_num, String writer, String content, Date r_date, String path, MultipartFile file1,
			MultipartFile file2, MultipartFile file3) {
		super();
		this.num = num;
		this.board_num = board_num;
		this.writer = writer;
		this.content = content;
		this.r_date = r_date;
		this.path = path;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	@Override
	public String toString() {
		return "Reply [num=" + num + ", board_num=" + board_num + ", writer=" + writer + ", content=" + content
				+ ", r_date=" + r_date + ", path=" + path + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3
				+ "]";
	}

}