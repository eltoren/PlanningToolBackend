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
import planningTool.services.ProjectsServices;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/addUsers")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddUserController {

	@Autowired
	UsersService usersService;

	@Autowired
	ProjectsServices projectsServices;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Users addNewUser(@RequestBody Users user) {
		System.out.println("incoming user: " + user);
		user = setProperties(user);
		System.out.println("proccesed user: " + user);
		usersService.saveUsers(user);
		System.out.println("saved user");
		return user;

	}

	private Users setProperties(Users user) {
		List<Projects> projects = new ArrayList<>();
		int size = user.getProjectsOfUser().size();

		for (int i = 0; i < size; i++) {
			projects.add(projectsServices.getProjectByProjectName(user.getProjectsOfUser().get(i).getProjectName()));
		}

		user.emptyProjectList();

		for (int i = 0; i < size; i++) {
			user.addProject(projects.get(i));
			projectsServices.getProjectByProjectName(projects.get(i).getProjectName()).addUserOnProject(user);
		}
		return user;
	}
}
