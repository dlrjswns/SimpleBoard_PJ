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
		conn = JDBCUtil.connect();
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
		return datas;
	}
	public BoardVO selectOne(BoardVO vo) {
					// 인자를 int타입으로 고정 -> 유지보수 불리
					// title, content, writer, ... -> VO를 인자로 설정
		conn = JDBCUtil.connect();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	public boolean insert() {
		return true;
	}
	public boolean update() {
		return true;
	}
	public boolean delete() {
		return true;
	}
}
