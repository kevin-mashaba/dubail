package za.co.dubai.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.dubai.model.Address;
import za.co.dubai.model.Customer;
import za.co.dubai.repository.AddressRepository;
import za.co.dubai.repository.CustomerRepository;

@Service
public class AddressService
{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	
	
	
	
	public Address createCustomerAddress(long customerId, Address address) throws Exception
	{
		Customer customer = customerRepository.findById(customerId);
		if(customer!=null)
		{
			address.setCustomer(customer);
			return addressRepository.save(address);
		}
		else
		{
			throw new Exception("Customer with ID " + customerId + " does not exist! Address could not be added");
		}
	}
	
	public Address deleteCustomerAddress(long customerId,long addressId) throws Exception
	{
		Customer customer =customerRepository.findById(customerId);
		Address address = addressRepository.findById(addressId);
		if(customer!=null)
		{
			if( address!=null)
			{
				 addressRepository.delete(address);
				 return address;
			}
			else
			{
				throw new Exception("Address with ID " + addressId + " does not exist!Could not delete");
			}
	 
		}
		else
		{
			throw new Exception("Customer with ID " + customerId + " does not exist!Could not delete");
		}
	}
	
	public List<Map<String,String>> getCustomerFromCity(String city)
	{
		return addressRepository.findCustomersFromCity(city);
	}
	
	
}
