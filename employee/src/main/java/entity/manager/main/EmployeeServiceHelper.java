package entity.manager.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.manager.models.Address;
import entity.manager.models.Department;
import entity.manager.models.Employee;
import entity.manager.service.DepartmentService;
import entity.manager.service.EmployeeService;

public class EmployeeServiceHelper {

	public static void main(String[] args) {
		EmployeeServiceHelper service = new EmployeeServiceHelper();
		Employee emp = service.getEmpById(service.addEmployee());
		Iterator<Address> it = emp.getAddresses().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getLocality());
		}
	}

	public int addEmployee() {
		EmployeeService service = new EmployeeService();
		DepartmentService dService = new DepartmentService();
		Department dept = dService.getDeptById(1);

		Address address = new Address();
		address.setDoorNum("#13");
		address.setLocality("Bangalore");
		address.setPostCode("123456");
		address.setStreet("vvpuram");

		Employee emp = new Employee();
		emp.setDepartment(dept);
		emp.setEmail("abcd@gmail.com");
		emp.setName("abc");
		emp.setSalary(12345);
		return service.addEmployee(emp);
	}

	public void deleteEmployee(int id) {
		EmployeeService service = new EmployeeService();
		service.deleteEmployee(id);
	}

	public List<Employee> getAllEmp() {
		EmployeeService service = new EmployeeService();
		List<Employee> emps = new ArrayList<Employee>();
		emps = service.getAllEmp();
		return emps;
	}

	public Employee getEmpById(int id) {
		EmployeeService service = new EmployeeService();
		Employee emp = service.getEmpById(id);
		return emp;
	}

	public List<Employee> searchEmpsByName(String name) {
		EmployeeService service = new EmployeeService();
		List<Employee> emps = service.searchEmpsByName(name);
		return emps;
	}

	public void updateEmp(int id) {
		EmployeeService service = new EmployeeService();
		Employee emp = service.getEmpById(id);
		emp.getAddresses().get(0).setDoorNum("#123");
		service.updateEmp(emp);
	}
}
