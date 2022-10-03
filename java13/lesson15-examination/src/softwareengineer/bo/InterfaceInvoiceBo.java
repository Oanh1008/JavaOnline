package softwareengineer.bo;

import softwareengineer.bean.Invoice;

public interface InterfaceInvoiceBo {
	/**
	 * add an invoice into system
	 * @param invoice
	 */
	void addNewInvoice(Invoice invoice);
	/**
	 * delete an invoice with id from system
	 * @param id
	 */
	void deleteInvoice(int id);
	/**
	 * update information of invoice with id from system
	 * update price and quantity
	 * @param id
	 * @param price
	 * @param quantity
	 */
	void updateInvoice(int id,int idItem ,double price, int quantity);
}
