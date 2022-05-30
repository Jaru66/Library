import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void addNew(){
        customers.add(new Customer(askForName(),askForSurname()));
    }
    private static String askForName(){
        System.out.println("Podaj imię nowego użytkownika");return scanner.nextLine();
    }
    private static String askForSurname(){
        System.out.println("Podaj nazwisko nowego użytkownika");return scanner.nextLine();
    }
    public static int getCustomersSize(){return customers.size();}
}
