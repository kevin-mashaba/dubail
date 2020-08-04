package za.co.dubai.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.dubai.model.Address;

import za.co.dubai.service.AddressService;


@RestController
public class AddressController
{

	@Autowired
	private AddressService addressService;
	
	@RequestMapping(path ="/customer/{customerId}",method = RequestMethod.POST,produces= "application/json")
	public Address createAddressForCustomer( @PathVariable(name="customerId")long customerId, @RequestBody Address address ) throws Exception
	{
		
		return addressService.createCustomerAddress(customerId, address);
	}
	
	@RequestMapping(path ="/customer/{customerId}/address/{addressId}",method = RequestMethod.DELETE,produces= "application/json")
	public Address deleteAddressForCustomer( @PathVariable(name="customerId")long customerId, @PathVariable(name="addressId")long addressId) throws Exception
	{
		
		return addressService.deleteCustomerAddress(customerId, addressId);
	}
}
