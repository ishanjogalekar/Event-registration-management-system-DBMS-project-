import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Profile extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("Reg");
        String a2=request.getParameter("Name");
        String a3=request.getParameter("ContactNo");
   
        
       
        
        
       
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Transweb";
                 String pass = "t1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into Student values('"+a1+"','"+a2+"','"+a3+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Profile.html");
                 rd.include(request, response);
                 
                 out.println("<br><center><h3> Profile Added</h3></center>");
            }catch(Exception exe){System.out.println("Exception caught");}
         
         
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
    