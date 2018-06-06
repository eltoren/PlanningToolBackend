package planningTool.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope=Projects.class)
public class Projects {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true)
	private String projectName;

	@ManyToOne(cascade=CascadeType.ALL)
	private Customers ownerOfProject;

	@ManyToMany(cascade=CascadeType.ALL)
	private List<Users> usersOnProject = new ArrayList<>();

	@Column(nullable = false)
	private Date startDate;

	private Date endDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Customers getOwnerOfProject() {
		return ownerOfProject;
	}

	public void setOwnerOfProject(Customers ownerOfProject) {
		this.ownerOfProject = ownerOfProject;
	}

	public List<Users> getUsersOnProject() {
		return usersOnProject;
	}

	public void setUsersOnProject(List<Users> usersOnProject) {
		this.usersOnProject = usersOnProject;
	}

	public void addUserOnProject(Users user) {
		this.usersOnProject.add(user);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		String usersOnProjectDesc = "";
		String customersName = "";
		if (!(ownerOfProject == null || ownerOfProject.equals(null))) {
			customersName = ownerOfProject.getCustomerName();
		}
		if (!(usersOnProject == null || usersOnProject.equals(null))) {
			for (Users user : this.usersOnProject) {
				usersOnProjectDesc = usersOnProjectDesc + user.getFirstName() + " " + user.getLastName() + ", ";
			}
		}
		return "Projects [id=" + id + ", projectName=" + projectName + ", ownerOfProject=" + customersName
				+ ", usersOnProject=" + usersOnProjectDesc + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
