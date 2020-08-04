package za.co.dubai.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.dubai.model.Customer;
import za.co.dubai.repository.CustomerRepository;

@Service
public class CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public Customer createCustomer(Customer customer) throws Exception
	{
		if(customer!=null)
		{
			System.out.println("Creating " + customer);
			return customerRepository.save(customer);
		}
		else
		{
			throw new Exception("Customer could not be created");
		}
	}
	
	public List<Customer> getAllCistomers()
	{
		return customerRepository.findAll();
	}
	
	public Customer findCustomerById(long customerId) throws Exception
	{
		Customer customer =customerRepository.findById(customerId);
		
		if(customer!=null)
		{
			return customer;
		}
		else
		{
			throw new Exception("Customer with ID " + customerId + " does not exist!");
		}
	}
	
	
	
	public List<Customer> getAllCustomersWithPrefixPhone(String phone) throws Exception
	{
		if(phone!=null)
		{
			
		    return customerRepository.findPrefixedNumbers(phone);
			
		}
		else
		{
			throw new Exception("No customer/s with phone number starting with " + phone);
		}
		
	}
	
	public List<Map<String,String>> getCustomersByCity(String city)
	{
		return customerRepository.getCustomersByCity(city);
	}
}
