package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private  String cartid;
	private String paymenttype;
	@Column(name="Shippingaddress")
	private String shippingaddress;
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	private float total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCartId() {
		return cartid;
	}
	public void setCartId(String cartid) {
		this.cartid = cartid;
	}
	public float gettotal() {
		return total;
	}
	public void settotal(float total) {
		this.total = total;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
}
