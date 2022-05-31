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
    private static String askForName(){
        System.out.println("Podaj imię nowego użytkownika");return scanner.nextLine();
    }
    private static String askForSurname(){
        System.out.println("Podaj nazwisko nowego użytkownika");return scanner.nextLine();
    }
    public static int getCustomersSize(){return customers.size();}

    public static void addBookToCustomerArrayList(Customer customer,int bookID){
        customer.addBook(BooksManagement.getBook(bookID));
    }
    public static Customer getCustomer (int id){
        return customers.get(id);
    }
    public static String getCustomerName(int id){
        return customers.get(id).name;
    }
}
