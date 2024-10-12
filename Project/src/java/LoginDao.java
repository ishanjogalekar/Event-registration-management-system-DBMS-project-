
import java.sql.*;
import utils.DBConnection;

public class LoginDao {

    static DBConnection dbConnection = new DBConnection();

    public static boolean validate(String User_name, String Pass_word) {
        boolean status = false;
        Connection con;
        try {
            con = dbConnection.GetDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from plogindeatils where User_name=? and Pass_word=?");
            ps.setString(1, User_name);
            ps.setString(2, Pass_word);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
