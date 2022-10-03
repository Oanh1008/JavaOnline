package crm.client.serivice;

import java.util.List;

import crm.client.bean.Customer;

public interface CustomerRestService {
	List<Customer> getAll();

	Customer get(int customerId);

	void save(Customer theCustomer);

	void delete(int customerId);
}
