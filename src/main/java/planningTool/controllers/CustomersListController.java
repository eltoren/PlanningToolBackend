package planningTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.CustomersList;
import planningTool.services.CustomersServices;

@RestController
@RequestMapping("/CustomersList")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomersListController {

	@Autowired
	CustomersServices customersServices;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public CustomersList getAllProjects(@RequestBody CustomersList customersList) {
		System.out.println(customersList);
		customersList.setAllCustomers(customersServices.getAllCustomers());
		System.out.println("getting projects");
		System.out.println(customersList);
		customersList = handleCustomerList(customersList);
		return customersList;
	}

	private CustomersList handleCustomerList(CustomersList customersList) {
		for (int i = 0; i < customersList.getAllCustomers().size(); i++) {
			for (int j = 0; j < customersList.getAllCustomers().get(i).getProjectsOfCustomer().size(); j++) {
				customersList.getAllCustomers().get(i).getProjectsOfCustomer().get(j).setOwnerOfProject(null);
			}
		}
		return customersList;
	}
}