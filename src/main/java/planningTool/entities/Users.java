package planningTool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Users {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	private boolean admin;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column
	private String functions;

	@ManyToMany(mappedBy = "usersOnProject", cascade=CascadeType.ALL)
	private List<Projects> projectsOfUser = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public List<Projects> getProjectsOfUser() {
		return projectsOfUser;
	}

	public void setProjectsOfUser(List<Projects> projectsOfUser) {
		this.projectsOfUser = projectsOfUser;
	}

	public void addProject(Projects project) {
		this.projectsOfUser.add(project);
	}

	public void removeProject(Projects project) {
		this.projectsOfUser.remove(project);
	}

	public void addProjectList(List<Projects> projects) {
		for (Projects project : projects) {
			this.projectsOfUser.add(project);
		}
	}

	public void removeProjectList(List<Projects> projects) {
		for (Projects project : projects) {
			this.projectsOfUser.remove(project);
		}
	}
	
	public void emptyProjectList() {
		this.projectsOfUser.clear();
	}

	@Override
	public String toString() {
		String projects = "";
		for (Projects project : this.projectsOfUser) {
			projects = projects + project.getProjectName() + ", ";
		}
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", functions=" + functions
				+ ", projectsOfUser=" + projects + "]";
	}

}
