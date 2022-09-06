package bank.service;

import bank.domain.BookReturnEvent;
import bank.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventEmailer {
    @Autowired
    EmailSender emailSender;

    @EventListener
    public void onEvent(BookReturnEvent event) {
        emailSender.sendEmail("******** email Book return event :" + event.toString());
    }

}

