package customers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   /* @Autowired
    private BookRepository bookDAO;


    public Book createBook(String isbn, String author, int copies) {
        Book book = new Book(isbn,author,copies);
        bookDAO.save(book);
        return book;
    }

    public Book updateBook(String isbn, String author, int copies) {
        Book book = new Book(isbn,author,copies);
        bookDAO.save(book);
        return book;
    }*/



    @Autowired
    private BookRepository bookRepository;



    @JmsListener(destination = "testQueue")
    public synchronized void updateBookCopies(String instructionAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(instructionAsString, Book.class);
            List<Book> books = getBookBYIsbn(book.getIsbn());
            for(Book b : books){
                b.setCopies(book.getCopies());
                bookRepository.save(b);
            }

            //updateBookCopies(book.getId(),book.getCopies(),book);
            System.out.println("JMS receiver received message:" + instructionAsString);

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + instructionAsString+" to a CalcInstruction object");
        }
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public List<Book> getBookBYIsbn(String isbn){return bookRepository.findByIsbn(isbn);}

    public List<Book> getBookByAuthor(String author) {
        return bookRepository.getByAuthor(author);
    }


    public List<Book> getBookByTitle(String title) {
        return bookRepository.getByTitle(title);
    }


    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookCopies(int id  , int copies, Book book) {
        if(bookRepository.findById(id).isPresent()){

            book.setCopies(copies);
            return bookRepository.save(book);
        }
        return bookRepository.save(book);
    }

    public Book updateBook(int id  , Book book) {
        if(bookRepository.findById(id).isPresent()){
            book.setId(id);

            return bookRepository.save(book);
        }
        return bookRepository.save(book);
    }



    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBookStatus(Integer id, BookStatus bookStatus) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            bookOptional.get().setBookStatus(bookStatus);
            bookRepository.save(bookOptional.get());
        }
    }





}
