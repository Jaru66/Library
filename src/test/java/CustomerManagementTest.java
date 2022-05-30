import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagementTest {

    @Test
    void addNewCustomerToArrayList() {
        CustomerManagement.addNew("name","surname");
        assertEquals(1,CustomerManagement.getCustomersSize());


    }
}