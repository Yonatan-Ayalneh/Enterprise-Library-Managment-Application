package bank.service;

import bank.dao.ReturnRecordRepository;
import bank.domain.CustomerL;
import bank.domain.ReturnRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
public class LateCustomerPrinter {

    @Autowired
    ReturnRecordRepository returnRecordRepository;

    @Scheduled(fixedDelay = 20000)
    public void print(){
        Collection<ReturnRecord> returnRecords = returnRecordRepository.findAll();
        for (ReturnRecord record : returnRecords) {
            CustomerL customerL = record.getCustomerL();
            Double fee = record.getLatefee();
            System.out.println("Statement for Account: " + customerL.getName());
            System.out.println("Account Holder: " + fee);
        }
        System.out.println("-----------------------------------------------------------------");

    }
}
