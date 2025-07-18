# PdfCreator_Task2
#  PDF Generator for Employee Reports

##  Objective
This Java application generates styled PDF reports from employee data stored in a CSV file (or optionally from a database using JDBC). It uses Apache PDFBox to format and export the reports with headers, tables, and timestamps.

---

## Technologies Used

- Java 8+
- Maven
- Apache PDFBox
- Eclipse IDE
- CSV file (or JDBC for DB option)
- PDF formatting with fonts and colors

---

##  Project Structure

pdf-generator/
├── pom.xml
├── reports/ # Output folder for generated PDFs
├── src/
│ └── main/
│ ├── java/
│ │ └── pdfReport/
│ │ ├── App.java
│ │ ├── Employee.java
│ │ ├── DatabaseUtil.java
│ │ └── PDFReportGenerator.java
│ └── resources/
│ └── employees.csv # Sample employee data


---

##  Dependencies

Add the following to your `pom.xml`:

```xml
<dependencies>
  <dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>2.0.29</version>
  </dependency>
  <!-- Optional: JDBC (MySQL) -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
  </dependency>
</dependencies>
id,name,department,salary
1,John Doe,HR,55000
2,Jane Smith,IT,60000


 How to Run
Import the project into Eclipse as a Maven project.

Make sure employees.csv is in src/main/resources.

Run App.java as a Java Application.

Output PDF will be saved in the /reports folder with a timestamp.

## Features
Reads employee data from CSV file

Converts data into styled PDF report

Uses Apache PDFBox for PDF formatting

Generates PDFs with timestamped filenames

Batch-ready structure
