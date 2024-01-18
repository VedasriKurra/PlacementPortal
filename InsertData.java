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
@WebServlet("/insert")
public class InsertData extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
try {
Connection con = DBConnect.connect();
PreparedStatement st = con.prepareStatement("insert into repository values(?,?,?,?)");
st.setString(1, request.getParameter("pname"));
st.setString(2, request.getParameter("ppwd"));
st.setString(3, request.getParameter("peid"));
st.setString(4, request.getParameter("pphone"));
st.executeUpdate();
st.close();
con.close();
PrintWriter out = response.getWriter();
out.println("<html><body><b>Successfully Inserted"
+ "</b></body></html>");
}catch(Exception e) {
}
}
}


