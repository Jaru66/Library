import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void addNew(){
        customers.add(new Customer(askForName(),askForSurname()));
    }
    public static void addNew(String name, String surname){
        customers.add(new Customer(name,surname));
    }
    public static void addNew(String name, String surname,int iD){
        customers.add(new Customer(name,surname,iD));
    }
    public static String askForName(){

        System.out.println("Podaj imię nowego użytkownika");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("To pole nie może być puste.");
            return askForName();
        }else
        return name;

    }
    public static String askForSurname(){
        System.out.println("Podaj nazwisko nowego użytkownika");
        String surname = scanner.nextLine();

        if (surname.isEmpty()) {
            System.out.println("To pole nie może być puste.");
            return askForSurname();
        }
        return surname;
    }
    public static int getCustomersSize(){return customers.size();}

    public static void addBookToCustomerArrayList(Customer customer,int bookID){
        customer.addBook(BooksManagement.getBook(bookID));
        BooksManagement.getBook(bookID).setUnavaliable();
    }
    public static void deleteBookFromCustomerArrayList(Customer customer,int bookID)
    {
        BooksManagement.getBook(customer.getlibraryBookId(bookID)).setAvaliable();
        customer.deleteBook(customer.borrowedBooks.get(bookID));
     }
    public static Customer getCustomer (int id){
        return customers.get(id);
    }
    public static String getCustomerName(int id){
        return customers.get(id).name;
    }
    public static void clearCustomerList()
    {customers.clear();}
}
