package bank.domain;

public class BorrowRequest {

    private CustomerL customer;
    private Duration duration;


    public BorrowRequest() {
    }

    public BorrowRequest(CustomerL customer) {
        this.customer = customer;
    }

    public CustomerL getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerL customer) {
        this.customer = customer;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
