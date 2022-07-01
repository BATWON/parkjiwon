package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

public class BooksDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@183.98.140.90:1521:XE";	// 3306(MySQL,MariaDB), 1433(MS-SQL)
	
	// 싱글턴 생성
	private static BooksDAO dao;	// static 공간은 메모리 1개 생성
	
	// 드라이버 등록 (생성자에서 처리 => 드라이버, 서버연결, 배치, 멤버변수 초기화)
	// 웹 => 1) 쿠키 읽기(자동 로그인)
	public BooksDAO() {
		try {
			// 클래스 등록 => 패키지명.클래스명
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 스프링은 클래스 관리자 (생성~소멸) => 컨테이너 (DI)
			// INDEX => Annotation
		} catch (Exception ex) {}
	}
	
	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception ex) {}
	}
	// 닫기
	public void disConnection() {
		try {
			if (ps!=null) ps.close();
			if (conn!=null) conn.close();
		} catch (Exception ex) {}
	}
	
	// 싱글턴
	public static BooksDAO newInstance() {
		if (dao==null)
			dao = new BooksDAO();
		return dao;
	}
	
	// 페이징 
	// 자바
	public List<BooksVO> booksListData(int page) {
		List<BooksVO> list = new ArrayList<BooksVO>();
		long start = System.currentTimeMillis();

		try {
			getConnection();
			String sql = "SELECT no, title "
					+"FROM books "
					+"ORDER BY no ASC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i=0;	// 10개씩 나눠주는 변수
			int j=0; 	// while문 횟수
			int rowSize=10;	// 개수
			int pagecnt=(page*rowSize)-rowSize;	// 시작 위치
			
			while (rs.next()) {
				if (i<rowSize && j>=pagecnt) {
					BooksVO vo = new BooksVO();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					list.add(vo);
					i++;
				}
				j++;
			}
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start));
		
		return list;
	}
	
	public int booksTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/10.0) FROM books";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return total;
	}
	
	// 인라인뷰
	// 1. 페이징, 원하는 개수만큼 자르기
	public List<BooksVO> booksListData2(int page) {
		List<BooksVO> list = new ArrayList<BooksVO>();
		long s = System.currentTimeMillis();
		
		try {
			getConnection();
			String sql = "SELECT no, title, num "
					+"FROM (SELECT no, title, rownum as num "
					+"FROM (SELECT no, title "
					+"FROM books ORDER BY no ASC)) "
					+"WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int rowSize = 10;
			int start = (page*rowSize)-(rowSize-1);	// 첫번째 ?
			int end = page*rowSize;	// 두번째 ?
			// 1 page => 1~10      2 page => 11~20
			// 자바는 0부터=>rowSize, 오라클(rownum)은 1부터=>rowSize-1, MySQL은 0부터
			ps.setInt(1, start);	// 첫번째 ? start
			ps.setInt(2, end);		// 두번째 ? end
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
					BooksVO vo = new BooksVO();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					
					list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		long e = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(e-s));
		
		return list;
	}
}














