import java.util.*;

public class BooksManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Book> library1 = new ArrayList<>();
    public static void addNew(){
        library1.add(new Book(askForTitle(),askForAuthor(), library1.size()+1)
        );

    }
    private static String askForTitle(){
        System.out.println("Podaj tytuł książki:");
        return scanner.nextLine();
    }
    private static String askForAuthor(){
        System.out.println("Podaj Autora");
        return scanner.nextLine();
    }
    public static String getBookName(int bookId){
        String name;
        name=(library1.get(bookId).title);
        return name;
    }
    public static int getLibrarySize(){
        return library1.size();
    }
}
