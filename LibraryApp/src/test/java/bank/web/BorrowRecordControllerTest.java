package bank.web;

import bank.dao.BorrowRecordRepository;
import bank.domain.BorrowRecord;
import bank.domain.CustomerL;
import bank.domain.Duration;
import bank.service.BorrowRecordService;
import bank.service.ReservationService;
import bank.service.ReturnRecordService;
import bank.web.ReservationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class BorrowRecordControllerTest {

        @Autowired
        MockMvc mock;

        @MockBean
        BorrowRecordService borrowRecordService;

        @MockBean
        ReservationService reservationService;

        @MockBean
        BorrowRecordRepository repository;

        @MockBean
        ReturnRecordService returnRecordService;

        @Test
        public void testGetAccount() throws Exception {
            Mockito.when(borrowRecordService.getBorrowRecord(1)).thenReturn(new BorrowRecord(new Duration(LocalDate.now(),LocalDate.now()),1,new CustomerL()));
            mock.perform(MockMvcRequestBuilders.get("/reservations/123"))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("123"));

        }
}
