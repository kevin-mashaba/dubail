package za.co.dubai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table
@Entity
public class Address 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private long addressId;
	
	@Column(name="address_type")
	private String addressType;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="address_line")
	private String addressLine;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	
}
