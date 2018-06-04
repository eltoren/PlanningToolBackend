package planningTool.entities;


import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomersList {
	
	//List for front-end

	private List<Customers> allCustomers;

	public List<Customers> getAllCustomers() {
		return allCustomers;
	}

	public void setAllCustomers(List<Customers> list) {
		this.allCustomers = list;
	}

	

}
