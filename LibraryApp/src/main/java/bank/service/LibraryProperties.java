package bank.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@ConfigurationProperties
@Service
public class LibraryProperties {

    private int allowedBooks;
    private String urlBookCatalog;
    private double lateFee;
    private int numberOfWeeksAllowed;


    public int getAllowedBooks() {
        return allowedBooks;
    }

    public void setAllowedBooks(int allowedBooks) {
        this.allowedBooks = allowedBooks;
    }

    public String getUrlBookCatalog() {
        return urlBookCatalog;
    }

    public void setUrlBookCatalog(String urlBookCatalog) {
        this.urlBookCatalog = urlBookCatalog;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public int getNumberOfWeeksAllowed() {
        return numberOfWeeksAllowed;
    }

    public void setNumberOfWeeksAllowed(int numberOfWeeksAllowed) {
        this.numberOfWeeksAllowed = numberOfWeeksAllowed;
    }
}
