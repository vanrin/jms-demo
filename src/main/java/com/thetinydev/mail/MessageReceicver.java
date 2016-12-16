package com.thetinydev.mail;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceicver {

	   @JmsListener(destination = "mailbox", containerFactory = "messageFactory")
	    public void receiveMessage(Email email) {
	        System.out.println("Received <" + email.getBody() + ">" + " From : " + email.getTo());
	    }
}
