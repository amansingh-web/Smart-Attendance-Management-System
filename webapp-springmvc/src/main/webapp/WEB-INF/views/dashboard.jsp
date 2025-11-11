<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html><head><title>Dashboard</title></head>
<body>
  <h2>Dashboard</h2>
  <h3>Add Student</h3>
  <form method="post" action="students">
    <input name="name" placeholder="Name" required/>
    <input name="roll" placeholder="Roll No" required/>
    <input name="course" placeholder="Course" required/>
    <input name="semester" placeholder="Semester" required/>
    <button type="submit">Add</button>
  </form>

  <h3>All Students</h3>
  <table border="1">
    <tr><th>Name</th><th>Roll</th><th>Course</th><th>Semester</th></tr>
    <%
      List students = (List)request.getAttribute("students");
      if (students != null) {
        for (Object o : students) {
          com.smartattendance.model.Student s = (com.smartattendance.model.Student)o;
    %>
      <tr><td><%=s.getName()%></td><td><%=s.getRoll_no()%></td><td><%=s.getCourse()%></td><td><%=s.getSemester()%></td></tr>
    <%
        }
      }
    %>
  </table>

  <h3>Attendance Summary (via JDBC)</h3>
  <table border="1">
    <tr><th>Name</th><th>Roll</th><th>Total</th><th>Presents</th></tr>
    <%
      List<Map<String,Object>> summary = (List<Map<String,Object>>)request.getAttribute("summary");
      if (summary != null) {
        for (Map<String,Object> row : summary) {
    %>
      <tr><td><%=row.get("name")%></td><td><%=row.get("roll_no")%></td><td><%=row.get("total")%></td><td><%=row.get("presents")%></td></tr>
    <%
        }
      }
    %>
  </table>
</body></html>
