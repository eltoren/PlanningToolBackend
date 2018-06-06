package planningTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.ProjectsList;
import planningTool.services.ProjectsServices;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/ProjectsList")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsListController {

	@Autowired
	ProjectsServices projectService;

	@Autowired
	UsersService usersService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ProjectsList getAllProjects(@RequestBody ProjectsList projectsList) {
		System.out.println(projectsList);
		projectsList.setAllProjects(projectService.getAllProjects());
		System.out.println("getting projects");
		System.out.println(projectsList);
		return projectsList;

	}

//	@ResponseBody
//	@RequestMapping(path = "/Users", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ProjectsList getAllProjectsOfUser(@RequestBody Users user) {
//		ProjectsList projectsList = new ProjectsList();
//		projectsList.setAllProjects(usersService.getAllProjectsOfUser(user));
//		return projectsList;
//	}
}