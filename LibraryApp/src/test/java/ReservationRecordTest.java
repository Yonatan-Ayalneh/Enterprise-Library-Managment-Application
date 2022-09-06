import bank.domain.CustomerL;
import bank.domain.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReservationRecordTest {

    private Reservation reservationRecord1, reservationRecord2;
    private CustomerL customerL;


    @BeforeEach
    public void setup(){
        reservationRecord2 = new Reservation(null,null);
        reservationRecord1 = new Reservation(1,LocalDate.now());
        customerL = new CustomerL(1, "nameone","emailone");
        reservationRecord1.setCustomer(customerL);


    }

    @Test
    public void testCreateCustomer(){
        assertThat(customerL.getCustomerNumber(), equalTo (1));
    }


    @Test
    public void testCreateReservationRecord(){
        assertThat(reservationRecord1.getReservationDate(), equalTo (LocalDate.now()));
    }

    @Test
    public void testCreateReservationRecordWithNull(){
        assertThat(reservationRecord2.getCustomer(), equalTo (null));
    }

}
