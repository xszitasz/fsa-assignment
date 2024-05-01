package sk.posam.fsa.jpa;

import org.springframework.stereotype.Repository;
import sk.posam.fsa.Credit;
import sk.posam.fsa.CreditRepository;

import java.util.Optional;

@Repository
public class JpaCreditRepositoryAdapter implements CreditRepository {
    private final CreditSpringDataRepository creditSpringDataRepository;

    public JpaCreditRepositoryAdapter(CreditSpringDataRepository creditSpringDataRepository) {
        this.creditSpringDataRepository = creditSpringDataRepository;
    }

    @Override
    public Optional<Credit> get(Long id) {
        return this.creditSpringDataRepository.findById(id);
    }

    @Override
    public void update(Credit credit) {
        creditSpringDataRepository.save(credit);
    }
}
