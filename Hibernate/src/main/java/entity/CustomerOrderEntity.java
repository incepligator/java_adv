package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_ORDER")
public class CustomerOrderEntity {

	
	
	
	
	@Id
	@Column(name="ORDER_ID")
	@SequenceGenerator (name="custSeq", sequenceName="SEQ_TEST", allocationSize=1)
	@GeneratedValue(generator="custSeq")
	
	private Long pk;
	
	
	@Column(name="ORDER_NUMBER")
	private String orderNumber;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_FK")
	private Customer customer;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerOrderEntity [pk=" + pk + ", orderNumber=" + orderNumber + "]";
	}
	
	
}
