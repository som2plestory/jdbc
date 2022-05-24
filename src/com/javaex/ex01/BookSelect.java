package com.javaex.ex01;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {
	
	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
	
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
	
			// 3. SQL문 준비 / 바인딩 / 실행
			
			// SQL문 준비
			String query = "";
			query += " select  	book_id, ";
			query += " 			title, ";
			query += " 			pubs, "; 
			query += " 			pub_date, "; 
			query += " 			author_id "; 
			query += " from book ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			rs = pstmt.executeQuery();		// 쿼리문실행 --> 성공개수 리턴
			
	
			// 4.결과처리
			while(rs.next()) {
				int bookId = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				Date pubDate = rs.getDate(4);
				int authorId = rs.getInt(5);
				System.out.println(bookId +", " + title +", " + pubs + ", " + pubDate + ", " + authorId);
			}
			
	
		} catch (ClassNotFoundException e) {
	
		System.out.println("error: 드라이버 로딩 실패 - " + e);
	
		} catch (SQLException e) {
	
		System.out.println("error:" + e);
	
		} finally {
	
		// 5. 자원정리
			try {
			
				/*
				if (rs != null) {
			
				rs.close();
			
				}
				*/
				if (pstmt != null) {
			
				pstmt.close();
			
				}
			
				if (conn != null) {
			
				conn.close();
			
				}
		
			} catch (SQLException e) {
		
			System.out.println("error:" + e);
		
			}
		
		}
		
	}
}
