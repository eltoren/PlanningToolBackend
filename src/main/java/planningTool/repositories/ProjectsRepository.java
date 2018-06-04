package planningTool.repositories;

import org.springframework.data.repository.CrudRepository;

import planningTool.entities.Projects;

public interface ProjectsRepository extends CrudRepository<Projects, Long> {

}
