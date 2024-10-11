package com.maurya.rest.webservices.restful_web_services.versoning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersoningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersonOfPerson() {
		return new PersonV1("Sarvesh Maurya");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersonOfPerson() {
		return new PersonV2(new Name("Sarvesh" ,"Maurya"));
	}
	
	@GetMapping(path="/person" ,params="version=1")
	public PersonV1 getFirstVersonOfPersonRequestParameter() {
		return new PersonV1("Sarvesh Maurya");
	}
	
	@GetMapping(path="/person" ,params="version=2")
	public PersonV2 getSecondVersonOfPersonRequestParameter() {
		return new PersonV2(new Name("Sarvesh" ,"Maurya"));
	}
	
	@GetMapping(path="/person/header" ,headers = "X-API-VERSON=1")
	public PersonV1 getFirstVersonOfPersonRequestHeader() {
		return new PersonV1("Sarvesh Maurya");
	}
	
	@GetMapping(path="/person/header" ,headers = "X-API-VERSON=2")
	public PersonV2 getSecondVersonOfPersonRequestHeader() {
		return new PersonV2(new Name("Sarvesh" ,"Maurya"));
	}
	
	@GetMapping(path="/person/accept" ,produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersonOfPersonAcceptHeader() {
		return new PersonV1("Sarvesh Maurya");
	}
	
	@GetMapping(path="/person/accept" ,produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersonOfPersonAcceptHeader() {
		return new PersonV2(new Name("Sarvesh" ,"Maurya"));
	}

}
