package client;

public class BookCopy {


    private int id;

    private int scancode;

    public BookCopy() {
    }

    public BookCopy(int scancode) {
        this.scancode = scancode;
    }

    public int getScancode() {
        return scancode;
    }

    public void setScancode(int scancode) {
        this.scancode = scancode;
    }
}
