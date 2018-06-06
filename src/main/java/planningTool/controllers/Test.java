package planningTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Projects;
import planningTool.entities.ProjectsList;
import planningTool.services.ProjectsServices;

@RestController
@RequestMapping("/Test")
@CrossOrigin(origins = "http://localhost:4200")
public class Test {
	
	@Autowired
	ProjectsServices projectsServices;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Projects testMethode(@RequestBody ProjectsList projectsList) {
		Projects projects = projectsServices.getProjectByProjectName("stage6");
		System.out.println(projects);
		return projects;
	}
	
}
