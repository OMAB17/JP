<%@page language"="java""import="java.sql.*""%>
<html><body>
<%
class.forName("org.postgresql.Driver");
Connection c1=DriverManager.getConnection("jdbc:postgresql://localhost:8080/mydb","postgres","123");
Statement s=c1.createStatement();
Resultset rs=s.executeQuery("select * from patient");
%>
<table"border="2">
<tr><th>Patient"NO</th><th>Name</th><th>address</th><th>age</th><th>disease</th></tr>
<% while(rs.next())
{%>
<td><%out.println(rs.getInt(1));%></td>
<td><%out.println(rs.getString(2));%></td>
<td><%out.println(rs.getString(3));%></td>
<td><%out.println(rs.getInt(4));%></td>
<td><%out.println(rs.getString(5));%></td>
<%
}
%>
</body>
</html>
