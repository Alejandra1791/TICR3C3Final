package Repository.crudRepository;

import Entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
}