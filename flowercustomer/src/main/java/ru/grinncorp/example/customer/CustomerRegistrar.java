package ru.grinncorp.example.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CustomerRegistrar {
	CustomerRepository  customerRepository;
	Sender sender;
	
	@Autowired
	public CustomerRegistrar(CustomerRepository  customerRepository, Sender sender) {
		this.customerRepository=customerRepository;
		this.sender = sender;
	}
	
	Customer register(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
		
		if(existingCustomer.isPresent()) {
			throw new RuntimeException("уже существует");
		} else {
			customerRepository.save(customer);
			sender.send(customer.getEmail());
		}
		return customer;
		
	}

}
