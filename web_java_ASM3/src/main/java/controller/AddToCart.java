package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Product;
import DAO.DAO;
import DAO.autoIdOder;


public class AddToCart extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doPost(req, resp);
			
		} catch (Exception e) {
			resp.getWriter().println("ex");
		}
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	
    	try {
    	HttpSession session = request.getSession(true);
    	 
    	// 
    	 DAO DAO = new DAO();
    	
    	 List<Product> listC = DAO.getAllProduct();
    	 Product productCart = new Product();
    	 int id =  Integer.parseInt(request.getParameter("idAddToCart"));
    	 for (Product x : listC ) {
				if(x.getProduct_id() == id) {
					productCart = x;
				}
			}
    		
       if(session.getAttribute("Cart") == null) {
    	  
    	 session.setAttribute("Cart",  new Cart() ); 	
    	
       }
            
       // set values cho sesion 
       Cart c = (Cart) session.getAttribute("Cart");
         
		c.addCart(productCart);
		 
       RequestDispatcher index = request.getRequestDispatcher("/Cart.jsp");
   		index.forward(request,response);
		} catch (Exception e) {
			 response.getWriter().println("ex");
		}
 
    }	
}