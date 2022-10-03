package softwareengineer.bo;

import java.util.ArrayList;
import java.util.List;

import softwareengineer.bean.Invoice;
import softwareengineer.bean.Item;

public class InvoiceBoImplement implements InterfaceInvoiceBo {
	private final static List<Invoice> invoices;
	static {
		invoices = new ArrayList<>();
	}
	@Override
	public void addNewInvoice(Invoice invoice) {
		invoices.add(invoice);
		
	}
	@Override
	public void deleteInvoice(int id) {
		invoices.removeIf(invoice ->invoice.getId()==id);
		
	}
	@Override
	public void updateInvoice(int id,int idItem, double price, int quantity) {
		for(Invoice invoice:invoices) {
			if(invoice.getId()==id) {
				List<Item> items=invoice.getItems();
				for(Item item:items) {
					if(item.getId()==idItem) {
						item.setPrice(price);
						item.setQuantity(quantity);
						break;
					}
				}
			}
		}
		
	}
	public  void displayInvoice() {
		invoices.forEach(System.out::println);
	}
}
