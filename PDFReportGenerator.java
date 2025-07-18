package pdfReport;


	import org.apache.pdfbox.pdmodel.*;
	import org.apache.pdfbox.pdmodel.common.PDRectangle;
	import org.apache.pdfbox.pdmodel.font.*;
	import org.apache.pdfbox.pdmodel.PDPageContentStream;

	import java.io.File;
	import java.io.IOException;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.List;

	public class PDFReportGenerator {

	    public static void generateReport(List<Employee> employees, String outputPath) throws IOException {
	        PDDocument document = new PDDocument();
	        PDPage page = new PDPage(PDRectangle.A4);
	        document.addPage(page);

	        PDPageContentStream content = new PDPageContentStream(document, page);

	        PDFont font = PDType1Font.HELVETICA_BOLD;
	        PDFont fontNormal = PDType1Font.HELVETICA;

	        content.beginText();
	        content.setFont(font, 18);
	        content.setLeading(20f);
	        content.newLineAtOffset(50, 750);
	        content.showText("Employee Report has been successfully generated");
	        content.newLine();
	        content.newLine();

	        content.setFont(fontNormal, 12);
	        for (Employee emp : employees) {
	            content.showText("ID: " + emp.getId() + ", Name: " + emp.getName() +
	                    ", Dept: " + emp.getDepartment() + ", Salary: ₹" + emp.getSalary());
	            content.newLine();
	        }

	        content.endText();
	        content.close();

	        // Save with timestamp
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	        document.save(outputPath + "/employee_report_" + timestamp + ".pdf");
	        document.close();
	    }
	}



