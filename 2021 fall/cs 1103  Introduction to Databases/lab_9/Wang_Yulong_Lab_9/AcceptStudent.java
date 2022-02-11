import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class AcceptStudent {

    public void execute(String args[]) throws SQLException {

        if(args.length < 3){
            throw new SQLException("Usage: AddStudent <name> <email> <hsaverage>");
        }
        String studname = args[0];
        String studemail = args[1];
        String hsaverage = args[2];
        if(studname.length() == 0 || studemail.length() == 0 || hsaverage.length() == 0){
            throw new SQLException("Missing Input");
        }
        AcceptStudent student = new AcceptStudent();
        Connection conn = student.openConnection();
        String query = "{CALL acceptStudent(?,?,?)}";
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setString(1,studname);
        stmt.setString(2,studemail);
        stmt.setString(3,hsaverage);
        stmt.executeQuery();

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
