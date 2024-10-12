
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ValidateAd extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String un = request.getParameter("Ausername");
        String pw = request.getParameter("Apassword");
        response.setContentType("text/html");

        String u1 = "admin";
        String p1 = "1234";

        if (pw.equals(p1) && (un.equals(u1))) {
            RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        } else {
            out.println("<center><h1>!! Please Enter Valid Username & Password !!</h1><center>");
            RequestDispatcher rd = request.getRequestDispatcher("Alogin.html");
            rd.include(request, response);
        }

    }
}
