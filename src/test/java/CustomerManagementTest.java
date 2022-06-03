import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagementTest {

    @BeforeEach
    void start() throws Exception {
        CustomerManagement.clearCustomerList();
        CustomerManagement.addNew("name", "surname", 0);
    }


    @Test
    void addNewCustomerToArrayList() {

        assertEquals(1,CustomerManagement.getCustomersSize());
    }

    @Test
    void getCustomerName() {

        assertEquals("name",CustomerManagement.getCustomerName(0));
    }
}