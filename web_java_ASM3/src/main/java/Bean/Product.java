package Bean;

public class Product {
	private int Product_id;
	private String Product_name;
	private String Product_des;
	private float Product_price;
	private String Product_img;
	private String Product_type;
	private String product_brnad;
	private int  product_number = 1;
	
	
	public Product() {
		super();
	}

	public Product(int product_id, String product_name, String product_des, float product_price, String product_img,
			String product_type, String product_brnad) {
		super();
		this.Product_id = product_id;
		this.Product_name = product_name;
		this.Product_des = product_des;
		this.Product_price = product_price;
		this.Product_img = product_img;
		this.Product_type = product_type;
		this.product_brnad = product_brnad;
	}

	public int getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public String getProduct_des() {
		return Product_des;
	}

	public void setProduct_des(String product_des) {
		Product_des = product_des;
	}

	public float getProduct_price() {
		return Product_price;
	}

	public void setProduct_price(float product_price) {
		Product_price = product_price;
	}

	public String getProduct_img() {
		return Product_img;
	}

	public void setProduct_img(String product_img) {
		Product_img = product_img;
	}

	public String getProduct_type() {
		return Product_type;
	}

	public void setProduct_type(String product_type) {
		Product_type = product_type;
	}

	public String getProduct_brnad() {
		return product_brnad;
	}

	public void setProduct_brnad(String product_brnad) {
		this.product_brnad = product_brnad;
	}
	
	
	
	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public void toString1() {
		// TODO Auto-generated method stub
		System.out.println(this.Product_id + " " + this.Product_name + "" +
		this.Product_des + " " + this.product_brnad + " " + this.Product_img + " " + this.Product_price
		+ " " + this.Product_type
				);
		
				
	}
}
