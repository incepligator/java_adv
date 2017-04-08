package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CustomerDetails")
public class CustomerDetails {
	
	
	@Id
	@Column(name="SERIAL")
	@GenericGenerator(name="custSeq", strategy="foreign", 
	parameters=@Parameter(name="property", value="customer"))
	@GeneratedValue(generator="custSeq")
	private Long pk;
	
	@Column(name="ADDRESS")
	private String address;
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	
	private Customer customer;
	
	
	
	@Override
	public String toString() {
		return "CustomerDetails [pk=" + pk + ", address=" + address + "]";
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Long getPk() {
		return pk;
	}






	public void setPk(Long pk) {
		this.pk = pk;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}














	
	
	
}
