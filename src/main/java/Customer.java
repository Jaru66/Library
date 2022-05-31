import java.util.ArrayList;

public class Customer {
    String name,surname;
    int id;
    ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Customer(String name, String surname, int id)
    {
        this.name=name;
        this.surname=surname;
        this.id=id;
    }
    public Customer(String name, String surname)
    {
        this.name=name;
        this.surname=surname;
        this.id=CustomerManagement.getCustomersSize();
    }
    public Customer()
    {
        this.name="default name";
        this.surname="default surname";
        this.id=CustomerManagement.getCustomersSize();
    }
    public void addBook(Book book){
        this.borrowedBooks.add(book);
    }
}
