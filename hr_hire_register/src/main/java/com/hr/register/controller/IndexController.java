package com.hr.register.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.register.domain.Customer;
import com.hr.register.domain.InitList;
import com.hr.register.domain.Submit;
import com.hr.register.utils.UrlConnectionCheck;

@RestController
@RequestMapping(value="/api")
public class IndexController {
	
	UrlConnectionCheck conInstance = UrlConnectionCheck.getInstance();
	
	private Map<Integer, InitList> initLists = new HashMap<Integer, InitList>(){
		{
			put(1, new InitList("DBCUT",1,conInstance.getConnectionResult("https://www.dbcu.com/bbs/bbs.php?table=job"),false));
			put(2, new InitList("GIMASA",2,conInstance.getConnectionResult("http://cafe.naver.com/newplanmarketing"),false));
			put(3, new InitList("Designjob",3,conInstance.getConnectionResult("http://www.designjob.co.kr/"),false));
			put(4, new InitList("WebManSa",4,conInstance.getConnectionResult("http://cafe.naver.com/netmaru"),false));
		}
	};
	
	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(1, new Customer(1, "Mary", "Taylor", 24));
	        put(2, new Customer(2, "Peter", "Smith", 18));
	        put(3, new Customer(3, "Lauren", "Taylor", 31));
	    }
		
	};
	
	@GetMapping(value="/index")
	public List<InitList> index() {
		List<InitList> indexResults = initLists.entrySet().stream()
				.map(entry ->entry.getValue())
				.collect(Collectors.toList());
		return indexResults;
	}
	
	@PostMapping(value="/create")
	public List<InitList> create(@RequestBody Submit submit){
		
		String submitList = submit.getSubmitList();
		String[] array = submitList.split(",");
		
		
		
		List<InitList> InitList = null;
		return InitList;
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
