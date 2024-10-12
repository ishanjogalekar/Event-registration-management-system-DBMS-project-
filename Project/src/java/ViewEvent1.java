
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import utils.DBConnection;

public class ViewEvent1 extends HttpServlet {

    DBConnection dbConnection = new DBConnection();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event  Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        try {
            Connection con = dbConnection.GetDatabaseConnection();

            response.setContentType("text/html");

            Statement stmt1 = con.createStatement();
            ResultSet rp = stmt1.executeQuery("select * from Event");

            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");

            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EventNumber</th><th>EVentName</th><th>ClubName</th><th>Co-ordinator</th><th>Co-ordinatorContact</th><th>RoomId</th>");
            while (rp.next()) {
                String n = rp.getString("enum");
                String nm = rp.getString("ename");
                String cn = rp.getString("cname");
                String co = rp.getString("coord");
                String cono = rp.getString("coordnum");
                String roomid = rp.getString("roomid");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + cn + "</td><td>" + co + "</td><td>" + cono + "</td><td>" + roomid + "</td></tr>");
            }
            con.commit();
            con.close();
            out.println("</table>");
            out.println("</center>");
            out.print("</body>");
            out.print("</html>");

        } catch (Exception exe) {
            exe.printStackTrace();
        }

    }
}
