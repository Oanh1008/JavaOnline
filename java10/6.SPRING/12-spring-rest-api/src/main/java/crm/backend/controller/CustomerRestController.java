package crm.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crm.backend.entity.Customer;
import crm.backend.exception.ElementNotFoundException;
import crm.backend.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
		
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id){
		Optional<Customer> opt = Optional.ofNullable(customerService.get(id));
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new ElementNotFoundException("Customer "+id+" not found");
	}
	
}
