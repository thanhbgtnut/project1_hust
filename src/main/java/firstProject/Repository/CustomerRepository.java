package firstProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import firstProject.entity.Account;

@Repository
public interface CustomerRepository extends JpaRepository<Account, Long> {
	
	@Query(value="select a from Account a where a.id = ?1 and a.status = 1")
	Optional<Account> getAllAccountActive(Long id);
	
}
