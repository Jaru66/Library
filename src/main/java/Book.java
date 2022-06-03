import java.util.Scanner;
public class Book {
    String title;
    String author;
    int id;
    boolean isAvaliable = true;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.id = BooksManagement.getLibrarySize()+1;
    }
    public Book() {
        this.title = "title";
        this.author = "author";
        this.id = BooksManagement.getLibrarySize()+1;
    }
    public void setUnavaliable(){this.isAvaliable=false;}
    public void setAvaliable(){this.isAvaliable=true;}


}
