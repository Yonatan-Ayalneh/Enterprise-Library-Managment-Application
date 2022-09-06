package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.util.List;


@SpringBootApplication
@EnableJms
public class Application {

	/*@Autowired
	private CustomerRepository customerRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}
