package com.mirna.uberemailservice.adapters;

import com.mirna.uberemailservice.core.exceptions.EmailServiceException;

public interface EmailSenderGateway {

	void sendEmail(String to, String subject, String body) throws EmailServiceException;
}
