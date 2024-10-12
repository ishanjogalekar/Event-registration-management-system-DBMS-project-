
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class TraH extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Transactions Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");

        try {
            Connection con = dbConnection.GetDatabaseConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from transaction_history");

            out.println("<center><h1> Transaction  Details </h1> </center> ");

            out.println("<div>");

            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Event No </th><th> Registration No</th><th>Payment Date</th>");

            while (rs.next()) {

                String en = rs.getString("enum");
                String re = rs.getString("regno");
                String pd = rs.getString("hdate");

                out.println("<tr><td>" + en + "</td><td>" + re + "</td><td>" + pd + "</td></tr>");
            }

            con.commit();
            con.close();
            out.println("</table>");
            out.println("</h3></center>");
            out.println("</div>");
            out.print("</body>");
            out.print("</html>");

        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }
}
