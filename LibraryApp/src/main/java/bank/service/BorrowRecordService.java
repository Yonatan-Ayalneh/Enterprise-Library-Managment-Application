package bank.service;

import bank.dao.BorrowRecordRepository;
import bank.dao.CustomerLRepository;
import bank.dao.ReservationRepository;
import bank.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class BorrowRecordService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private CustomerLRepository customerLRepository;

    @Autowired
    private LibraryProperties libraryProperties;



    Logger logger = LoggerFactory.getLogger(BorrowRecordService.class);

    @Value(" ${allowedBooks}")
    String allowedbooks;

    @Value(" ${urlBookCatalog}")
    String urlBookCatalog;



    public BorrowRecord addBorrowRecord(BorrowRequest borrowRequest, Integer id) throws JsonProcessingException {

        Book book = restTemplate.getForObject("http://localhost:8090/" + id, Book.class);
        CustomerL customerL = customerLRepository.getById(borrowRequest.getCustomer().getCustomerNumber());

      if (book.getBookStatus() == BookStatus.AVAILABLE && customerL.getNumberOfBooks() < libraryProperties.getAllowedBooks()) {
            LocalDate date = LocalDate.now();
            BorrowRecord borrowRecord = new BorrowRecord();
//
            borrowRecord.setCustomerL(borrowRequest.getCustomer());
            borrowRecord.setDuration(borrowRequest.getDuration());
            // reservation.setBook(book);

            // reservation.getBook().setBookStatus(BookStatus.RESERVED);
            borrowRecord.setBookId(book.getId());

            int incrementbook = customerL.getNumberOfBooks() + 1;
            borrowRecord.setId(book.getId());

            int copies = book.getCopies() - 1;
            //reservation.setId(String.valueOf(id));

            restTemplate.put("http://localhost:8090/update-status/" + id, BookStatus.BORROWED, BookStatus.class);
            customerL.setNumberOfBooks(incrementbook);
            borrowRecordRepository.save(borrowRecord);

            Book copiessync = new Book(book.getId(), book.getIsbn(),book.getAuthor(),book.getTitle(),copies,book.getBookStatus());
            ObjectMapper objectMapper = new ObjectMapper();
            String copiessyncAsString = objectMapper.writeValueAsString(copiessync);

            System.out.println("Sending a JMS message:" + copiessync);
            jmsTemplate.convertAndSend("testQueue",copiessyncAsString);

           logger.trace("Working on borrowing activity");
            return borrowRecord;
        } else
            System.out.println("Book is not available");
        return null;

    }

    public BorrowRecord getBorrowRecord(Integer id){

        BorrowRecord record = borrowRecordRepository.getById(id);

        return record;
    }
}
