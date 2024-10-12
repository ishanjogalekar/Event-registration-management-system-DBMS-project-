
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class StoreP extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");

        String a1 = up;
        String a2 = pp;
        String a3 = cp;

        if (a2.equals(a3)) {
            try {
                Connection con = dbConnection.GetDatabaseConnection();
                Statement stmt = con.createStatement();

                String Qs = "insert into plogindeatils values('" + a1 + "','" + a2 + "') ";
                ResultSet rs = stmt.executeQuery(Qs);

                RequestDispatcher rd = request.getRequestDispatcher("Plogin.html");
                rd.forward(request, response);
            } catch (Exception exe) {
                exe.printStackTrace();
            }

        } else {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd = request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }

    }

}
