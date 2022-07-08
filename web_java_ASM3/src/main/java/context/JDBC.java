package context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {

		public static Connection getJDBCCon1() throws SQLException {
			
			final String url = "jdbc:mysql://127.0.0.1:3306/shoppingdb";
			final String user = "root";
			final String pW ="1234";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(url, user, pW);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		
		}
}
