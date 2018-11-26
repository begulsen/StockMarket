package repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@RepositoryRestResource()
public interface UserRepo extends CrudRepository<User, Integer> {
	@Modifying
	@Transactional
	void deleteUserById(Integer id);
	
    User findUserById(Integer id);
}
