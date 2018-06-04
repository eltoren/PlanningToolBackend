package planningTool.services;

import java.util.List;

import planningTool.entities.Customers;
import planningTool.entities.Projects;
import planningTool.entities.Users;

public interface CustomersServices {

	public void saveCustomer(Customers customer);

	public void deleteCustomerById(long id);

	public void deleteCustomerByCustomer(Customers customer);

	public Customers findCustomerById(long id);
	
	public Customers getCustomerByName(String name);

	public boolean doesCustomerExistsById(long id);
	
	public boolean doesCustomerExistsByCustomerName(String customerName);

	public List<Customers> getAllCustomers();

	public List<Projects> getAllProjectsOfCustomer(Customers customer);

	public List<Users> getAllUsersWorkingAtCustomer(Customers customer);

}
