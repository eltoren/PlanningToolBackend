package planningTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Users;
import planningTool.logic.LoginChecker;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	LoginChecker loginChecker;

	@RequestMapping(method = RequestMethod.POST)
	public Users handelLogin(@RequestBody Users loginUser) {

		System.out.println("logging in user: " + loginUser);

		Users returnUser = loginChecker.proccesLogin(loginUser.getUsername(), loginUser.getPassword());

		System.out.println("sending respons user : " + returnUser);
		return returnUser;
	}
}