import bank.domain.BorrowRecord;
import bank.domain.CustomerL;
import bank.domain.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BorrowRecordTest {

    private BorrowRecord borrowRecord1, borrowRecord2;
    private Duration duration;


    @BeforeEach
    public void setup(){
        borrowRecord1 = new BorrowRecord(23);
        CustomerL customerL = new CustomerL(1, "nameone","emailone");
       duration = new Duration(LocalDate.now(),LocalDate.of(2022,06,13));
        borrowRecord1.setDuration(duration);
        borrowRecord1.setCustomerL(customerL);

    }

    @Test
    public void testCreateDuration(){
        assertThat(duration.getReturnDate(), equalTo (LocalDate.of(2022,06,13)));
    }


    @Test
    public void testCreateBorrowRecord(){
        assertThat(borrowRecord1.getCustomerL().getCustomerNumber(), equalTo (1));
    }

    @Test
    public void testCreateBorrowRecordDuration(){
        assertThat(borrowRecord1.getDuration().getRentalDate(), equalTo (LocalDate.now()));
    }

        /*@Test
        public void testDepositZero(){
            toAccount.deposit(0.0);
            assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
        }

        @Test
        public void testDeposit(){
            toAccount.deposit(100.0);
            assertThat( toAccount.getBalance(), closeTo (100.0, 0.01));
        }

        @Test
        public void testWithdrawZero(){
            toAccount.withdraw(0.0);
            assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
        }

        @Test
        public void testWithdraw(){
            toAccount.withdraw(100.0);
            assertThat( toAccount.getBalance(), closeTo (-100.0, 0.01));
        }

        @Test
        public void testTransferFundsZero(){
            fromAccount.transferFunds(toAccount, 0, "for groceries");
            assertThat( fromAccount.getBalance(), closeTo (0.0, 0.01));
            assertThat( toAccount.getBalance(), closeTo (0.0, 0.01));
        }

        @Test
        public void testTransferFunds(){
            fromAccount.transferFunds(toAccount, 100, "for groceries");
            assertThat( fromAccount.getBalance(), closeTo (-100.0, 0.01));
            assertThat( toAccount.getBalance(), closeTo (100.0, 0.01));
        }*/


}
