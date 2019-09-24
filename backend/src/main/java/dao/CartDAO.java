package dao;

import model.Cart;

public interface CartDAO {
	boolean addCart(Cart p);
	boolean deleteCart(Cart p);
	Cart findCart(int id);
	Cart find(String cartid);
	Cart updateCart(Cart p);
	java.util.List<Cart> getAllCarts(String cartid);
}
