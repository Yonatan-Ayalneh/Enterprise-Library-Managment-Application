import bank.dao.CustomerLRepository;
import bank.domain.CustomerL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private CustomerLRepository customerLRepository;

        @Test
        public void whenFindByCutomerName_thenReturnCustomer() {
            // given
            CustomerL customerL = new CustomerL(1,"name one","email one");
            entityManager.persist(customerL);
            entityManager.flush();

            // when
            CustomerL found = customerLRepository.findByName("name one");

            // then
            assertThat(customerL.getName())
                    .isEqualTo(found.getName());
            // and
            assertThat(customerL.getEmail())
                    .isEqualTo(found.getEmail());
            // and
            assertThat(customerL.getCustomerNumber())
                    .isEqualTo(found.getCustomerNumber());
        }


}
