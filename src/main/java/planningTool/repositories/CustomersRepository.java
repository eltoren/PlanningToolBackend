package planningTool.repositories;

import org.springframework.data.repository.CrudRepository;

import planningTool.entities.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Long> {

}
