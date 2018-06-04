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
@RequestMapping("/editUsers")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminEditUserController {
	
	@Autowired
	UsersService usersService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Users editUser(@RequestBody Users user) {
		System.out.println(user);
		return usersService.getUserByUsername(user.getUsername());
		
	}
	
	

}
