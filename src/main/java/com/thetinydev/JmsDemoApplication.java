package com.thetinydev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.thetinydev.mail.Email;

@SpringBootApplication
public class JmsDemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(JmsDemoApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello JMS!!!"));
	}
}
