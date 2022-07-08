package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import context.JDBC;

public class autoIdOder {
	
	Connection conn = null; 
	 // use PreparedStatement  để có thể truyển thâm số vào jQuery Sql  (?, ?, ?)
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// return valua autoId_oder 
	public int getId_oder(){
		int a = 0;
		String sql = "SELECT * FROM shoppingdb.autoId_oder";
		
		try {
			
			conn = JDBC.getJDBCCon1();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
			 a = rs.getInt("autoid_oder");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public void deleteAutoIdOder() {
		
		String sql = "DELETE FROM autoId_oder WHERE autoid_oder != 0;";
	try {
		conn = JDBC.getJDBCCon1();
		ps = conn.prepareStatement(sql);
		
		
		 int  i = ps.executeUpdate();
		System.out.println(i);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	public void setAutoIdOder(int a) {
		
	String sql = "INSERT INTO autoId_oder(autoid_oder)"
				+ "VALUES (?);";
	try {
		conn = JDBC.getJDBCCon1();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, a);
		
		
		 int  i = ps.executeUpdate();
		System.out.println(i);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
}	
	
	
	

