import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void setUnavaliable() {
        BooksManagement.addNew("title","author");
        BooksManagement.getBook(0).setUnavaliable();
        assertFalse(BooksManagement.getBook(0).isAvaliable);
    }

    @Test
    void setAvaliable() {
        BooksManagement.addNew("title","author");
        BooksManagement.getBook(0).setUnavaliable();
        BooksManagement.getBook(0).setAvaliable();
        assertTrue(BooksManagement.getBook(0).isAvaliable);
    }
}