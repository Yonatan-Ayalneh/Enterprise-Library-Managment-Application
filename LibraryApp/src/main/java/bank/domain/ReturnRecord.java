package bank.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReturnRecord {

    @Id
    @GeneratedValue
    private Integer id;


    private Integer bookId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_l_customer_number")
    private CustomerL customerL;
    private LocalDate returnDate;
    @Nullable
    private double latefee;



    public ReturnRecord() {
    }

    public ReturnRecord(Integer bookId, CustomerL customerL, LocalDate returnDate) {
        this.returnDate = returnDate;
        this.bookId = bookId;
        this.customerL = customerL;
    }


    public CustomerL getCustomerL() {
        return customerL;
    }

    public void setCustomerL(CustomerL customerL) {
        this.customerL = customerL;
    }



    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getLatefee() {
        return latefee;
    }

    public void setLatefee(double latefee) {
        this.latefee = latefee;
    }
}
