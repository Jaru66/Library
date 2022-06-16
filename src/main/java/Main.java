import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        /*BooksManagement.addNew("Bogaty ojciec biedny ojciec","kiyosaki");
        BooksManagement.addNew("hary potter","rowloing");
        BooksManagement.addNew("nekromanta","ksiadz");
        BooksManagement.addNew("lokomotywa","tuwim");
        BooksManagement.addNew("matko bosko","Bog");
        */
        Database.downloadBookList();
        CustomerManagement.addNew("Broken or lost ","books",0);
        CustomerManagement.addNew("Jarek","Olszak");
        Database.bookExists(1);
        Database.bookExists(5);
        Menu.selectMenu();
        System.out.println(Database.getBookAvailability(6));
        //Database.downloadBookList();
    }
}
