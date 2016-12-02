package entity.manager.controller;

import java.util.List;
import entity.manager.models.*;
import entity.manager.service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public class EmployeeServiceController {

	@PUT
	@Path("/addemp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(Employee obj) {
		EmployeeService service = new EmployeeService();
		service.addEmployee(obj);
		return "Success";
	}

	@GET
	@Path("/getemp")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@QueryParam("eid") int eid) {
		EmployeeService service = new EmployeeService();
		Employee emp = service.getEmpById(eid);
		return emp;
	}

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		EmployeeService service = new EmployeeService();
		List<Employee> emps = service.getAllEmp();
		System.out.println("return all emps");
		return emps;
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(Employee obj) {
		EmployeeService service = new EmployeeService();
		service.updateEmp(obj);
		return "Success";
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@QueryParam("eid") int eid) {
		EmployeeService service = new EmployeeService();
		service.deleteEmployee(eid);
		return "Success";
	}

}
