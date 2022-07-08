package context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Bean.Product;
import DAO.DAO;

public class textAccsecJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// text thử xem có kết nối được với datase
		
		
		
		DAO a = new DAO();
		
		List <Product> c = a.getAllProduct(); 
		
		for (Product product : c) {
			product.toString1();
		}
	}

}
