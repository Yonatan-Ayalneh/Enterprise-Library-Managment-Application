package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;


@SpringBootApplication
public class Application implements CommandLineRunner {



	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8090/";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// add books
		restTemplate.postForLocation("http://localhost:8090/createBook", new Book(65,"125", "Author one", "title one", 4,BookStatus.AVAILABLE));
		restTemplate.postForLocation("http://localhost:8090/createBook", new Book(66,"135", "Author two", "title two", 5,BookStatus.AVAILABLE));
		Book book = restTemplate.getForObject(serverUrl+"62", Book.class);
		System.out.println(book.getAuthor());
		

	}
}
