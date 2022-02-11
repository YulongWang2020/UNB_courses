import java.sql.Connection;
import java.sql.DriverManager;

class JDBCTest {

    static final String url = "jdbc:mysql://cs1103.cs.unb.ca:3306/ywang92";
    static final String user = "ywang92";
    static final String password = "JGN1fP9V";

    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
