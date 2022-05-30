import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksManagementTest {

    @Test
    void addNewBookToLibraryArrayList() {
         BooksManagement.addNew("default title", "default author");
        assertEquals(1,BooksManagement.getLibrarySize());
    }
}