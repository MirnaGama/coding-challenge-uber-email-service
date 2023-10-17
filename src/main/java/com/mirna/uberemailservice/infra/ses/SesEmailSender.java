package com.mirna.uberemailservice.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.mirna.uberemailservice.adapters.EmailSenderGateway;
import com.mirna.uberemailservice.core.exceptions.EmailServiceException;

@Service
@PropertySource(value = "classpath:application.properties")
public class SesEmailSender implements EmailSenderGateway {

	private final AmazonSimpleEmailService amazonSingleEmailService;

	@Autowired
	public SesEmailSender(AmazonSimpleEmailService amazonSingleEmailService) {
		this.amazonSingleEmailService = amazonSingleEmailService;
	}

	@Autowired
	private Environment env;
	
	@Override
	public void sendEmail(String to, String subject, String body) throws EmailServiceException {
		
		String source = env.getProperty("email.source");
		
		SendEmailRequest request = new SendEmailRequest().withSource(source)
				.withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content(subject))
				.withBody(new Body().withText(new Content(body))));
		
		try {
			this.amazonSingleEmailService.sendEmail(request);
		} catch (AmazonServiceException exception) {
			throw new EmailServiceException("Failure while sending email", exception);
		}
		
	}

}
