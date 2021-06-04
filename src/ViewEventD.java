import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewEventD extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Event Details Page</title>");
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
                
                 
                 response.setContentType("text/html");
                 
                 Statement stmt = con.createStatement();  
                 ResultSet rs = stmt.executeQuery("select * from event_details"); 
                 
              
                 
                 
                 out.println("<center><h1> Event Details </h1> </center> ");
                 out.println("<br><br>");
                 out.println("<div>");
                 
                
                 out.println("<center>");
                 out.println("<table border=1 width=50% height=50%>");  
                 out.println("<tr><th>EventNumber</th><th>EventDate</th><th>EventTime</th><th>Fees</th><th>Duration</th><th>Description</th><th>SpeakerName</th><th>SpeakarNo</th><th>Seats</th>");  
                 while (rs.next()) 
                   {  
                    String n = rs.getString("enum");  
                    String da = rs.getString("edate");  
                    String ti = rs.getString("time");
                    String fe = rs.getString("fees");
                    String dur=rs.getString("dur");
                    String des=rs.getString("descr");
                    String sn=rs.getString("sname");
                    String snu = rs.getString("snum");
                    String sea=rs.getString("seats");
                    out.println("<tr><td>" + n + "</td><td>" + da + "</td><td>" + ti + "</td><td>"+fe+"</td><td>"+dur+"</td><td>"+des+"</td><td>"+sn+"</td><td>"+snu+"</td><td>"+sea+"</td></tr>");   
                   }  
                 con.commit();
                 con.close(); 
                 out.println("</table>"); 
                 out.println("</center>");
                 out.print("</body>");
                 out.print("</html>"); 
                 
             
             
            }    
        catch(Exception exe){System.out.println("Exception caught");} 
    
    
    
    
    }
}
