package ru.grinncorp.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.grinncorp.example.customer.Customer;
import ru.grinncorp.example.customer.CustomerRepository;

@SpringBootApplication
public class FlowercustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowercustomerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerRepository customerRepository) {
		return (ret) -> {
			customerRepository.save(new Customer("Entity1","entity1@example.com"));
			customerRepository.save(new Customer("Entity2","entity2@example.com"));
			customerRepository.save(new Customer("Entity3","entity3@example.com"));
			customerRepository.save(new Customer("Entity4","entity4@example.com"));
			customerRepository.save(new Customer("Entity5","entity5@example.com"));
			customerRepository.save(new Customer("Entity6","entity6@example.com"));
			customerRepository.save(new Customer("Entity7","entity7@example.com"));
			customerRepository.save(new Customer("Entity8","entity8@example.com"));
			customerRepository.save(new Customer("Entity9","entity9@example.com"));
			
		};
	}
}
