import java.util.ArrayList;

public class Customer {
    String name,surname;
    int id;
    ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Customer(String name, String surname)
    {
        this.name=name;
        this.surname=surname;
        this.id=CustomerManagement.getCustomersSize()+1;
    }
    public Customer()
    {
        this.name="default name";
        this.surname="default surname";
        this.id=CustomerManagement.getCustomersSize()+1;
    }
}
