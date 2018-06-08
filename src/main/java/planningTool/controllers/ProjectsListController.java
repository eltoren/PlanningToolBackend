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
		projectsList = handleProjectList(projectsList);
		return projectsList;
	}

	private ProjectsList handleProjectList(ProjectsList projectsList) {
		for (int i = 0; i < projectsList.getAllProjects().size(); i++) {
			projectsList.getAllProjects().get(i).getOwnerOfProject().getProjectsOfCustomer().clear();
			for (int j = 0; j < projectsList.getAllProjects().get(i).getUsersOnProject().size(); j++) {
				projectsList.getAllProjects().get(i).getUsersOnProject().get(j).getProjectsOfUser().clear();
			}
		}
		return projectsList;
	}

}