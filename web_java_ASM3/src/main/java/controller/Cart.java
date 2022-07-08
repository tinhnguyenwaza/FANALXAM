package controller;

import java.util.ArrayList;
import java.util.List;

import Bean.Product;
import DAO.autoIdOder;

public class Cart {
	private List<Product> listCart;

	public Cart(){
		listCart= new ArrayList<>();
	
	}
	
	public void addCart(Product a){
		for (Product x : listCart) {
			if(a.getProduct_id() == x.getProduct_id()) {
				x.setProduct_number(x.getProduct_number() + 1);
				return;
			}
		}
		listCart.add(a);
	}
	
	public void remove(int id) {
		for (Product x : listCart) {
			if(id == x.getProduct_id()) {
				listCart.remove (x);
				return;
				
			}
		}	
	}
	
	public double getAmount() {
		double s = 0;
		for (Product x : listCart) {
			s += x.getProduct_price() * x.getProduct_number();
		}
		return s;
		
	}
	
	public List<Product> getListCart(){
		
		return this.listCart;
	}
	

	public  int getLenghtList(){
		
		return this.listCart.size();
	}
	
	
}
