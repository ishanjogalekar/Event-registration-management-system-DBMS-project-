
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class ViewVenue1 extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Venue Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            response.setContentType("text/html");

            ResultSet rp = stmt.executeQuery("select * from Venue");

            out.println("<center><h1>Venue Details</h1></center>");

            out.println("<br><br>");
            out.println("<div>");
            out.println("<center>");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>RoomId</th><th>Building</th><th>RoomNo</th>");
            while (rp.next()) {
                String roomid = rp.getString("roomid");
                String bd = rp.getString("building");
                String roomno = rp.getString("roomno");
                out.println("<tr><td>" + roomid + "</td><td>" + bd + "</td> <td>" + roomno + "</td></tr>");
            }
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            con.close();

        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }
}
