
public class Main {
    public static void main(String[] args){
        BooksManagement.addNew("Bogaty ojciec biedny ojciec","kiyosaki");
        BooksManagement.addNew("hary potter","rowloing");
        BooksManagement.addNew("nekromanta","ksiadz");
        BooksManagement.addNew("lokomotywa","tuwim");
        BooksManagement.addNew("matko bosko","Bog");
        CustomerManagement.addNew("Broken or lost ","books",0);
        CustomerManagement.addNew("Jarek","Olszak");
        Menu.selectMenu();
    }
}
