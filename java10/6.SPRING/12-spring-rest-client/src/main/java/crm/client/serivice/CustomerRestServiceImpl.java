package crm.client.serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import crm.client.bean.Customer;

@Service
public class CustomerRestServiceImpl implements CustomerRestService {
	private RestTemplate restTemplate;

	private String crmRestUrl;

	public CustomerRestServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String crmRestUrl) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;

	}

	@Override
	public List<Customer> getAll() {
		// call api: http://localhost:8080/12-spring-rest-api/api/customers
		// TODO Auto-generated method stub
		System.out.println("API: " + crmRestUrl);
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		return responseEntity.getBody();
	}

	@Override
	public Customer get(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		// customer --> json --> customer
		Integer customerId = customer.getId();
		if (customerId == null) {
			restTemplate.postForEntity(crmRestUrl, customer, String.class);
		} else {
			restTemplate.put(crmRestUrl, customer);
		}

	}

	@Override
	public void delete(int customerId) {
		// TODO Auto-generated method stub

	}

}
