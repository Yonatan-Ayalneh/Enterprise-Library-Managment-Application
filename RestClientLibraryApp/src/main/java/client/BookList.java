package client;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookList() {
        bookList = new ArrayList<>();
    }
}
