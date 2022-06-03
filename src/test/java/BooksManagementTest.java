import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksManagementTest {

    @BeforeEach
    void before()
    {
        BooksManagement.clearLibrary();
    }
    @Test
    void addNewBookToLibraryArrayList() {
         BooksManagement.addNew("default title", "default author");
        assertEquals(1,BooksManagement.getLibrarySize());
    }
}