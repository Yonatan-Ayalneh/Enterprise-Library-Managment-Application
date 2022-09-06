package client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LibraryGateway {

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8888/reservations/";

    public void createReservation(ReservationRequest reservationRequest) {

        restTemplate.postForLocation(serverUrl+"89", reservationRequest);

    }
}
