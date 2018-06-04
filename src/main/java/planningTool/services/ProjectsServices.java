package planningTool.services;

import java.util.List;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.entities.Users;


public interface ProjectsServices {

	public void saveProject(Projects project);

	public void deleteProjectById(long id);

	public void deleteProjectByProject(Projects ptoject);

	public Projects findProjectById(long id);
	
	public Projects getProjectByProjectName(String projectName);

	public boolean doesProjectExistsById(long id);
	
	public boolean doesProjectExistsByProjectName(String projectName);
	
	public List<Projects> getAllProjects();
	
	public Customers getOwnerOfProject(Projects project);
	
	public List<Users> getUsersOnProject(Projects project);

}
