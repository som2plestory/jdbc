package com.javaex.ex02;

public class BookVo extends AuthorVo{
	
	//필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	
	
	//생성자
	public BookVo() {
		super();
	}

	public BookVo(int bookId, String title, String pubs, String pubDate, String authorName) {
		super(authorName);
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	
	//메소드-gs
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	

	
	//메소드-일반
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate + "]";
	}

}
