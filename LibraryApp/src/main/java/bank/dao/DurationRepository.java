package bank.dao;

import bank.domain.Duration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DurationRepository extends JpaRepository<Duration, Integer> {
}
