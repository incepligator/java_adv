package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")

@NamedQueries({
	
	//@NamedQuery(  name =QueryConstants.CUSTOMER_SELECT_ALL,query = "select c from Customer c" ),
	@NamedQuery(  name =QueryConstants.CUSTOMER_SEARCH,query = "select c from Customer c where upper(c.firstName) like upper(:p1) and upper(c.lastName) like upper(:p2)"),
	
	@NamedQuery(  name =QueryConstants.CUSTOMER_COUNT, query = "select count(*) from Customer"),
	@NamedQuery(  name = "find Customer by id", query = "Select e from Customer e where e.firstName = :id" ),
	
	@NamedQuery(  name =QueryConstants.BIJAY, query = "select c from Customer c"),
})

	@NamedNativeQueries({
	@NamedNativeQuery(name=QueryConstants.NATIVE_CUSTOMER_SELECT_ALL, query="select CUSTOMER_PK, FIRST_NAME, LAST_NAME from Customer", resultClass=Customer.class),
	

	@NamedNativeQuery(name=QueryConstants.NATIVE_CUSTOMER_SEARCH, query="select c.FIRST_NAME, c.LAST_NAME from Customer c where c.FIRST_NAME like ?"),

})

@EntityListeners({LoggingListener.class})
public class Customer {

	@Id
	@Column(name="CUSTOMER_PK")
	@SequenceGenerator (name="custSeq", sequenceName="SEQ_TEST", allocationSize=1)
	@GeneratedValue(generator="custSeq")
	
	private long pk;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
	private CustomerDetails CustomerDetails;
	
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	


	public List<CustomerOrderEntity> getCustomerOrders() {
		
		if(customerOrders==null){
			customerOrders= new ArrayList<CustomerOrderEntity>();
		}
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrderEntity> customerOrders) {
		this.customerOrders = customerOrders;
	}

	@Column(name="LAST_NAME")
	private String lastName;

	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
	private List<CustomerOrderEntity> customerOrders;
	
	
	
	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public CustomerDetails getCustomerDetails() {
		
		
		
		
		return CustomerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		CustomerDetails = customerDetails;
	}
	

}
