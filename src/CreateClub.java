import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class CreateClub extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("ClubName");
        String a2=request.getParameter("Faculty");
        String a3=request.getParameter("CDescription");
        String a4=request.getParameter("Ccontactp");
        String a5=request.getParameter("ContactNo");
        
       
        
        
       
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Eventweb";
                 String pass = "e1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into Club values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("CreateC.html");
                 rd.include(request, response);
                 
                 out.println("<br><center><h3> Club Added</h3></center>");
            }catch(Exception exe){System.out.println("Exception caught");}
         
         
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
    