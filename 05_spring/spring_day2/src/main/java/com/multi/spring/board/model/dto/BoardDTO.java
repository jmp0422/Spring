package com.multi.spring.board.model.dto;

public class BoardDTO {

	
	private int no; //null
	private String title; //null
	private String content; //null
	private String writer; //null
	
	
	
	public BoardDTO() {
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
	
	
}
