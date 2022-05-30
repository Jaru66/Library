import java.util.ArrayList;

public class Customer {
    String name,surname;
    int id;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Customer()
    {
        this.name="default name";
        this.surname="default surname";

    }
}
