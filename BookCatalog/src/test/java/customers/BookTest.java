package customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

public class BookTest {

        private Book book1, book2;


        @BeforeEach
        public void setup(){
            book1 = new Book(1,4);

            book1.setBookStatus(BookStatus.AVAILABLE);
           /* Customer customer = new Customer("Frank Brown");
            toAccount = new Account();
            toAccount.setCustomer(customer);

            Customer customer2 = new Customer("John Doe");
            fromAccount = new Account();
            fromAccount.setCustomer(customer2);*/
        }

        @Test
        public void testCreateBook(){
            assertThat( book1.getCopies(), equalTo (4));
        }

        @Test
        public void testBookAvailability(){
            assertThat( book1.getBookStatus(), equalTo (BookStatus.AVAILABLE));
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
