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
        String bookTitle = scanner.nextLine();
        return bookTitle;
    }
    private static String askForAuthor(){
        System.out.println("Podaj Autora");
        String bookAuthor = scanner.nextLine();
        return bookAuthor;
    }
    public static String getBookName(int bookId){
        String name;
        name=(library1.get(bookId).title);
        return name;
    }
}
