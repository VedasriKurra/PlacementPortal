import java.sql.*;
public class DBConnect {
public static Connection connect() throws Exception{
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "mysql";
	String userid = "root";
	String password = "";
	Class.forName(driver);
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
    con = DriverManager.getConnection(connectionUrl+database, userid, password);
	statement=con.createStatement();
	return con;
	
	} 
}

