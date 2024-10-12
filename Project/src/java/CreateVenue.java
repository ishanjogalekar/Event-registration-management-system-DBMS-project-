
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class CreateVenue extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String a1 = request.getParameter("RoomId");
        String a2 = request.getParameter("Building");
        String a3 = request.getParameter("Room No");

        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            String Qs = "insert into venue values('" + a1 + "','" + a2 + "','" + a3 + "') ";
            ResultSet rs = stmt.executeQuery(Qs);

            RequestDispatcher rd = request.getRequestDispatcher("CreateV.html");
            rd.include(request, response);

            out.println("<br><center><h3> Venue Added</h3></center>");
            con.close();
        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }

}
