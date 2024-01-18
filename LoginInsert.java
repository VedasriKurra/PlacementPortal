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
@WebServlet("/logininsert")
public class LoginInsert extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
try {
Connection con = DBConnect.connect();
PreparedStatement st = con.prepareStatement("insert into login values(?,?);");
st.setString(1, request.getParameter("username"));
st.setString(2, request.getParameter("password"));
st.executeUpdate();
st.close();
con.close();
PrintWriter out = response.getWriter();

}catch(Exception e) {
}
}
}


