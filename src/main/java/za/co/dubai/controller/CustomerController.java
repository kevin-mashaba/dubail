package za.co.dubai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.dubai.model.Customer;
import za.co.dubai.service.CustomerService;

@RestController
public class CustomerController 
{

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path ="/customer",method = RequestMethod.POST,produces= "application/json")
	public Customer createCustomer( @RequestBody Customer customer) throws Exception
	{
		return customerService.createCustomer(customer);
	}
	
	@RequestMapping(path ="/customer",method = RequestMethod.GET,produces= "application/json")
	public List<Customer> getAllCustomers() throws Exception
	{
		return customerService.getAllCistomers();
	}
	
	@RequestMapping(path ="/customer/{id}",method = RequestMethod.GET,produces= "application/json")
	public Customer getCustomerById(@PathVariable(name ="id")long id) throws Exception
	{
		return customerService.findCustomerById(id);
	}
	
	@RequestMapping(path ="/phone/{prefix}",method = RequestMethod.GET,produces= "application/json")
	public List<Customer> getAllCustomersWithPrefixPhone(@PathVariable(name ="prefix") String prefix) throws Exception
	{
		return customerService.getAllCustomersWithPrefixPhone(prefix);
	}
	
	@RequestMapping(path ="/city/{name}",method = RequestMethod.GET,produces= "application/json")
	public List<Map<String,String>> getAllCustomersByCity(@PathVariable(name ="name") String name) throws Exception
	{
		return customerService.getCustomersByCity(name);
	}
}
