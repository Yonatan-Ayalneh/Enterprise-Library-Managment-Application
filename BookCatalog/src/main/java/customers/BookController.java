package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /*@PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestParam(value= "isbn") String isbn,
                                           @RequestParam(value= "author") String author,
                                        @RequestParam(value= "copies") int copies) {
        Book book = bookService.creat(isbn, author,copies);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
*/



    //Get all the vehicles
    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.ok(books);
//        return ResponseEntity.ok("Hello");
    }

    //Get the vehicles by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        return book;

    }


    @GetMapping("getBookbyAuthor/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        List<Book> book = bookService.getBookByAuthor(author);
        return book;

    }

    @GetMapping("getbookbytitle/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBookByTitle(title);
        return books;

    }

    @GetMapping("getbookbyisbn/{isbn}")
    public List<Book> getBookByIsbn(@PathVariable String isbn) {
        List<Book> books = bookService.getBookBYIsbn(isbn);
        return books;

    }

    @PostMapping("/createBook")
    public ResponseEntity<?> addBook( @RequestBody Book book){
        Book newBook = bookService.addBook(book);
        if (newBook == null)
            return new ResponseEntity<>("Already Exists", HttpStatus.OK);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?>updateBook(@PathVariable Integer id , @RequestBody Book bookBody){
        return ResponseEntity.ok(bookService.updateBook(id ,bookBody));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?>deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Successful");

    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateBookStatus(@PathVariable Integer id, @RequestBody BookStatus bookStatus){
        bookService.updateBookStatus(id, bookStatus);
        return ResponseEntity.noContent().build();
    }


}
