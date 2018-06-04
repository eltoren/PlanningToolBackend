package planningTool.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Users;
import planningTool.logic.LoginChecker;


@RestController
@RequestMapping("/AdminLogin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminLoginController {

	@Autowired
	LoginChecker loginChecker;

	@RequestMapping(method = RequestMethod.POST)
	public Users handelLogin(@RequestBody Users loginUser) {
		
		System.out.println("logging in admin: " + loginUser);
		
		Users returnUser = loginChecker.proccesAdminLogin(loginUser.getUsername(), loginUser.getPassword());
		
		System.out.println("sending respons admin : " + returnUser);
		return returnUser;
	}


}