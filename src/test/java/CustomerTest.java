import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {


    @BeforeEach
    public  void start()throws Exception{
        CustomerManagement.addNew("customer","custsurname");
        BooksManagement.addNew("title","author");

    }
    @AfterEach
    public  void after()
    {
        CustomerManagement.getCustomer(0).borrowedBooks.clear();
    }
    @Test
    void addBookToCustomerBorrowedBookList() {


        CustomerManagement.getCustomer(0).addBook(BooksManagement.getBook(0));
        Assertions.assertEquals(1,CustomerManagement.getCustomer(0).borrowedBooks.size());
    }

    @Test
    void deleteBook() {

        BooksManagement.addNew("d","d");
        CustomerManagement.getCustomer(0).addBook(BooksManagement.getBook(0));
        CustomerManagement.getCustomer(0).deleteBook(BooksManagement.getBook(0));
        Assertions.assertEquals(0,CustomerManagement.getCustomer(0).borrowedBooks.size());
    }

    @Test
    void addBook() {

        CustomerManagement.getCustomer(0).addBook(BooksManagement.getBook(0));
        Assertions.assertEquals(0,CustomerManagement.getCustomer(0).getlibraryBookId(0));
    }

    @Test
    void testDeleteBook() {
        BooksManagement.addNew("d","d");
        CustomerManagement.addBookToCustomerArrayList(CustomerManagement.getCustomer(0),0);
        CustomerManagement.getCustomer(0).deleteBook(CustomerManagement.getCustomer(0).borrowedBooks.get(0));
        Assertions.assertEquals(0,CustomerManagement.getCustomer(0).borrowedBooks.size());
    }

    @Test
    void getlibraryBookId() {
        BooksManagement.addNew("title","author");
        BooksManagement.addNew("title","author");
        CustomerManagement.addBookToCustomerArrayList(CustomerManagement.getCustomer(0),1);
        Assertions.assertEquals(1,CustomerManagement.getCustomer(0).getlibraryBookId(0));
    }
}