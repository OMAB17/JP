import java.sql.*;  
import java.io.*;  
class slip26_1
{  
public static void main(String args[])throws Exception
{  
Class.forName("org.postgresql.Driver");
System.out.println("driver loded");
Connection c1= DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp","postgres","123456");
   System.out.println("connection established");
c1.setAutoCommit (false);
PreparedStatement ps=c1.prepareStatement("delete from employee where eid=?");  
   eid=Integer.parseInt(args[0]);  
 ps.setInt(1,eid);  
ps.executeUpdate();    
System.out.println("record deleted")
  c1.setAutoCommit(true);  
}  
  
c1.close();  
}}  
