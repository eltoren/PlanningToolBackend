package planningTool.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Projects;
import planningTool.services.ProjectsServices;

@RestController
@RequestMapping("/addProjects")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddProjectController {
	
	@Autowired
	ProjectsServices projectsService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Projects addNewProject(@RequestBody Projects projects) {
		projectsService.saveProject(projects);
		System.out.println("project saved");
		return projects;
		
	}

}
