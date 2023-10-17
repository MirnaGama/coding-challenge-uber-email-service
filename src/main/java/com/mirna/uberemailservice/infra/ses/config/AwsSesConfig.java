package com.mirna.uberemailservice.infra.ses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class AwsSesConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public AmazonSimpleEmailService amazonSimpleEmailService() {
		
		String region = env.getProperty("aws.region");
		String accessKey = env.getProperty("aws.credentials.accessKey");
		String secretKey = env.getProperty("aws.credentials.secretKey");
		
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		
		return AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
		        .withRegion(region).build();
	}
}
