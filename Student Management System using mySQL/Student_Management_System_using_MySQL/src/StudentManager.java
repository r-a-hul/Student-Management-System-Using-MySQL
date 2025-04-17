import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    private final String url = "jdbc:mysql://localhost:3306/studentdb";
    private final String user = "root";     
    private final String password = "Rahul@rs1";     
    private Connection conn;
    private Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public void addStudent() {
        try {
            System.out.print("Enter Roll No: ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            String sql = "INSERT INTO students (roll_no, name, course, age) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roll);
            stmt.setString(2, name);
            stmt.setString(3, course);
            stmt.setInt(4, age);
            stmt.executeUpdate();

            System.out.println(" Student added successfully!");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no") +
                        ", Name: " + rs.getString("name") +
                        ", Course: " + rs.getString("course") +
                        ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void updateStudent() {
        try {
            System.out.print("Enter Roll No to update: ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter New Age: ");
            int age = scanner.nextInt();

            String sql = "UPDATE students SET name=?, course=?, age=? WHERE roll_no=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, course);
            stmt.setInt(3, age);
            stmt.setInt(4, roll);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println(" Student updated.");
            }
            else{
                System.out.println(" Student not found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            System.out.print("Enter Roll No to delete: ");
            int roll = scanner.nextInt();

            String sql = "DELETE FROM students WHERE roll_no=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roll);
            int rows = stmt.executeUpdate();

            if (rows > 0){
                System.out.println(" Student deleted.");
            }
            else{
                System.out.println(" Student not found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void searchStudent() {
        try {
            System.out.print("Enter Roll No to search: ");
            int roll = scanner.nextInt();

            String sql = "SELECT * FROM students WHERE roll_no=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roll);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no") +
                        ", Name: " + rs.getString("name") +
                        ", Course: " + rs.getString("course") +
                        ", Age: " + rs.getInt("age"));
            } else {
                System.out.println(" Student not found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
