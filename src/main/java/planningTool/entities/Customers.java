package planningTool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customers {

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false)
	private String customerName;

	@OneToMany(mappedBy = "ownerOfProject", cascade = CascadeType.ALL)
	private List<Projects> projectsOfCustomer = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Projects> getProjects() {
		return projectsOfCustomer;
	}

	public void setProjects(List<Projects> projects) {
		this.projectsOfCustomer = projects;
	}

	public void addProject(Projects project) {
		projectsOfCustomer.add(project);
	}

	public void removeProject(Projects project) {
		projectsOfCustomer.remove(project);
	}

	public void addProjectsList(List<Projects> projects) {
		for (Projects project : projects) {
			projectsOfCustomer.add(project);
		}
	}

	public void removeProjectList(List<Projects> projects) {
		for (Projects project : projects) {
			projectsOfCustomer.remove(project);
		}
	}

	@Override
	public String toString() {
		String projectsDesc = "";
		if (!(projectsOfCustomer == null || projectsOfCustomer.isEmpty())) {
			for (Projects project : projectsOfCustomer) {
				projectsDesc = projectsDesc + project.getProjectName() + ", ";
			}
		}
		return "Customers [id=" + id + ", customerName=" + customerName + ", projects=" + projectsDesc + "]";
	}

}
