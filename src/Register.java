import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        String a1=request.getParameter("cardno");
        
        String a2=request.getParameter("edate");
        
        String a3=request.getParameter("cvv");
        String a4=request.getParameter("cname");
        String a5=request.getParameter("reg");
        
        String a6=request.getParameter("enum");
        String a7=request.getParameter("ename");
        String a8=request.getParameter("date");
        
        
          try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "Transweb";
                 String pass = "t1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into card values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 
                 
                 String Qt="insert into transaction_history values('"+a6+"','"+a5+"','"+a8+"') ";
                 ResultSet rp=stmt.executeQuery(Qt);
                 
                 con.commit();
                 con.close();
                 
                 
                 
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Registration.html");
                 rd.include(request, response);
                 
                 out.println("<center><h2>Registered For Event: "+a7);
                 out.println("<br>");
                 out.println("<center><h2>Paid succefully </h2></center>");
                 out.println("<br><center><a href=\"ParticipantEvent.html\">Go back</a></center>");
                 
                 
            }catch(Exception exe){System.out.println("Exception caught");}
         
     
         
 
   
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
    