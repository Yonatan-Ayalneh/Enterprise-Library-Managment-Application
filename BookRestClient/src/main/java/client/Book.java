package client;


import java.util.ArrayList;
import java.util.List;



public class Book {


    private int id;
    private String isbn;
    private String author;
    private String title;
    private int copies;
    private List<BookCopy> bookCopies = new ArrayList<BookCopy>();;


    private BookStatus bookStatus;


    public Book() {
    }

    public Book(int id, int copies) {
        this.id = id;
        this.copies = copies;
    }

    public Book(String isbn, String author, String title, int copies) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.copies = copies;
    }

    public Book(int id, String isbn, String author, String title, int copies, BookStatus bookStatus) {
        this.id = id;
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.copies = copies;
        this.bookStatus = bookStatus;
    }

    public Book(String isbn, String author, int copies) {
        this.isbn = isbn;
        this.author = author;
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }


    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    /*public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }*/

    public void addBoodCopy(BookCopy bookCopy) {
        this.bookCopies.add(bookCopy);
    }


}
