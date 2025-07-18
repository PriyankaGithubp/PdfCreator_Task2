package pdfReport;



	import java.io.IOException;
	import java.util.List;

	public class App {
	    public static void main(String[] args) {
	        try {
	            List<Employee> employees = DatabaseUtil.fetchEmployees();
	            PDFReportGenerator.generateReport(employees, "reports");
	            System.out.println("PDF report generated successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



