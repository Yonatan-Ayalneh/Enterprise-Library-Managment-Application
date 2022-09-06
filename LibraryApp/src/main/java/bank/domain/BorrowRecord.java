package bank.domain;

import javax.persistence.*;

@Entity
public class BorrowRecord {

    @Id

    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "duration_id")
    private Duration duration;
    private Integer bookId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_l_customer_number")
    private CustomerL customerL;



    public BorrowRecord() {
    }

    public BorrowRecord(Integer bookId) {
        this.bookId = bookId;
    }

    public BorrowRecord(Duration duration, Integer bookId, CustomerL customerL) {
        this.duration = duration;
        this.bookId = bookId;
        this.customerL = customerL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerL getCustomerL() {
        return customerL;
    }

    public void setCustomerL(CustomerL customerL) {
        this.customerL = customerL;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
