package planningTool.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import planningTool.entities.Customers;
import planningTool.services.CustomersServices;

@RestController
@RequestMapping("/addCustomer")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAddCustomerController {
	
	@Autowired
	CustomersServices customersServices;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Customers addNewCustomer(@RequestBody Customers customer) {
		customersServices.saveCustomer(customer);
		System.out.println("customer saved");
		return customer;
		
	}

}
