package client;

public class ReservationRequest {

    private CustomerL customer;


    public ReservationRequest() {
    }



    public ReservationRequest(CustomerL customer) {
        this.customer = customer;
    }

    public CustomerL getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerL customer) {
        this.customer = customer;
    }

}
