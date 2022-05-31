import java.util.*;

public class BooksManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Book> library = new ArrayList<>();
    public static void addNew(){
        library.add(new Book(askForTitle(),askForAuthor(), library.size())
        );

    }
    public static void addNew(String bookTitle, String bookAuthor){
        library.add(new Book(bookTitle,bookAuthor, library.size())
        );

    }
    public static String askForTitle(){
        System.out.println("Podaj tytuł książki:");
        return scanner.nextLine();
    }
    public static String askForAuthor(){
        System.out.println("Podaj Autora");
        return scanner.nextLine();
    }
    public static String getBookName(int bookId){
        String name;
        name=(library.get(bookId).title);
        return name;
    }
    public static int getLibrarySize(){
        return library.size();
    }

    public static Book getBook(int bookId){
        return library.get(bookId);
    }

}
