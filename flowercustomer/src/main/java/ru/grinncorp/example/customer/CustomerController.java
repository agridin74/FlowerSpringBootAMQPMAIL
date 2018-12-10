package ru.grinncorp.example.customer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	CustomerRegistrar customerRegistrar;
	
	public CustomerController(CustomerRegistrar customerRegistrar) {
		this.customerRegistrar = customerRegistrar;
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	Customer register(@RequestBody Customer customer) {
		return customerRegistrar.register(customer);
	}
}
