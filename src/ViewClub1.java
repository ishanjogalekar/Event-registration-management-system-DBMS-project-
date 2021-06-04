import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewClub1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Club Details Page</title>");
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
               
                 
                 Statement stmt = con.createStatement();  
                 ResultSet rs = stmt.executeQuery("select * from Club"); 
                 
                 out.println("<center><h1> Club Details </h1> </center> ");
                 out.println("<br><br>");
                 out.println("<div>");
                 out.println("<center>");
                 
                 out.println("<table border=1 width=50% height=50%>");  
                 out.println("<tr><th>ClubName</th><th>Faculty</th><th>Description</th><th>ContactPerson</th><th>ContactNumber</th>");  
                 while (rs.next()) 
                   {  
                      
                    String cn = rs.getString("cname");
                    String fc = rs.getString("fc");
                    String desc  = rs.getString("bdesc");
                    String conta=rs.getString("contper");
                    String conn=rs.getString("connum");
                    out.println("<tr><td>" + cn + "</td><td>" + fc + "</td><td>" + desc + "</td><td>"+conta+"</td><td>"+conn+"</td></tr>");   
                   }
                
                 con.commit();
                 con.close(); 
                 out.println("</table>"); 
                 out.println("</center>");
                 out.println("</div>");
                 out.print("</body>");
                 out.print("</html>");
                 
                 
                 
            }    
        catch(Exception exe){System.out.println("Exception caught");}
    }
}
