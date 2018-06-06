package planningTool.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Projects;
import planningTool.entities.Users;
import planningTool.services.CustomersServices;
import planningTool.services.ProjectsServices;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/addProjects")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddProjectController {

	@Autowired
	ProjectsServices projectsService;

	@Autowired
	UsersService usersService;
	
	@Autowired 
	CustomersServices customersServices;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Projects addNewProject(@RequestBody Projects projects) {
		Projects saveProject = handleProject(projects);
		System.out.println(saveProject);
		projectsService.saveProject(saveProject);
		System.out.println("project saved");
		return projects;
	}
	
	private Projects handleProject(Projects projects) {
		projects = getUsers(projects);
		projects = getCustomer(projects);
		return projects;
	}

	private Projects getUsers(Projects projects) {
		if (!projects.getUsersOnProject().isEmpty()) {
			List<Users> list = new ArrayList<>();
			for (Users user : projects.getUsersOnProject()) {
				System.out.println(user);
				list.add(usersService.findUserById(user.getId()));
			}
			projects.setUsersOnProject(list);
		}
		return projects;
	}
	
	private Projects getCustomer(Projects projects) {
		if (!(projects.getOwnerOfProject() == null|| projects.getOwnerOfProject().getCustomerName().isEmpty())) {
			projects.setOwnerOfProject(customersServices.getCustomerByName(projects.getOwnerOfProject().getCustomerName()));
		}
		return projects;
	}
	
	

}
