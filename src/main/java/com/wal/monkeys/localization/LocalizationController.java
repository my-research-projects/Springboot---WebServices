package com.wal.monkeys.localization;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class LocalizationController {

@Autowired	
private 	MessageSource messageSource;
	
	// Return String
	@GetMapping(path = "/localization")
	public String helloWorld(){		
		return ("Hello World");		
	}
	
	// Return Object
	@GetMapping(path = "/localization-bean")
	public LocalizationBean helloWorldBean(){		
		return new LocalizationBean("Hello World");		
	}
	
	//Return object as PathVariable
	@GetMapping(path = "/localization/path-variable/{name}")
	public LocalizationBean helloWorldPathVariable(@PathVariable String name){		
		return new LocalizationBean(String.format("Hello World, %s", name));		
	}
	
	
	@GetMapping(path = "/localization-internationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	
	
}
