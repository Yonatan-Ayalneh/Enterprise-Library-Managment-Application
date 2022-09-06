package bank.service;

import bank.dao.BorrowRecordRepository;
import bank.dao.CustomerLRepository;
import bank.dao.ReservationRepository;
import bank.dao.ReturnRecordRepository;
import bank.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ReturnRecordService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private ReturnRecordRepository returnRecordRepository;

    @Autowired
    private LateCustomerPrinter lateCustomerPrinter;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private LibraryProperties libraryProperties;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerLRepository customerLRepository;

    @Value(" ${lateFee}")
    String lateFee;

    @Value(" ${numberOfWeeksAllowed}")
    String numberOfWeeksAllowed;

    /*@Scheduled(fixedDelay = 20000)
    public void printBankStatements() {
        lateCustomerPrinter.print(returnRecordRepository.findAll());
    }*/

    public ReturnRecord addReturnRecord(ReturnRequest returnRequest, Integer id) throws JsonProcessingException {

        Book book = restTemplate.getForObject("http://localhost:8090/" + id, Book.class);
        BorrowRecord borrowRecord = borrowRecordRepository.getById(id);
        if (book.getBookStatus() == BookStatus.BORROWED || book.getBookStatus() == BookStatus.RESERVED) {
            LocalDate date = LocalDate.now();
            LocalDate borrowedDate = borrowRecord.getDuration().getRentalDate();
            ReturnRecord returnRecord = new ReturnRecord();
//
            returnRecord.setCustomerL(borrowRecord.getCustomerL());
           // returnRecord.setDuration(returnRequest.getDuration());
            // reservation.setBook(book);

            // reservation.getBook().setBookStatus(BookStatus.RESERVED);
            returnRecord.setBookId(book.getId());
            returnRecord.setReturnDate(date);
            long daysBetween = DAYS.between(borrowedDate, date);
            long lateDays = daysBetween - 21;
            double totalfee = 1;
            if(daysBetween > (7 * libraryProperties.getNumberOfWeeksAllowed())){
                totalfee = lateDays * libraryProperties.getLateFee();
            }else{
                totalfee = 0.0;
            }
            returnRecord.setLatefee(totalfee);

            int copies = book.getCopies() + 1;
            //reservation.setId(String.valueOf(id));

            restTemplate.put("http://localhost:8090/update-status/" + id, BookStatus.AVAILABLE, BookStatus.class);

            //Optional<Reservation> reservation = reservationRepository.findById(String.valueOf((returnRequest.getCustomer().getCustomerNumber())));
           // CustomerL customerL = customerLRepository.getById(returnRequest.getCustomer().getCustomerNumber());

            returnRecordRepository.save(returnRecord);
            applicationEventPublisher.publishEvent(new BookReturnEvent(returnRequest.getCustomer().getName() + "Book you reserved"+ book.getTitle() + "returned"));
            System.out.println("test");

            Book copiessync = new Book(book.getId(), book.getIsbn(),book.getAuthor(),book.getTitle(),copies,book.getBookStatus());
            ObjectMapper objectMapper = new ObjectMapper();
            String copiessyncAsString = objectMapper.writeValueAsString(copiessync);

            System.out.println("Sending a JMS message:" + copiessync);
            jmsTemplate.convertAndSend("testQueue",copiessyncAsString);

            return returnRecord;
        } else
            System.out.println("Book is not available");
        return null;

    }
}
