package entity.manager;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Department dept = new Department();
		dept.setName("SALES");
		dept.setId(2);
		
		Address address=new Address();
		
		address.setDoNum("#13");
		address.setLocality("Bangalore");
		address.setPostCode("123456");
		address.setStreet("vvpuram");

		Employee emp = new Employee();
		emp.setEmailid("nagesh@gmail.com");
		emp.setEname("nagesh");
		emp.setEsalary(1000);
		emp.setDept(dept);
		emp.setAddress(address);

		EmployeeService service = new EmployeeService();
		service.addEmployee(emp);

		// service.deleteEmployee(151);

		/*// Employee employee=service.getempname("suresh");
		EmployeeService service = new EmployeeService();
		 List<Employee> emps=service.getall();*/

	}
}
