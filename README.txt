SmartAttendance_Ultra — Advanced Multi-Tech Stack (Topper Edition)
=================================================================
Modules:
1) webapp-springmvc — Spring MVC + Hibernate + JDBC (JdbcTemplate) + JSP + Spring Security (WAR for Tomcat)
2) swing-tool — Swing desktop bulk import utility (CSV -> MySQL) using JDBC
3) legacy-servlets — Plain Servlets with JDBC ping (for requirement/demo)

Build:
- Install Maven & JDK8+
- From root: mvn clean package
  - webapp-springmvc/target/webapp-springmvc.war -> deploy to Tomcat
  - legacy-servlets/target/legacy-servlets.war -> deploy to Tomcat
  - swing-tool: run BulkImportTool (java -cp target/... main class)

Database:
- Run database.sql in MySQL. Update DB credentials in AppConfig.java and JDBC URLs.
