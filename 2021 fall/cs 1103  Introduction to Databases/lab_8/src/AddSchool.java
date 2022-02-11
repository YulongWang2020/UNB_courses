import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class AddSchool {

    public static void main(String args[]) {


        if(args.length < 4){
            System.err.println("Usage: AddSchool <name> <province> <language> <level>");
        }
        String schoolName = args[0];
        String schoolProvince = args[1];
        String schoolLanguage = args[2];
        String schoolLevel = args[3];
        
        AddSchool school = new AddSchool();
        Connection conn = school.openConnection();
        try{
            String query = "{CALL addSchool(?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1,schoolName);
            stmt.setString(2,schoolProvince);
            stmt.setString(3,schoolLanguage);
            stmt.setString(4,schoolLevel);
            stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        school.closeConnection(conn);
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
