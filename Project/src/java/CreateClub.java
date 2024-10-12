
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class CreateClub extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String a1 = request.getParameter("ClubName");
        String a2 = request.getParameter("Faculty");
        String a3 = request.getParameter("CDescription");
        String a4 = request.getParameter("Ccontactp");
        String a5 = request.getParameter("ContactNo");

        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            String Qs = "insert into Club values('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "') ";
            System.out.println(Qs);
            ResultSet rs = stmt.executeQuery(Qs);
            RequestDispatcher rd = request.getRequestDispatcher("CreateC.html");
            rd.include(request, response);

            out.println("<br><center><h3> Club Added</h3></center>");
        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }
}
