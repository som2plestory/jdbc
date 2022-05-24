package com.javaex.ex01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete {
	
	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
	
		try {
	
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
	
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
	
			// 3. SQL문 준비 / 바인딩 / 실행
			
			// SQL문 준비
			String query = "";
			query += " delete from author ";
			query += " where author_id = ? ";
					
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 5);	// 앞은 순서, 뒤는 입력값
			System.out.println(query);
			
			//실행
			int count = pstmt.executeUpdate();		// 쿼리문실행 --> 성공개수 리턴
			
	
			// 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");
	
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
