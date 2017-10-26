package com.hr.register.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.register.domain.Customer;
import com.hr.register.domain.Images;
import com.hr.register.domain.InitList;
import com.hr.register.resource.Datas;
import com.hr.register.service.StorageService;

@RestController
@RequestMapping(value="/api")
public class IndexController {
	
	@Autowired
	public StorageService storageService;
	
	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(1, new Customer(1, "Mary", "Taylor", 24));
	        put(2, new Customer(2, "Peter", "Smith", 18));
	        put(3, new Customer(3, "Lauren", "Taylor", 31));
	    }
		
	};
	
	@GetMapping(value="/index")
	public List<InitList> index() {
		
		//업로드된 파일 초기화
		storageService.init();
		
		List<InitList> indexResults = Datas.initLists.entrySet().stream()
				.map(entry ->entry.getValue())
				.collect(Collectors.toList());
		
		return indexResults;
	}
	
	@GetMapping(value="/images")
	public List<Images> images() {
		return storageService.getImages();
	}
	
	
	@GetMapping(value="/customer")
	public List<Customer> getAll(){
		List<Customer> results = customers.entrySet().stream()
									.map(entry ->entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
	
	@GetMapping(value="/customer/{id}")
	public Customer getCustomer(@PathVariable int id){
		return customers.get(id);
	}
	
	@PostMapping(value="/customer")
	public Customer postCustomer(@RequestBody Customer customer){
		int id = customers.size() + 1;
		customer.setId(id);
		customers.put(id, customer);
		return customer;
	}
	
	@PutMapping(value="/customer/{id}")
	public void putCustomer(@RequestBody Customer customer, @PathVariable int id){
		customers.replace(id, customer);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable int id){
		customers.remove(id);
	}
}
