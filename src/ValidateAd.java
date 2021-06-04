import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ValidateAd extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out=response.getWriter();
        String un=request.getParameter("Ausername");
        String pw=request.getParameter("Apassword");
        response.setContentType("text/html");
        
        String u1="19BCE2250";
        String p1="1234";
        
        String u2="19BCE2249";
        String p2="5678";
        
        String u3="19BCE0439";
        String p3="ABCD";
        
        String u4="19BCE0167";
        String p4="abcd";
        
        
        if(pw.equals(p1)&&(un.equals(u1))){
        RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
        rd.forward(request, response);
        }
        else if(pw.equals(p2)&&un.equals(u2)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p3)&&un.equals(u3)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEve1t.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p4)&&un.equals(u4)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        
        
    
        else
        {
            out.println("<center><h1>!! Please Enter Valid Username & Password !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Alogin.html");
            rd.include(request, response);
        }
        
    }
}
