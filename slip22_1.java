import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            
            while (true) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee Salary");
                System.out.println("3. Display Employees");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateSalary(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(conn);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String ename = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        
        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eno);
            pstmt.setString(2, ename);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee inserted successfully!");
        }
    }
    
    private static void updateSalary(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number to update salary: ");
        int eno = scanner.nextInt();
        System.out.print("Enter new Salary: ");
        double salary = scanner.nextDouble();
        
        String sql = "UPDATE Employee SET Salary = ? WHERE ENo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, salary);
            pstmt.setInt(2, eno);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Salary updated successfully!");
            } else {
                System.out.println("Employee not found.");
            }
        }
    }
    
    private static void displayEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Employee";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\nEmployee Details:");
            while (rs.next()) {
                System.out.println("ENo: " + rs.getInt("ENo") + ", Name: " + rs.getString("EName") + ", Salary: " + rs.getDouble("Salary"));
            }
        }
    }
}
