package za.co.dubai.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.co.dubai.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long >
{
	Customer findById(long id);
	
	@Query(value="SELECT * FROM customer WHERE phone_number LIKE ?1%",nativeQuery=true)
	List<Customer> findPrefixedNumbers(String phone);
	
	@Query(value="SELECT * FROM customer WHERE city LIKE ?1%",nativeQuery=true)
	List<Customer> findCustomersByCity(String phone);
	
	@Query(value="SELECT c.customer_id, address_line,address_type,city,country,first_name,last_name,email,phone_number\n" + 
			"from address a,customer c\n" + 
			"WHERE lower(a.city) = lower(?1)\n" + 
			"AND a.customer_id = c.customer_id",nativeQuery=true)
	List<Map<String,String>> getCustomersByCity(String city);
}
