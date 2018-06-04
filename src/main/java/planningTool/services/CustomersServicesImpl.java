package planningTool.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.entities.Users;
import planningTool.repositories.CustomersRepository;

@Service
public class CustomersServicesImpl implements CustomersServices {

	@Autowired
	private CustomersRepository repo;

	@Override
	public void saveCustomer(Customers customer) {
		repo.save(customer);
	}

	@Override
	public void deleteCustomerById(long id) {
		repo.delete(id);
	}

	@Override
	public void deleteCustomerByCustomer(Customers customer) {
		repo.delete(customer);
	}

	@Override
	public Customers findCustomerById(long id) {
		return repo.findOne(id);
	}

	@Override
	public Customers getCustomerByName(String name) {
		List<Customers> allCustomers = this.getAllCustomers();
		if (!allCustomers.isEmpty()) {
			for (Customers customer : allCustomers) {
				if (customer.getCustomerName().equalsIgnoreCase(name)) {
					return customer;
				}
			}
		}
		return null;
	}

	@Override
	public boolean doesCustomerExistsById(long id) {
		return repo.exists(id);
	}

	@Override
	public boolean doesCustomerExistsByCustomerName(String customerName) {
		if (this.getCustomerByName(customerName) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Customers> getAllCustomers() {
		return (List<Customers>) repo.findAll();
	}

	@Override
	public List<Projects> getAllProjectsOfCustomer(Customers customer) {
		return customer.getProjects();
	}

	@Override
	public List<Users> getAllUsersWorkingAtCustomer(Customers customer) {
		List<Projects> allProjectsOfCustomer = getAllProjectsOfCustomer(customer);
		List<Users> allWorkingUsersAtCustomer = new ArrayList<>();
		for (Projects project : allProjectsOfCustomer) {
			List<Users> allUsersOnProject = project.getUsersOnProject();
			for (Users user : allUsersOnProject) {
				allWorkingUsersAtCustomer.add(user);
			}
		}
		return allWorkingUsersAtCustomer;
	}

}
