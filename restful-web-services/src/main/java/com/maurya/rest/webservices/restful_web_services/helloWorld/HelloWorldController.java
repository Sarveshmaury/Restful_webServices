package com.maurya.rest.webservices.restful_web_services.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	
	@RequestMapping(method=RequestMethod.GET ,path="/hello-world")
	public String helloWorld() {
		return "Hello World !";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldbean() {
		return  new HelloWorldBean("Hello World !");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//		return  new HelloWorldBean("Hello " + name);
		
		return  new HelloWorldBean(String.format("Hello  , %s", name));
	}
	
	@GetMapping("/hello-world-internationalization")
	public String helloWorldInternationalization(@PathVariable String name) {
		
		 Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message" ,locale );

		
		//return "Hello";
	}

}
