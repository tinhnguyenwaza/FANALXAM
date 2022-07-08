package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.batch.Main;

import Bean.Product;
import context.JDBC;
import controller.Cart;

public class orderDAO {
	Connection conn = null; 
	 // use PreparedStatement  để có thể truyển thâm số vào jQuery Sql  (?, ?, ?)
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void submitDatebase(String userMAil, int orderId, String date, String code, String address) {
	
		String sql = "insert into Orders(user_mail ,order_id, order_date, order_discount_code, order_address)"
				+ "VALUES (?, ?, ?, ?, ?);";
	try {
		conn = JDBC.getJDBCCon1();
		ps = conn.prepareStatement(sql);
		ps.setString(1,  userMAil);
		ps.setInt(2,  orderId);		
		ps.setString(3,  date);
		ps.setString(4,  code);
		ps.setString(5,  address);
        ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void submiDataBill(int orderId, int product_id,int amount_product, float d) {
		
		String sql = "insert into Orders_detail(order_id , product_id, amount_product, price_product)"
				+ "VALUES (?, ?, ?, ?);";
	try {
		conn = JDBC.getJDBCCon1();
		ps = conn.prepareStatement(sql);
		ps.setInt(1,  orderId);
		ps.setInt(2, product_id);		
		ps.setInt(3, amount_product);
		ps.setFloat(4, d);
        ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
}	
    

