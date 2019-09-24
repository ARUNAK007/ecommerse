package dao;

import model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier s);
	public Supplier find(int id);
	public Supplier updateSupplierDetails(Supplier s);
	public boolean deleteSupplierDetails(Supplier s);
	public java.util.List<Supplier>getAllSupplier(); 
}
