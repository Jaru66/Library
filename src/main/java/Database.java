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
    public static void downloadBookList()throws IOException, SQLException {
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
    public static void uploadBookList()throws IOException, SQLException{
        try {
            connect();
            statement = connection.createStatement();
            String sql = null;
            for(int i=0;i<BooksManagement.getLibrarySize();i++) {
                sql = "INSERT INTO `books` (`id`,`title`,`author`,`isAvaliable`) VALUES ('"+BooksManagement.getBook(i).id+ "','"+BooksManagement.getBook(i).title+"','"+BooksManagement.getBook(i).author+"','"+return1WhileTrue(BooksManagement.getBook(i).isAvaliable)+"');";
                if(bookExists(i)){
                    if(BooksManagement.getBook(i).isAvaliable!=getBookAvailability(i)){
                        System.out.println("jest niedostepna");sql = "UPDATE books SET isAvaliable = '"+return1WhileTrue(BooksManagement.getBook(i).isAvaliable)+"' WHERE id = '"+i+"';";statement.executeUpdate(sql);}
                }else statement.executeUpdate(sql);
            }
        } catch (Exception e){e.printStackTrace();}finally {
            connection.close();
        }
    }

    public static void downloadCustomerList(){    }
    public static void uploadCustomerList(){    }

    public static void downloadCustomerBookList(Customer customer){    }
    public static void uploadCustomerBookList(Customer customer){    }

    public static int return1WhileTrue(boolean bool){        if (bool) {return 1;}        else return 0;    }
    public static boolean bookExists(int id) throws SQLException {
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
    public static boolean getBookAvailability(int    id) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            String sql = "SELECT isAvaliable FROM books where id= "+id+";";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                return rs.getBoolean("isAvaliable");
            }
        }catch (Exception e) {e.printStackTrace();}finally {
            connection.close();
        }
        return false;
    }
}