package planningTool.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.entities.Users;
import planningTool.services.CustomersServices;
import planningTool.services.ProjectsServices;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/")
public class IndexController {

	//test controller
	
	@Autowired
	UsersService usersService;
	@Autowired
	CustomersServices customersServices;
	@Autowired
	ProjectsServices projectsServices;

	@RequestMapping()
	public Projects handelDefault() {

		Users user = new Users();
		user.setAdmin(true);
		user.setFirstName("adminTest");
		user.setLastName("tester");
		user.setPassword("test");
		user.setUsername("admin");
		
		Projects project = new Projects();
		project.setProjectName("stage");
		project.addUserOnProject(user);
		project.setStartDate(Date.valueOf("2018-05-03"));

		Customers customer = new Customers();
		customer.setCustomerName("abano");
		customer.addProject(project);
		
		user.addProject(project);
		project.setOwnerOfProject(customer);
		
		//customersServices.saveCustomer(customer);
		projectsServices.saveProject(project);
		//usersService.saveUsers(user);
		
		System.out.println(user);
		System.out.println("---------------------------------------------------------------");
		System.out.println(usersService.getUserByUsername("admin"));
		System.out.println("---------------------------------------------------------------");
		System.out.println(project);
		System.out.println("---------------------------------------------------------------");
		System.out.println(projectsServices.getProjectByProjectName("stage"));
		System.out.println("---------------------------------------------------------------");
		System.out.println(customer);
		System.out.println("---------------------------------------------------------------");
		System.out.println(customersServices.getCustomerByName("abano"));
		System.out.println("---------------------------------------------------------------");

		
		
		
		
		
		//return usersService.getUserByUsername("admin");
		return projectsServices.getProjectByProjectName("stage");
		//return customersServices.getCustomerByName("abano");
	}

}
