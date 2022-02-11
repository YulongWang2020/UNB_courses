import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class AddStudent {

    public static void main(String args[]) {


        if(args.length < 3){
            System.err.println("Usage: AddStudent <name> <email> <hsaverage>");
        }
        String studname = args[0];
        String studemail = args[1];
        String hsaverage = args[2];
        
        AddStudent student = new AddStudent();
        Connection conn = student.openConnection();
        try{
            String query = "{CALL acceptStudent(?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1,studname);
            stmt.setString(2,studemail);
            stmt.setString(3,hsaverage);
            stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        student.closeConnection(conn);
    }
    private Connection openConnection()
    {
        final String url = "jdbc:mysql://cs1103.cs.unb.ca:3306/ywang92";
        final String user = "ywang92";
        final String password = "JGN1fP9V";
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
