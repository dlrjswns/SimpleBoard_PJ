package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	// 1. DBMS와의 연동(JDBC) => 공통로직 : JDBCUtil클래스에서 불러와 사용
	// 2. 비즈니스 메서드(CRUD) => 각각의 DAO마다 사용하는 로직
	
	//-> CRUD 비즈니스 메서드
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql_selectAll = "select * from board order by bid desc";
	String sql_selectOne = "select * from board where bid = ?";
	public ArrayList<BoardVO> selectAll(){
//		JDBCUtil.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setBid(rs.getInt("bid"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				
				datas.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public BoardVO selectOne() {
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean insert() {
		
	}
	public boolean update() {
		
	}
	public boolean delete() {
		
	}
}
