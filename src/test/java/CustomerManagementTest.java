import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagementTest {

    @BeforeAll
    public static void start() throws Exception {
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