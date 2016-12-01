package entity.manager;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int eid;

	private String ename;

	private String emailid;

	private int esalary;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Department dept;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getEsalary() {
		return esalary;
	}

	public void setEsalary(int esalary) {
		if (esalary <= 0)
			this.esalary = 1000;
		else
			this.esalary = esalary;

	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee() {

	}

}
