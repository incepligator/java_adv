package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;



@Entity
@Table(name="student")
@NamedQuery( query = "Select e from Student e where e.phone = :ph", name = "find Student by ph" )

public class Student {

	@Id
	@Column(name="STUDENT_PK")
	@SequenceGenerator (name="studSeq", sequenceName="SEQ_TEST", allocationSize=1)
	@GeneratedValue(generator="studSeq")
	
	private long pk;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE")
	private long phone;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
