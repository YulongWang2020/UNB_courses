import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class StudentTranscript {

    public static void main(String args[]) {
        if(args.length < 1){
            System.err.println("Usage: StudentTranscript <studentId>");
        }
        String studentId = args[0];

        StudentTranscript student = new StudentTranscript();
        Connection conn = student.openConnection();
        try{
            String query = "{CALL studentTranscript(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1,studentId);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ) {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t");
            }
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
