import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class InsertData
*/
@WebServlet("/insertContact")
public class InsertContactData extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
try {
Connection con = DBConnect.connect();
PreparedStatement st = con.prepareStatement("insert into contactdata values(?,?,?)");
st.setString(1, request.getParameter("name"));
st.setString(2, request.getParameter("email"));
st.setString(3, request.getParameter("message"));
st.executeUpdate();
PrintWriter out = response.getWriter();
out.println("<html><style>body{font-family: Arial, sans-serif;\r\n"
		+ "    background-color: white;\r\n"
		+ "    font-color: white;\r\n"
		+ "    height: auto;\r\n"
		+ "    font-size:50px;\r\n"
		
		+ "    background-size: cover;\r\n"
		+ "    background-repeat: no-repeat;\r\n"
		+ "    background-attachment: fixed;}</style><body><b>Message Sent Succesfully!Admin will contact you for further process."
+ "</b></body></html>");
st.close();
con.close();

}catch(Exception e) {
}
}
}


