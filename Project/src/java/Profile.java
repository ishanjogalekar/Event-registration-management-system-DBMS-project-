import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;
public class Profile extends HttpServlet{
    DBConnection dbConnection = new DBConnection();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("Reg");
        String a2=request.getParameter("Name");
        String a3=request.getParameter("ContactNo");

             try{
                 Connection con = dbConnection.GetDatabaseConnection();
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into Student values('"+a1+"','"+a2+"','"+a3+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Profile.html");
                 rd.include(request, response);
                 
                 out.println("<br><center><h3> Profile Added</h3></center>");
            }catch(Exception exe){exe.printStackTrace();}
         
         
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
    