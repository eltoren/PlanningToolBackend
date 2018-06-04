package planningTool.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planningTool.entities.Projects;
import planningTool.entities.Users;
import planningTool.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository repo;

	@Override
	public void saveUsers(Users user) {
		repo.save(user);

	}

	@Override
	public void deleteUserById(long id) {
		repo.delete(id);

	}

	@Override
	public void deleteUserByUsername(Users user) {
		repo.delete(user);

	}

	@Override
	public Users findUserById(long id) {
		return repo.findOne(id);
	}

	@Override
	public Users getUserByUsername(String username) {
		List<Users> allUsers = this.getAllUsers();
		if (!allUsers.isEmpty()) {
			for (Users use : allUsers) {
				if (use.getUsername().equalsIgnoreCase(username)) {
					return use;
				}
			}
		}
		return null;
	}

	@Override
	public boolean doesUserExistsById(long id) {
		return repo.exists(id);
	}

	@Override
	public boolean doesUserExistsByUsername(String username) {
		Users user = this.getUserByUsername(username);
		if (user == null || user.equals(null)) {
			return false;
		} else {
			return this.doesUserExistsById(user.getId());
		}

	}

	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) repo.findAll();

	}

	@Override
	public List<Users> getAllAdmins() {
		List<Users> allUsers = this.getAllUsers();
		for (Users user : allUsers) {
			if (!user.isAdmin()) {
				allUsers.remove(user);
			}
		}
		return allUsers;
	}

	@Override
	public List<Users> getAllRegularUsers() {
		List<Users> allUsers = this.getAllUsers();
		for (Users user : allUsers) {
			if (user.isAdmin()) {
				allUsers.remove(user);
			}
		}
		return allUsers;
	}

	@Override
	public List<Users> getUsersByFirstName(String firstname) {
		List<Users> allUsers = this.getAllUsers();
		List<Users> returnUsersList = new ArrayList<>();
		if (!allUsers.isEmpty()) {
			for (Users user : allUsers) {
				if (user.getFirstName().equalsIgnoreCase(firstname)) {
					returnUsersList.add(user);
				}
			}
			return returnUsersList;
		}
		return null;
	}

	@Override
	public List<Users> getUsersByLastName(String lastName) {
		List<Users> allUsers = this.getAllUsers();
		List<Users> returnUsersList = new ArrayList<>();
		if (!allUsers.isEmpty()) {
			for (Users user : allUsers) {
				if (user.getLastName().equalsIgnoreCase(lastName)) {
					returnUsersList.add(user);
				}
			}
			return returnUsersList;
		}
		return null;
	}

	@Override
	public List<Projects> getAllProjectsOfUser(Users user) {
		Users tempUser = this.getUserByUsername(user.getUsername());
		System.out.println(tempUser);
		List<Projects> returnList = tempUser.getProjectsOfUser();
		System.out.println(returnList);
		return returnList;
	}
	
	@Override
	public void changePassword(Users user, String oldPassword, String newPassword) {
		//WIP

	}

}
