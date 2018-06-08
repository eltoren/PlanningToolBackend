package planningTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.UsersList;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/UsersList")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersListController {

	@Autowired
	UsersService usersService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public UsersList getAllProjects(@RequestBody UsersList usersList) {
		System.out.println(usersList);
		usersList.setAllUsers(usersService.getAllUsers());
		System.out.println("getting projects");
		System.out.println(usersList);
		usersList = handleUsersList(usersList);
		return usersList;
	}

	private UsersList handleUsersList(UsersList usersList) {
		for (int i = 0; i < usersList.getAllUsers().size(); i++) {
			for (int j = 0; j < usersList.getAllUsers().get(i).getProjectsOfUser().size(); j++) {
				usersList.getAllUsers().get(i).getProjectsOfUser().get(j).getUsersOnProject().clear();
			}
		}
		return usersList;
	}
}