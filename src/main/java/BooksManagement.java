import java.util.Scanner;

public class BooksManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static void addNew(){
        Book[] books = new Book[1];

        System.out.println("Podaj tytuł książki:");
        String bookTitle = scanner.nextLine();
        System.out.println("Podaj Autora");
        String bookAuthor = scanner.nextLine();
        books[books.length+1] = new Book(bookTitle,bookAuthor, books.length+1);

    }

}
