package crm.backend.dao;

import java.util.List;

import crm.backend.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll(int offset,int rowcount);

	int countTotalRecords();
	
	List<Customer> getAll();
	
	void save(Customer customer);

	Customer get(int id);

	void delete(int id);

	
}
