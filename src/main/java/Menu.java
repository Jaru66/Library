import java.util.Scanner;
public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    private static int selectedOption;

    private static void printMenu(){
        System.out.println("1. Dodaj książkę do księgozbioru");
        System.out.println("2. Wyszukaj frazę");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
    }
    public static void selectMenu(){
        printMenu();
        selectedOption = scanner.nextInt();
        while(true){
            switch (selectedOption){
                    case 1:BooksManagement.addNew();
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    case 5:
                    break;
            }
        }
    }

}
