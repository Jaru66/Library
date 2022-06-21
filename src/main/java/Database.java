import java.io.IOException;
import java.sql.*;

public class Database {
    public static Connection connection;
    public static Statement statement;

    public static Connection connect() throws IOException, SQLException {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/booklist";
            String username = "user";
            String password = "password";
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url, username, password);
                statement = connection.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //at program launch
    public static void downloadBookListFromDatabase()throws IOException, SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT * FROM books ;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                BooksManagement.addNew(rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getBoolean("isAvaliable"));
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Boolean isAvaliable = rs.getBoolean("isAvaliable");

                System.out.println(id + " " + title+ "       ["+ author+"]"+isAvaliable);
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }
    }

    //at program close
    public static void uploadBookListToDatabase()throws IOException, SQLException{
        try {
            connect();
            statement = connection.createStatement();
            String sql = null;
            for(int i=0;i<BooksManagement.getLibrarySize();i++) {
                sql = "INSERT INTO `books` (`id`,`title`,`author`,`isAvaliable`) VALUES ('"+BooksManagement.getBook(i).id+ "','"+BooksManagement.getBook(i).title+"','"+BooksManagement.getBook(i).author+"','"+return1WhileTrue(BooksManagement.getBook(i).isAvaliable)+"');";
                if(bookExistsInDatabase(i)){
                    if(BooksManagement.getBook(i).isAvaliable!=getBookAvailability(i)){
                        System.out.println("jest niedostepna");sql = "UPDATE books SET isAvaliable = '"+return1WhileTrue(BooksManagement.getBook(i).isAvaliable)+"' WHERE id = '"+i+"';";connect(); statement = connection.createStatement();statement.executeUpdate(sql);}
                }else {connect(); statement = connection.createStatement();  statement.executeUpdate(sql);}
            }
        } catch (Exception e){e.printStackTrace();}finally {
            connection.close();
        }
    }

    public static void downloadCustomerList() throws SQLException {  try {
        connect();
        statement = connection.createStatement();
        String sql = "SELECT * FROM customers ;";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            CustomerManagement.addNew(rs.getString("name"),rs.getString("surname"),rs.getInt("id"));
        }
    }catch (Exception e) {e.printStackTrace();}finally {
        connection.close();
    }  }

    public static void uploadCustomerList() throws SQLException {  try {
        connect();
        statement = connection.createStatement();
        String sql = null;
        for(int i=0;i<CustomerManagement.getCustomersSize();i++) {
            System.out.println("stalo sie");
            sql = "INSERT INTO `customers` (`id`,`name`,`surname`,`borrowedBooksID`) VALUES ('"+CustomerManagement.getCustomer(i).id+ "','"+CustomerManagement.getCustomer(i).name+"','"+CustomerManagement.getCustomer(i).surname+"','"+CustomerManagement.getCustomer(i).getBorrowedBooksToString()+"');";
            if(customerExistsInDatabase(i)){
                if(CustomerManagement.getCustomer(i).getBorrowedBooksToString().equals(getUserBooksListFromDatabase(i))){
                    System.out.println("lista sie zgadza");
            }else {uploadCustomerBookList(i);}
              }else { connect(); statement = connection.createStatement(); statement.executeUpdate(sql);}
        }
    } catch (Exception e){e.printStackTrace();}finally {
        connection.close();
    }  }

    public static void downloadCustomerBookList(Customer customer){    }
    public static void uploadCustomerBookList(int customerId) throws SQLException { try {
        connect();
        statement = connection.createStatement();
        String sql = "UPDATE customers SET borrowedBooksID = '"+CustomerManagement.getCustomer(customerId).getBorrowedBooksToString()+"' WHERE id = '"+customerId+"';";statement.executeUpdate(sql);}
    catch (Exception e) {        e.printStackTrace();    }     finally {        connection.close();        }
    }

    public static int return1WhileTrue(boolean bool){        if (bool) {return 1;}        else return 0;    }
    public static boolean bookExistsInDatabase(int id) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT id FROM books where id= "+id+";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {return true;
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }
        return false;
    }
    public static boolean customerExistsInDatabase(int CustomerId) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT id FROM customers where id= "+CustomerId+";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {return true;
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }
        return false;
    }
    public static boolean getBookAvailability(int    BookId) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT isAvaliable FROM books where id= "+BookId+";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                return rs.getBoolean("isAvaliable");
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }
        return false;
    }
    public static String getUserBooksListFromDatabase(int UserId) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT borrowedBooksID FROM customers where id= "+UserId+";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("borrowedBooksID");
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }return "";
    }
}