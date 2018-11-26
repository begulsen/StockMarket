package repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import model.Share;

@RepositoryRestResource()
public interface ShareRepo extends CrudRepository<Share, Integer> {

	@Modifying
	@Transactional
	void deleteShareByCode(String code);
	
	@Query("SELECT t FROM share t where t.code = :code") 
    Share findShareByCode(String code);
}
