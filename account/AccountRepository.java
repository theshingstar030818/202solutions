package app.account;

import app.parse.ParseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import parse4j.ParseUser;

@Repository
public interface AccountRepository extends ParseRepository<ParseUser, String> {

	Account findOneByEmail(String email);
	Account findOne(String id);

	@Query("select count(a) > 0 from Account a where a.email = :email")
	boolean exists(@Param("email") String email);

}
