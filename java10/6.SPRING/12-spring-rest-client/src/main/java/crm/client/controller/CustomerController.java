package crm.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crm.client.bean.Customer;
import crm.client.common.Application;
import crm.client.serivice.CustomerRestService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerRestService service;
	
	@GetMapping
	public String index(ModelMap modelMap) {
		List<Customer> customers =service.getAll();
		modelMap.addAttribute("customers", customers);
		
		return Application.CUSTOMER_INDEX_PAGE;
	}
	
	@GetMapping("/add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("customer", new Customer());

		
		return Application.CUSTOMER_FORM_PAGE;
	}
	@GetMapping("/update")
	public String update(ModelMap modelMap,
			@RequestParam("id") int id) {
		
	
		return Application.CUSTOMER_FORM_PAGE;
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		service.save(customer);
		return Application.CUSTOMER_REDIRECT;
	}
	@GetMapping("/delete")
	public String delete(ModelMap modelMap,
			@RequestParam("id") int id) {
		
	
	
		return Application.CUSTOMER_REDIRECT;
	}
	
	
}
