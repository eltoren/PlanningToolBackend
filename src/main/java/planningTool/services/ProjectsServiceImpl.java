package planningTool.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.entities.Users;
import planningTool.repositories.ProjectsRepository;

@Service
public class ProjectsServiceImpl implements ProjectsServices {

	@Autowired
	ProjectsRepository repo;

	@Override
	public void saveProject(Projects project) {
		repo.save(project);

	}

	@Override
	public void deleteProjectById(long id) {
		repo.delete(id);

	}

	@Override
	public void deleteProjectByProject(Projects ptoject) {
		repo.delete(ptoject);

	}

	@Override
	public Projects findProjectById(long id) {
		return repo.findOne(id);
	}

	@Override
	public Projects getProjectByProjectName(String projectName) {
		List<Projects> projects = this.getAllProjects();
		if (!projects.isEmpty()) {
			for (Projects project : projects) {
				if (project.getProjectName().equalsIgnoreCase(projectName)) {
					return project;
				}
			}
		}
		return null;
	}

	@Override
	public boolean doesProjectExistsById(long id) {
		return repo.exists(id);
	}

	@Override
	public boolean doesProjectExistsByProjectName(String projectName) {
		if (this.getProjectByProjectName(projectName) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Projects> getAllProjects() {
		return (ArrayList<Projects>) repo.findAll();
	}

	@Override
	public Customers getOwnerOfProject(Projects project) {
		return project.getOwnerOfProject();
	}

	@Override
	public List<Users> getUsersOnProject(Projects project) {
		return project.getUsersOnProject();
	}
}
