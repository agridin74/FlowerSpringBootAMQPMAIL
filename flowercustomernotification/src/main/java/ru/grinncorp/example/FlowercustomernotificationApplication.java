package ru.grinncorp.example;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class FlowercustomernotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowercustomernotificationApplication.class, args);
	}
}

@Component
class Receiver {
	
	@Autowired
	Mailer mailer;
	
	@Bean
	Queue queue() {
		return new Queue("CustomerQ", false);
	}
	
	@RabbitListener(queues="CustomerQ")
	public void processMessage(String email) {
		System.out.println(email);
		mailer.sendMail(email);
	}
	
	@Component
	class Mailer {
		@Autowired
		private JavaMailSender javaMailSender;
		
		public Mailer() {
			
		}
		
		public void sendMail(String email) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("Регистрация");
			mailMessage.setText("Регистрация прошла успешно");
			javaMailSender.send(mailMessage);
		}
	}
	
}
