package sk.posam.fsa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.Credit;

@Repository
public interface CreditSpringDataRepository extends JpaRepository<Credit, Long> {
}
