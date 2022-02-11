import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class AddStudent {

    public static void main(String args[]) {


        if(args.length < 4){
            System.err.println("Usage: AddStudent <name> <province> <language> <level>");
        }
        String studentName = args[0];
        String studentProvince = args[1];
        String studentLanguage = args[2];
        String studentLevel = args[3];
        
        Addstudent student = new Addstudent();
        Connection conn = student.openConnection();
        try{
            String query = "{CALL addstudent(?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1,studentName);
            stmt.setString(2,studentProvince);
            stmt.setString(3,studentLanguage);
            stmt.setString(4,studentLevel);
            stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        student.closeConnection(conn);
    }
    private Connection openConnection()
    {
        final String url = "jdbc:mysql://info1103.cs.unb.ca:3306/wightman";
        final String user = "wightman";
        final String password = "z2Dfix%T4";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.printf("Couldn't open a connection: (%s)", e.getMessage());
        }
        return conn;
    }
    private void closeConnection(Connection conn)
    {
        try {
            conn.close();
        } catch (Exception e) {
            System.err.printf("Couldn't close connection: (%s)", e.getMessage());
        }
    }
}
