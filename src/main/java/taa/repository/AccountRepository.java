package taa.repository;

import taa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Long, Account>
{

}
