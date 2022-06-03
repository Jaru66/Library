import java.util.Scanner;
public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    private static int selectedOption;

    private static void printMenu(){
        System.out.println("1. Dodaj książkę do księgozbioru");
        System.out.println("2. Dodaj użytkownika");
        System.out.println("3. Dodaj ksiazke do usera tymczasowo");
        System.out.println("4. Wyswietl liste ksiazek");
        System.out.println("5. Wyswietl liste userow");
        System.out.println("6. Wyswietl ksiazki usera");
        System.out.println("7. Usun ksiazke usera");
    }
    public static void selectMenu(){
        printMenu();
        selectedOption = scanner.nextInt();
        while(true){
            switch (selectedOption){
                    case 1:BooksManagement.addNew(BooksManagement.askForTitle(),BooksManagement.askForAuthor());
                    break;
                    case 2:CustomerManagement.addNew(CustomerManagement.askForName(),CustomerManagement.askForSurname());
                    break;
                    case 3:
                        System.out.println("Customer,bookID");CustomerManagement.addBookToCustomerArrayList(CustomerManagement.getCustomer(scanner.nextInt()),scanner.nextInt());
                    break;
                    case 4:
                        for(int i=0;i<BooksManagement.getLibrarySize();) {
                            if(!BooksManagement.getBook(i).isAvaliable){
                                System.out.println("book not avaliable");
                                i++;
                            }else{
                                System.out.println(BooksManagement.getBook(i).id+" "+BooksManagement.getBookName(i));
                                i++;
                            }

                        }
                    break;
                    case 5:
                        for (int o=0;o<CustomerManagement.getCustomersSize();o++){
                            System.out.println(CustomerManagement.getCustomer(o).id+" "+CustomerManagement.getCustomerName(o));
                        }
                    break;
                    case 6:
                        System.out.println("Wpisz ID usera ktorego ksiazki chcesz wyswietlic");
                         CustomerManagement.getCustomer(scanner.nextInt()).printBorrowedBooks();
                    break;
                case 7:
                    System.out.println("Wpisz Id usera ktorego ksiazke chcesz usunac:");
                    //wyswietl userow
                    for (int o=0;o<CustomerManagement.getCustomersSize();o++){
                        System.out.println(CustomerManagement.getCustomer(o).id+" "+CustomerManagement.getCustomerName(o));
                    }
                    //wyswietl ksiazki tego usera
                    int customerID= scanner.nextInt();
                    CustomerManagement.getCustomer(customerID).printBorrowedBooks();
                    CustomerManagement.deleteBookFromCustomerArrayList(CustomerManagement.getCustomer(customerID),scanner.nextInt());
                    break;
            }
            Menu.selectMenu();
        }
    }

}
