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
    public void deleteBook(Book book){
        this.borrowedBooks.remove(book);
    }
    public void printBorrowedBooks()
    {
        if(this.borrowedBooks.size()==0){
            System.out.println(this.name+" nie ma żadnej książki.");
        }else
        for(int i=0;i<this.borrowedBooks.size();) {

            System.out.println(this.borrowedBooks.indexOf(this.borrowedBooks.get(i))+this.borrowedBooks.get(i).title);i++;
        }
    }
    public int getlibraryBookId(int borrowedBookId){
        int libraryBookId = this.borrowedBooks.get(borrowedBookId).id;
        return libraryBookId;
    }
}
