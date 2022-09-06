package client;

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
