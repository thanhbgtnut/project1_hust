package firstProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firstProject.entity.Account;

@Repository
public interface CustomerRepository extends JpaRepository<Account, Long> {
}
