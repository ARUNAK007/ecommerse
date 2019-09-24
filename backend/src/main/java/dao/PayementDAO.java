package dao;

import model.Payement;

public interface PayementDAO {
	boolean addPayement(Payement p);
	boolean deletePayement(Payement p);
	Payement findPayement(int id);
	Payement updatePayement(Payement p);
	java.util.List<Payement> getAllPayements(String cartId);
	Payement find(String cartId);

}
