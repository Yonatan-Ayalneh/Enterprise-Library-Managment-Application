package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {

    List<Book> getByAuthor(
            String brand
    );

    List<Book> getByTitle(
            String model
    );

    List<Book> getByBookStatus();

    List<Book> findByIsbn(String isbn);
}
