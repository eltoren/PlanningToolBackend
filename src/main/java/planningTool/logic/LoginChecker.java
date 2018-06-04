package planningTool.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import planningTool.entities.Users;
import planningTool.services.UsersService;

@Component
public class LoginChecker {

	@Autowired
	UsersService usersService;

	public Users proccesLogin(String username, String password) {
		Users user;
		if (usersService.doesUserExistsByUsername(username)) {
			user = usersService.getUserByUsername(username);

			if (this.doesUsernameAndPasswordMatch(user, password)) {
				return user;

			} else {
				user = new Users();
				user.setPassword("password does not match the username");
			}

		} else {
			user = new Users();
			user.setUsername("username does not exists");
		}

		return user;
	}

	public Users proccesAdminLogin(String username, String password) {
		Users user;
		if (usersService.doesUserExistsByUsername(username)) {
			user = usersService.getUserByUsername(username);

			if (this.isAdmin(user)) {

				if (this.doesUsernameAndPasswordMatch(user, password)) {
					return user;
				} else {
					user = new Users();
					user.setUsername("password does not match the username");
				}
			} else {
				user = new Users();
				user.setUsername("user is not a admin");
			}

		} else {
			user = new Users();
			user.setUsername("username does not exists");
		}

		return user;
	}

	private boolean doesUsernameAndPasswordMatch(Users user, String password) {
		if (user.getPassword().contentEquals(password)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAdmin(Users user) {
		if (user.isAdmin()) {
			return true;
		} else {
			return false;
		}
	}

}
