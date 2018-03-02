package com.wal.monkeys.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering-static")
	public FilterBean retrieveFilterBeanStatic() {
		return new FilterBean("Wal", "Monkeys", "walmonkeys2018");
		
	}
		
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrieveFilterBeanDynamic() {	
		FilterBean filterBean = new FilterBean("Wal", "Monkeys", "walmonkeys2018");	
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("firstName","lastName");	
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filterBean);	
		mapping.setFilters(filters);	
		return mapping;
	}
	
	// Filter out first name and last name
	@GetMapping("/filtering-list-static")
	public List<FilterBean> retrieveListOfBeansStatic(){
		return Arrays.asList(
				new FilterBean("Wal", "Monkeys", "walmonkeys2018"),
				new FilterBean("Wal1", "Monkeys1", "walmonkeys2018-1"),
				new FilterBean("Wal2", "Monkeys2", "walmonkeys2018-2")			
				);
	}
	
	// Exclude from filtering out first name and last name
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue retrieveListOfBeansDynamic(){
		List<FilterBean> list = Arrays.asList(
				new FilterBean("Wal", "Monkeys", "walmonkeys2018"),
				new FilterBean("Wal1", "Monkeys1", "walmonkeys2018-1"),
				new FilterBean("Wal2", "Monkeys2", "walmonkeys2018-2")			
				);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("lastName","password");	
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);	
		mapping.setFilters(filters);	
		
		return mapping;
	
	}
	
}
