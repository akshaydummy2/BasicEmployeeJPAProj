package entity.manager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	public void addEmployee(Employee emp) {

		EmployeeDBService empdb = new EmployeeDBService();

		empdb.insertemp(emp);

	}

	public void deleteEmployee(int id) {
		EmployeeDBService empdb = new EmployeeDBService();

		empdb.delete(id);

	}

	public List<Employee> getall() {
		EmployeeDBService empdb = new EmployeeDBService();
		List<Employee> emps = new ArrayList<Employee>();

		emps = empdb.getallemp();

		return emps;
	}

	public Employee getempid(int id) {
		EmployeeDBService empdb = new EmployeeDBService();
		Employee emp = empdb.getempbyid(id);

		return emp;
	}

	public Employee getempname(String name) {
		EmployeeDBService empdb = new EmployeeDBService();
		Employee emp = empdb.getempbyname(name);

		return emp;
	}

	public void update(Employee emp) {

		EmployeeDBService empdb = new EmployeeDBService();

		empdb.updateemp(emp);
	}

}
