package softwareengineer.bean;

public class Item {
	private int id;
	private String nameOfItem;
	private String caculationUnit;
	private double price;
	private int quantity;
	private double discount;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int id,String nameOfItem, String caculationUnit, double price, int quantity, double discount) {
		super();
		this.id=id;
		this.nameOfItem = nameOfItem;
		this.caculationUnit = caculationUnit;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfItem() {
		return nameOfItem;
	}
	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}
	public String getCaculationUnit() {
		return caculationUnit;
	}
	public void setCaculationUnit(String caculationUnit) {
		this.caculationUnit = caculationUnit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", nameOfItem=" + nameOfItem + ", caculationUnit=" + caculationUnit + ", price="
				+ price + ", quantity=" + quantity + ", discount=" + discount + "]";
	}
	
	
}
