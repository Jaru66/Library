
public class Main {
    public static void main(String[] args){
        BooksManagement.addNew("Bogaty ojciec biedny ojciec","kiyosaki");
        BooksManagement.addNew("hary potter","rowloing");
        BooksManagement.addNew("nekromanta","ksiadz");
        BooksManagement.addNew("lokomotywa","tuwim");
        BooksManagement.addNew("matko bosko","Bog");
        CustomerManagement.addNew("Jarek","Olszak");
        Menu.selectMenu();
        //Customer customer1 = new Customer();

       //customer1.borrowedBooks.add(new Book("tyt","aut"));
    }
}
