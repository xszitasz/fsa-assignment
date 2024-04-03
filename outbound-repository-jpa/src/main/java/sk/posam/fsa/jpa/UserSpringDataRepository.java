package sk.posam.fsa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.User;

import java.util.Optional;

@Repository
public interface UserSpringDataRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
