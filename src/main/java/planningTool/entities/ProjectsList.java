package planningTool.entities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectsList {
	
	//List for front-end

	private List<Projects> allProjects;

	public List<Projects> getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List<Projects> allProjects) {
		this.allProjects = (List<Projects>) allProjects;
	}

}
