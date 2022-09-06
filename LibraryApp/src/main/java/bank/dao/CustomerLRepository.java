package bank.dao;

import bank.domain.CustomerL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLRepository extends JpaRepository<CustomerL,Integer> {

    CustomerL findByName(String name);
}
