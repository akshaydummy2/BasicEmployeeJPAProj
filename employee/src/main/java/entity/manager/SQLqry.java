package entity.manager;

public interface SQLqry {
	
	static String GET_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employee WHERE empId=?";
	static String INSERT_EMPLOYEE_QUERY = "insert into employee (empName,empEmailId,empSalary)values (?,?,?)";
	static String DELETE_EMPLOYEE_BY_ID_QUERY = "DELETE FROM employee WHERE empId=? ";
	static String UPDATE_EMPLOYEE_BY_ID_QUERY = "UPDATE employee SET empname=?,empEmailid=?,empsalary=? where empid=?";
	static String SELECT_ALL_QUERY = "SELECT * FROM employee";
}
