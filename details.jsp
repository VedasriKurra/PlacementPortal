<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String batch = request.getParameter("batch");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "mysql";
String userid = "root";
String password = "";
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batch Details</title>
    <style>
        body {
            background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #00FFFF;
            color: black;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        h1 {
            background-color: #00FFFF;
            color: black;
            padding: 20px;
            text-align: center;
            margin: 0; /* Remove default margin */
        }
        .pdf-link {
            display: inline-block;
            padding: 10px 15px;
            margin: 5px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>BATCH DETAILS</h1>

<%
try {
    Class.forName(driver);
    connection = DriverManager.getConnection(connectionUrl + database, userid, password);

    // Use a PreparedStatement to prevent SQL injection
    String sql = "SELECT * FROM 16HE WHERE SNo = ?";
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, batch);
    resultSet = preparedStatement.executeQuery();

    // Display the data in a table
    if (resultSet.next()) {
%>
<table>
    <thead>
        <tr>
            <th>BATCH</th>
            <th>ROLL NUMBER</th>
            <th>NAME</th>
            <th>UNIVERSITY</th>
            <th>COURSE</th>
            <th>ACTION</th>
        </tr>
    </thead>
    <tbody>
<%
        // Move cursor back to the first record
        resultSet.beforeFirst();
        while (resultSet.next()) {
            String studentId = resultSet.getString("SNo"); // Assuming SNo as the identifier
            String pdfUrl = "generatePdf.jsp?batch=" + studentId; // URL to generate PDF
%>
        <tr>
            <td><%= resultSet.getString("SNo") %></td>
            <td><%= resultSet.getString("Roll") %></td>
            <td><%= resultSet.getString("Name") %></td>
            <td><%= resultSet.getString("University") %></td>
            <td><%= resultSet.getString("Course") %></td>
            <td><a href="pdff.html" target="_blank">View PDF</a></td>
        </tr>
<%
        }
%>
    </tbody>
</table>
<%
    } else {
%>
    <p>No data found for batch <%= batch %>.</p>
<%
    }
    connection.close();
} catch (Exception e) {
    e.printStackTrace();
}
%>

</body>
</html>
