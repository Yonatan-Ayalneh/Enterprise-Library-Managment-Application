package bank;

import bank.dao.ReturnRecordRepository;
import bank.service.LateCustomerPrinter;
import bank.service.ReturnRecordService;
import org.apache.activemq.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableKafka
@EnableJms
@EnableScheduling
public class Application implements CommandLineRunner{


	@Autowired
	LateCustomerPrinter lateCustomerPrinter;

	@Autowired
	ReturnRecordRepository returnRecordRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

		//lateCustomerPrinter.print(returnRecordRepository.findAll());
	}
}
