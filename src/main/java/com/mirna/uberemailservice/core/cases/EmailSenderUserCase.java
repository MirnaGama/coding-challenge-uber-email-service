package com.mirna.uberemailservice.core.cases;

import com.mirna.uberemailservice.core.exceptions.EmailServiceException;

public interface EmailSenderUserCase {

	void sendEmail(String to, String subject, String body) throws EmailServiceException;
}
