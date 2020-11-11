package com.codelabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;

import com.codelabs.startup.Startup;
import com.codelabs.utility.Constants;

@SpringBootApplication(scanBasePackages={"com.codelabs"})
@EnableJpaRepositories("com.codelabs.repository") 
@EntityScan("com.codelabs.model")
public class RestAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAPIApplication.class, args);
	}
	
	@Bean
	public HttpHeaders httpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(Constants.STRICT_TRANSPORT_SECURITY,Constants.STRICT_TRANSPORT_SECURITY_VALUE); 
		return httpHeaders;
	}
	
	@Bean(name="startup",initMethod = "init",destroyMethod = "destroy")
	public Startup startup() {
		return new Startup();
	}

}
