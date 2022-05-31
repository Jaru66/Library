import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void addBookToCustomerBorrowedBookList() {
        Customer customer = new Customer();
        Book book = new Book();

        customer.addBook(book);
        Assertions.assertEquals(1,customer.borrowedBooks.size());
    }
}