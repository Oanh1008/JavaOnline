package softwareengineer.bean;

import java.util.List;

public class Invoice {
	private int id;
	private List<Item> items;
	private double total;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int id, List<Item> items, double total) {
		super();
		this.id = id;
		this.items = items;
		this.total = total;
	}
	public Invoice(int id, List<Item> items) {
		super();
		this.id = id;
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", items=" + items + ", total=" + total + "]";
	}
	
}
