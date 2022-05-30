import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> collection;

    public Library(){
        List<Book> collection = new ArrayList<Book>();
    }
    public void addBook(Book book){
        collection.add(book);
    }

}
