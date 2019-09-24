package dao;

import model.Product;

public interface ProductDAO {
	public boolean addProduct(Product p);
	public Product find(int id);
	public Product updateProduct(Product p);
	public boolean deleteProduct(Product p);
	public java.util.List<Product>getAllProducts(); 

}