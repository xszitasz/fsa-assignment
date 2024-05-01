package sk.posam.fsa;

import java.util.Optional;

public interface CreditRepository {
    Optional<Credit> get(Long id);
    void update(Credit credit);
}
