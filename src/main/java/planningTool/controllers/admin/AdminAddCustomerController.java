package planningTool.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.services.CustomersServices;
import planningTool.services.ProjectsServices;

@RestController
@RequestMapping("/addCustomer")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddCustomerController {
	
	@Autowired
	CustomersServices customersServices;
	
	@Autowired
	ProjectsServices projectsServices;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Customers addNewCustomer(@RequestBody Customers customer) {
		Customers saveCustomer = handleCustomer(customer);
		System.out.println("incoming customer:" + customer);
		customersServices.saveCustomer(saveCustomer);
		System.out.println("customer saved");
		return saveCustomer;
	}
	
	private Customers handleCustomer(Customers customer) {
		customer = handleProjects(customer);
		return customer;
	}
	
	private Customers handleProjects(Customers customer) {
		if (!customer.getProjectsOfCustomer().isEmpty()) {
			List<Projects> list = new ArrayList<>();
			int size = customer.getProjectsOfCustomer().size();
			for (int i = 0; i < size; i++) {
				list.add(projectsServices.findProjectById(customer.getProjectsOfCustomer().get(i).getId()));
				projectsServices.findProjectById(customer.getProjectsOfCustomer().get(i).getId()).setOwnerOfProject(customer);
				System.out.println("added: " + customer.getProjectsOfCustomer().get(i));
			}
			customer.setProjectsOfCustomer(list);
		}
		return customer;
	}

}
