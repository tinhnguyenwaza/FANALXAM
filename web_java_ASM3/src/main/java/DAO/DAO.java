package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Bean.Product;
import context.JDBC;

public class DAO {
	Connection conn = null; 
	 // use PreparedStatement  để có thể truyển thâm số vào jQuery Sql  (?, ?, ?)
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct(){
		List<Product> List = new ArrayList<>();
		String sql = "SELECT * FROM shoppingdb.Products";
		try {
			
			conn = JDBC.getJDBCCon1();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				int Product_id = rs.getInt("product_id");
				String Product_name = rs.getString("product_name");
				String Product_des = rs.getString("product_des");
				float Product_price = rs.getFloat("product_price");
				String Product_img = rs.getString("product_img_source");
				String Product_type = rs.getString("product_type");
				String Product_brand = rs.getString("product_brand");
				
				
				List.add(new Product(
						Product_id,
						Product_name,
						Product_des, 
						Product_price,
						Product_img,
						Product_type,
						Product_brand));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List;
	}
	
}
