import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddEvent extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("EventNo");
        String a2=request.getParameter("EventName");
        String a3=request.getParameter("ClubName");
        String a4=request.getParameter("coordinatorName");
        String a5=request.getParameter("CoordinatorNo");
        String a6=request.getParameter("RoomNo");
        
       
        
        
       
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Eventweb";
                 String pass = "e1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into Event values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("CreateE.html");
                 rd.include(request, response);
                 
                 out.println("<br><center><h3> Event Added</h3></center>");
                 con.close();
            }catch(Exception exe){System.out.println("Exception caught"+exe);}
             
           
           
            
            
            
    }
      
}



