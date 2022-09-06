package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootApplication
public class Application implements CommandLineRunner {
	


	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8888/reservations/";


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerL customerL = new CustomerL(66, "nameone","emailone");
		ReservationRequest reservationRequest = new ReservationRequest(customerL);

		restTemplate.postForLocation(serverUrl+"/{id}", reservationRequest,100);


	}
}
