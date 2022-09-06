package bank.domain;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CustomerL customer;
    private Integer bookId;
    private LocalDate reservationDate;



    public Reservation() {
    }

    public Reservation(CustomerL customer, Integer bookId,LocalDate reservationDate) {
        this.customer = customer;
        this.bookId = bookId;
        this.reservationDate = reservationDate;
    }

    public Reservation(Integer bookId, LocalDate reservationDate) {
        this.bookId = bookId;
        this.reservationDate = reservationDate;
    }

    public CustomerL getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerL customer) {
        this.customer = customer;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
