package dao;

import model.Product;
import model.User;

public interface UserDAO {
	public boolean addUser(User u);
	public User find(int id);
	public User updateUserDetails(User u);
	public boolean deleteUserDetails(User u);
	public java.util.List<User>getAllUser(); 
	public User findName(String username);
}
