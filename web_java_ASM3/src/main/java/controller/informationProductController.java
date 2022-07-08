package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Bean.Product;
import DAO.DAO;




public class informationProductController extends HttpServlet {
	

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
    	try {
        int id =  Integer.parseInt(request.getParameter("idProduct1"));
    	System.out.println(id);	
    	
    	DAO a = new DAO();
		List <Product> list = a.getAllProduct(); 
		Product IdInFor = new Product();
		for (Product p : list) {
			if(id == p.getProduct_id()) {
				
				IdInFor = p; 
				
			}
		}
			
		request.setAttribute("tinh2", IdInFor); 
         
			RequestDispatcher index =  request.getRequestDispatcher("/informationProduct.jsp");
	 		index.forward( request, response);
		} catch (Exception e) {
			 response.getWriter().println("ex");
		}
	
    }	
}
