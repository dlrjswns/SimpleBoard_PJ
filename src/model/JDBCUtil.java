package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	 public static Connection connect() {
	      Connection conn= // ★
	         return conn;
	   }
	   public static void disconnect(PreparedStatement pstmt,Connection conn) {
	      try {
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
}
