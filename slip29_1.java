import java.sql.*;

public class DonarTableMetadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DONAR LIMIT 1")) {
            
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            System.out.println("Column Information of DONAR Table:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + metaData.getColumnName(i));
                System.out.println("  Type: " + metaData.getColumnTypeName(i));
                System.out.println("  Size: " + metaData.getColumnDisplaySize(i));
                System.out.println("  Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}