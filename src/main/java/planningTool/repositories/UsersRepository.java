package planningTool.repositories;

import org.springframework.data.repository.CrudRepository;

import planningTool.entities.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {

}
