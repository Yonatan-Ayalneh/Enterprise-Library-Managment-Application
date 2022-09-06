package bank.domain;

import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.Entity;
import javax.persistence.Id;



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
