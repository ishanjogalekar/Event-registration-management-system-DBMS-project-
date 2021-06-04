import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class CreateVenue extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("RoomId");
        String a2=request.getParameter("Building");
        String a3=request.getParameter("Room No");
        
        
       
        
        
       
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Eventweb";
                 String pass = "e1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into venue values('"+a1+"','"+a2+"','"+a3+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("CreateV.html");
                 rd.include(request, response);
                 
                 out.println("<br><center><h3> Venue Added</h3></center>");
                 con.close();
            }catch(Exception exe){System.out.println("Exception caught");}
             
           
    }
      
}




