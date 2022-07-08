package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Product;
import DAO.autoIdOder;
import DAO.orderDAO;




public class submitOrder extends HttpServlet{
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			doPost(req, resp);
//			
//		} catch (Exception e) {
//			resp.getWriter().println("ex");
//		}
//		
//	}
//	
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	response.setContentType("text/html;charset=UTF-8");
//    	
//    	try {
//    		 response.sendRedirect("Home");
////       RequestDispatcher index = request.getRequestDispatcher("serVlet_Home");
////   		index.forward(request,response);
//		} catch (Exception e) {
//			 response.getWriter().println("ex");
//		}
// 
//    }	
    
    private static final long serialVersionUID = 1L;
  
    public submitOrder() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
  	
 	try {
 		
 		orderDAO comtummerOder = new orderDAO();
 		
 		// get velua comtummer 
 		String customerName = request.getParameter("customerName");
 		String customerAddress = request.getParameter("customerAddress");
 		String discountCode = request.getParameter("discountCode");
 		
 		HttpSession session = request.getSession(true);
 		Cart c = (Cart) session.getAttribute("Cart");
 		
 		
 		List<Product> listCart = new ArrayList<>();
 		listCart =  c.getListCart();
 		
 		for (Product x : listCart) {
			x.toString1();
		}
 		
 		// auto create id_oder comtummer 
        autoIdOder a = new autoIdOder();
		int id_Oder = a.getId_oder();
		// auto create id_oder comtummer 
		
		// get values date now
		LocalDateTime myDateObj = LocalDateTime.now();  
	     
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	    
	    String dayNow = myDateObj.format(myFormatObj); 
	   // get values date nowz
	    
		
		// add date to the table order
		comtummerOder.submitDatebase(
				customerName,
				id_Oder,
				dayNow,
				discountCode,
				customerAddress
				);
		
		//add date to the table order_detail
		for (Product x : listCart) {
			comtummerOder.submiDataBill(
					id_Oder,
					x.getProduct_id(),
					x.getProduct_number(),
					x.getProduct_price()
					);
			// create new id_oder
		}
		
		
		a.deleteAutoIdOder();
		id_Oder++;
		a.setAutoIdOder(id_Oder);
		// create new id_oder
  		 response.sendRedirect("index.jsp");
//       RequestDispatcher index = request.getRequestDispatcher("web_java_ASM3/index.jsp");
//   		index.forward(request,response);
		} catch (Exception e) {
			 response.getWriter().println("ex");
		}
 
    }	
    
	}

