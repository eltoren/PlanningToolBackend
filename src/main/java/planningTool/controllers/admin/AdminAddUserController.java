package planningTool.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Users;
import planningTool.services.UsersService;

@RestController
@RequestMapping("/addUsers")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddUserController {

	@Autowired
	UsersService usersService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Users addNewUser(@RequestBody Users user) {
		usersService.saveUsers(user);
		System.out.println("saved user");
		return user;

	}

}
