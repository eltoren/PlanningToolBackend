package planningTool.entities;


import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsersList {
	
	//List for front-end

	private List<Users> allUsers;

	public List<Users> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<Users> list) {
		this.allUsers = list;
	}

	@Override
	public String toString() {
		String users = "";
		for (Users user : allUsers) {
			users = users + user + ",\n";
		}
		return "UsersList [allUsers=" + users + "]";
	}
	
	

	

}
