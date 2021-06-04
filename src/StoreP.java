import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class StoreP extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String up=request.getParameter("Pusername");
        String pp=request.getParameter("Ppassword");
        String cp=request.getParameter("Cpassword");
        
        String a1=up;
        String a2=pp;
        String a3=cp;
        
        
        if(a2.equals(a3)){
             try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "plogin";
                 String pass = "p1234";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into plogindeatils values('"+a1+"','"+a2+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");
                 rd.forward(request, response);
            }catch(Exception exe){System.out.println("Exception caught");}
             
        }
        else
        {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }
            
        
    }

}