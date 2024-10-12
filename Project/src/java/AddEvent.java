
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class AddEvent extends HttpServlet {
     DBConnection dbConnection = new DBConnection();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String a1 = request.getParameter("EventNo");
        String a2 = request.getParameter("EventName");
        String a3 = request.getParameter("ClubName");
        String a4 = request.getParameter("coordinatorName");
        String a5 = request.getParameter("CoordinatorNo");
        String a6 = request.getParameter("RoomNo");

        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            String Qs = "insert into Event values('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "') ";
            System.out.println(Qs);
            ResultSet rs = stmt.executeQuery(Qs);

            RequestDispatcher rd = request.getRequestDispatcher("CreateE.html");
            rd.include(request, response);

            out.println("<br><center><h3> Event Added</h3></center>");
            con.close();
        } catch (Exception exe) {
            System.out.println("Exception caught" + exe);
        }

    }

}
