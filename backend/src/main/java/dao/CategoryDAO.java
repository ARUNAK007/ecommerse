package dao;

import model.Category;

public interface CategoryDAO {
	public boolean addCategory(Category c);
	public Category find(int id);
	public Category updateCategory(Category c);
	public boolean deleteCategory(Category c);
	public java.util.List<Category>getAllCategorys(); 

}
