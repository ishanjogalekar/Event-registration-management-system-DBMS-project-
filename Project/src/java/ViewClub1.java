
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class ViewClub1 extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Club Details Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");

        try {
            Connection con = dbConnection.GetDatabaseConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Club");

            out.println("<center><h1> Club Details </h1> </center> ");
            out.println("<br><br>");
            out.println("<div>");
            out.println("<center>");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>ClubName</th><th>Faculty</th><th>Description</th><th>ContactPerson</th><th>ContactNumber</th>");
            while (rs.next()) {

                String cn = rs.getString("cname");
                String fc = rs.getString("fc");
                String desc = rs.getString("bdesc");
                String conta = rs.getString("contper");
                String conn = rs.getString("connum");
                out.println("<tr><td>" + cn + "</td><td>" + fc + "</td><td>" + desc + "</td><td>" + conta + "</td><td>" + conn + "</td></tr>");
            }

            con.commit();
            con.close();
            out.println("</table>");
            out.println("</center>");
            out.println("</div>");
            out.print("</body>");
            out.print("</html>");

        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }
}
