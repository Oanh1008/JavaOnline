package com.springmvc.controller;

import java.util.Comparator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.utils.SortUtils;
import com.springmvc.common.Application;
import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String index(ModelMap modelMap, 
			@RequestParam(name = "page",defaultValue = "1") int page,
			@RequestParam(name = "text",defaultValue = "") String text,
			@RequestParam(name = "sort",defaultValue = "first_name") String sort) {
		
		// step1 : Count total of records
		int totalRecords= customerService.countTotalRecords();
		System.out.println(totalRecords);
		int totalPages=(int)Math.ceil((float) totalRecords / Application.RECORDS_PER_PAGE);
		
	
		//int totalPages=4;
		page=page<1?1:page;
		page=page>totalPages?totalPages:page;
		int offset=(page-1)*Application.RECORDS_PER_PAGE;
		
		
		// pagination and search current page
		List<Customer> customers= customerService.getAll(offset, Application.RECORDS_PER_PAGE);
		customers.sort(Comparator.comparing(SortUtils.CUSTOMER_SORT_PROPERTIES.get(sort)));
		if(!text.trim().isEmpty()) {
			customers=customers.stream().filter(customer->{
				return customer.getFirstName().toLowerCase().contains(text)
						|| customer.getLastName().toLowerCase().contains(text)
						||customer.getEmail().toLowerCase().contains(text);
			}).collect(Collectors.toList());
		}
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("totalPages",totalPages);
		modelMap.addAttribute("customers",customers);
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
		
		Customer customer=customerService.get(id);
		modelMap.addAttribute("customer", customer);
	
		return Application.CUSTOMER_FORM_PAGE;
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) { // get customer
//		if(customer.getId()==0) {
//			customer.setId(0);   other way to increament id
//		}
		customerService.save(customer);
		// redirect == ${contextPath}
		return Application.CUSTOMER_REDIRECT;
	}
	@GetMapping("/delete")
	public String delete(ModelMap modelMap,
			@RequestParam("id") int id) {
		
		customerService.delete(id);
	
	
		return Application.CUSTOMER_REDIRECT;
	}
	
	
}
