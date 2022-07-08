package Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Product;
import DAO.DAO;

@WebFilter(urlPatterns = {"/index.jsp"})
public class filterHome implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		try {
    		DAO a = new DAO();
    		
    		List <Product> c = a.getAllProduct(); 
    		
        	request.setAttribute("tinh", "tinh");
        	request.setAttribute("List", c);
        	chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 
        
    
	}
}
