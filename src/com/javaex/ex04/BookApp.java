package com.javaex.ex04;

import java.util.List;

public class BookApp {
	
	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		
		BookVo vo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		BookVo vo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		BookVo vo03 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		BookVo vo04 = new BookVo("유시민의 글쓰기 특강", "생각의길", "2015-04-01", 3);
		BookVo vo05 = new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);
		BookVo vo06 = new BookVo("순정만화", "재미주의", "2011-08-03", 5);
		BookVo vo07 = new BookVo("오직두사람", "문학동네", "2017-05-04", 6);
		BookVo vo08 = new BookVo("26년", "재미주의", "2012-02-04", 5);
		
		bookDao.bookInsert(vo01);
		bookDao.bookInsert(vo02);
		bookDao.bookInsert(vo03);
		bookDao.bookInsert(vo04);
		bookDao.bookInsert(vo05);
		bookDao.bookInsert(vo06);
		bookDao.bookInsert(vo07);
		bookDao.bookInsert(vo08);
		
		BookVo uVo = new BookVo(4, "안녕하세요", "솜이플스토리", "2020-01-16", 3);
		bookDao.bookUpdate(uVo);
		
		List<BookVo> bookList = bookDao.bookSelect();
		for(BookVo bookVo:bookList) {
			bookVo.showList();
		}
		
		
		
	}
}
