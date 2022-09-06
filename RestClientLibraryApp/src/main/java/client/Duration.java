package client;


import java.time.LocalDate;


public class Duration {


    private String id;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Duration() {
    }

    public Duration(LocalDate rentalDate, LocalDate returnDate) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
