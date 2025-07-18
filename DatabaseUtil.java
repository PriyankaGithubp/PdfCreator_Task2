package pdfReport;
import java.sql.*;
import java.util.*;

	public class DatabaseUtil {
	    public static List<Employee> fetchEmployees() {
	        List<Employee> employees = new ArrayList<>();
	        try (Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/your_db", "username", "password");
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setId(rs.getInt("id"));
	                emp.setName(rs.getString("name"));
	                emp.setDepartment(rs.getString("department"));
	                emp.setSalary(rs.getDouble("salary"));
	                employees.add(emp);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }
	}



