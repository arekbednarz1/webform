package pl.arekbednarz.webform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.webform.model.Owner;

@Repository
public interface UserRepository extends JpaRepository<Owner,Long> {
    Owner findUserByEmail(String email);

    Owner findUserByPasswordBefore(String password);

    Owner findUserById(Long id);

}
