import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewVenue1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Venue Page</title>");
    out.println("<link rel=\"stylesheet\" href=\"total.css\">");
    out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");
     try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Eventweb";
                 String pass = "e1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 response.setContentType("text/html");
                 
                 
                 ResultSet rp = stmt.executeQuery("select * from Venue"); 
                 
                 
                 
                 out.println("<center><h1>Venue Details</h1></center>");
                 
                 out.println("<br><br>");
                 out.println("<div>");
                 out.println("<center>");
              
                 
                 out.println("<table border=1 width=50% height=50%>");  
                 out.println("<tr><th>RoomId</th><th>Building</th><th>RoomNo</th>");  
                 while (rp.next()) 
                   {  
                     String roomid=rp.getString("roomid");
                     String bd = rp.getString("building");
                     String roomno= rp.getString("roomno");  
                     out.println("<tr><td>" + roomid + "</td><td>" + bd+"</td> <td>"+roomno+"</td></tr>" );   
                   }  
                 out.println("</table>"); 
                
                 out.println("</body>");
                 out.println("</html>");
               
                 con.close(); 
                 
             
             
            }    
        catch(Exception exe){System.out.println("Exception caught");}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}