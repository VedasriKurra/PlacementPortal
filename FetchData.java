import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import DBConnect;

/**
* Servlet implementation class FetchData
*/
@WebServlet("/fetch")
public class FetchData extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
Connection con = DBConnect.connect();
PreparedStatement st = con
.prepareStatement("select * from contactdata;");
st.setString(1, request.getParameter("pname"));
ResultSet rs=st.executeQuery();
PrintWriter out = response.getWriter();
while(rs.next())
{
out.println("<tr>\r\n"
		+ "\r\n"
		+ "<td><%=resultSet.getString(\"namr\") %></td>\r\n"
		+ "<td><%=resultSet.getString(\"email\") %></td>\r\n"
		+ "<td><%=resultSet.getString(\"message\") %></td>\r\n"
		+ "</tr>");
}
st.close();
con.close();
}catch(Exception e) {
e.printStackTrace();
}
}
}