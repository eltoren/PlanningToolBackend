package planningTool.services;

import java.util.List;

import planningTool.entities.Projects;
import planningTool.entities.Users;

public interface UsersService {

	public void saveUsers(Users user);

	public void deleteUserById(long id);

	public void deleteUserByUsername(Users user);

	public Users findUserById(long id);

	public Users getUserByUsername(String username);

	public boolean doesUserExistsById(long id);

	public boolean doesUserExistsByUsername(String username);

	public List<Users> getAllUsers();

	public List<Users> getAllAdmins();

	public List<Users> getAllRegularUsers();

	public List<Users> getUsersByFirstName(String firstname);

	public List<Users> getUsersByLastName(String lastName);
	
	public List<Projects> getAllProjectsOfUser(Users user);

	public void changePassword(Users user, String oldPassword, String newPassword);

}
