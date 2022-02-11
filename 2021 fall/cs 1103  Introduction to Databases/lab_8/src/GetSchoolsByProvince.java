import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
class GetSchoolsByProvince {

    public static void main(String args[]) {
        if(args.length < 1){
            System.err.println("Usage: GetSchoolsByProvince <province>");
        }
        String schoolProvince = args[0];

        GetSchoolsByProvince school = new GetSchoolsByProvince();
        Connection conn = school.openConnection();
        try{
            String query = "{CALL getSchoolsByProvince(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1,schoolProvince);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() ) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        school.closeConnection(conn);
    }
    private Connection openConnection()
    {
        final String url = "jdbc:mysql://cs1103.cs.unb.ca:3306/YoUr dAtAbAsE hErE";
        final String user = "YoUr uSeRnAmE hErE";
        final String password = "YoUr pAsSwOrD hErE";
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
