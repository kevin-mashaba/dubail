package za.co.dubai.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.co.dubai.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{
	Address findById(long id);
	
	@Query(value="SELECT * FROM address a, customer c WHERE LOWERE(city) =LOWER('?1') AND a.customer_id = c.customer_id",nativeQuery=true)
	List<Map<String,String>> findCustomersFromCity(String city);
	
	//@Query(value="SELECT * FROM address where customer_id =?1",nativeQuery=true)
	//Address findCustomerAddressById(long customerId);
}
