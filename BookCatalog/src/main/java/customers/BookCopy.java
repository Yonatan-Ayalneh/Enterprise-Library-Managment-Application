package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class BookCopy {


    private int id;

    private int scancode;

    private BookStatus bookStatus;

    public BookCopy(int scancode) {
        this.scancode = scancode;
    }

    public int getScancode() {
        return scancode;
    }

    public void setScancode(int scancode) {
        this.scancode = scancode;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
