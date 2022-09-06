package bank.dao;

import bank.domain.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, Integer> {

    //List<ReturnRecord> getAllLateBooks();
}
