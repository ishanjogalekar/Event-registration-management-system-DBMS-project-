
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class AddEventDetails extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String a1 = request.getParameter("EventNo");
        String a2 = request.getParameter("EDate");
        String a3 = request.getParameter("ETime");
        String a4 = request.getParameter("EFees");
        String a5 = request.getParameter("EDuration");
        String a6 = request.getParameter("EDescription");

        String a7 = request.getParameter("SpeakerName");
        String a8 = request.getParameter("SpeakerNo");
        String a9 = request.getParameter("Seats");

        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            String Qs = "insert into event_details values('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "','" + a7 + "','" + a8 + "','" + a9 + "') ";
            ResultSet rs = stmt.executeQuery(Qs);

            RequestDispatcher rd = request.getRequestDispatcher("AddEventDetails.html");
            rd.include(request, response);

            out.println("<br><center><h3> Event Details Added</h3></center>");
        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }

}
