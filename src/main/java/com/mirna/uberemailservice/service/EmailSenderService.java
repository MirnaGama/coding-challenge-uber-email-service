package com.mirna.uberemailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.uberemailservice.adapters.EmailSenderGateway;
import com.mirna.uberemailservice.core.cases.EmailSenderUserCase;
import com.mirna.uberemailservice.core.exceptions.EmailServiceException;

@Service
public class EmailSenderService implements EmailSenderUserCase {

	private final EmailSenderGateway emailSenderGateway;
	
	@Autowired
	public EmailSenderService(EmailSenderGateway emailSenderGateway) {
		this.emailSenderGateway = emailSenderGateway;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) throws EmailServiceException {
		this.emailSenderGateway.sendEmail(to, subject, body);
	}

}
