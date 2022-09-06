package bank.domain;

public class ReturnRequest {

    private CustomerL customer;


    public ReturnRequest() {
    }

    public ReturnRequest(CustomerL customer) {
        this.customer = customer;
    }

    public CustomerL getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerL customer) {
        this.customer = customer;
    }

}
