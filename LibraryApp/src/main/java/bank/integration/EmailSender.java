package bank.integration;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    public void sendEmail(String message) {
        System.out.println(message);
    }
}



