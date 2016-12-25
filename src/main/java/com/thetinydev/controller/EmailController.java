package com.thetinydev.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thetinydev.mail.Email;

@RestController
public class EmailController {

	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("jms/{sendingTime}")
	public void sendMail(@PathVariable int sendingTime) {
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		
		List<String> bodys = Arrays.asList("Hi!!", "Thanks!!", "How are you?", "Where are you from");
		for (int i =0 ; i < sendingTime ; i++) {
			bodys.stream().forEach(body -> jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", body)));
		}
	}
	
}
