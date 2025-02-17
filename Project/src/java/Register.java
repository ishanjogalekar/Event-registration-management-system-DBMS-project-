
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class Register extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String a1 = request.getParameter("cardno");

        String a2 = request.getParameter("edate");

        String a3 = request.getParameter("cvv");
        String a4 = request.getParameter("cname");
        String a5 = request.getParameter("reg");

        String a6 = request.getParameter("enum");
        String a7 = request.getParameter("ename");
        String a8 = request.getParameter("date");

        try {
            Connection con = dbConnection.GetDatabaseConnection();
            Statement stmt = con.createStatement();

            String Qs = "insert into card values('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "') ";
            ResultSet rs = stmt.executeQuery(Qs);

            String Qt = "insert into transaction_history values('" + a6 + "','" + a5 + "','" + a8 + "') ";
            ResultSet rp = stmt.executeQuery(Qt);

            con.commit();
            con.close();

            RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
            rd.include(request, response);

            out.println("<center><h2>Registered For Event: " + a7);
            out.println("<br>");
            out.println("<center><h2>Paid succefully </h2></center>");
            out.println("<br><center><a href=\"ParticipantEvent.html\">Go back</a></center>");

        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }
}
