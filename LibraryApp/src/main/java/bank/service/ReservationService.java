package bank.service;

import bank.dao.ReservationRepository;
import bank.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private ReservationRepository reservationRepository;

    Logger logger = LoggerFactory.getLogger(BorrowRecordService.class);



    public Reservation addReservation(ReservationRequest reservationRequest,  int id) {

       // BookList response = restTemplate.getForObject("http://localhost:8090/getbookbyisbn/" + isbn, BookList.class);


        Book book = restTemplate.getForObject("http://localhost:8090/" + id, Book.class);
        if (book.getBookStatus() == BookStatus.BORROWED) {
            LocalDate date = LocalDate.now();
            Reservation reservation = new Reservation();
//
            reservation.setCustomer(reservationRequest.getCustomer());

           // reservation.setBook(book);

           // reservation.getBook().setBookStatus(BookStatus.RESERVED);
            reservation.setBookId(book.getId());
            reservation.setReservationDate(date);
            //reservation.setId(String.valueOf(id));

            restTemplate.put("http://localhost:8090/update-status/" + id, BookStatus.RESERVED, BookStatus.class);

            reservationRepository.save(reservation);
            logger.debug("Working on debugging reservation");
            return reservation;
        } else
            System.out.println("Book is not available");
            return null;

    }
}
