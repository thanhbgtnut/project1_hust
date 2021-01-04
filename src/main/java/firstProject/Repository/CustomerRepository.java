package firstProject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import firstProject.entity.Account;

@Repository
public interface CustomerRepository extends JpaRepository<Account, Long> {
	
	@Query(value="select a from Account a where a.id = ?1 and a.status = 1")
	Optional<Account> getAccountActiveById(Long id);
	
	@Query(value="select a from Account a where a.status = 1")
	Page<Account> getAllAccountActive(Pageable pageAble);

	@Query(value="select a from Account a where a.status = 1")
	List<Account> getAllAccountActive();

}
