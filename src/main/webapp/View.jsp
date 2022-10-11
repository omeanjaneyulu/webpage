<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.webcreation.bean.Encapsulation" %> 
<%@page import="java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FetchData</title>
</head>
<body>
<h2 align ="center">Employee data</h2>
<table align="center">
<%
Object sessionObj = session.getAttribute("Object");
if (sessionObj == null){
out.print("No Data Found");
} else {
List<Encapsulation> elist = (ArrayList<Encapsulation>)sessionObj;
%>

<tr>
<th>EmplooyeeId</th>
<th>EmployeeName</th>
<th>fatherName</th>
<th>MobileNumber</th>
<th>emailId</th>
<th>address</th>
<th>dob</th>
<th></th>
</tr>
<%
for(Encapsulation e : elist){
%>
<tr>
<td><%=e.getEmployeeId()%></td>
      <td><%=e.getEmployeeName() %></td>
      <td><%= e.getFatherName()%></td>
      <td><%= e.getMobileNumber()%></td>
      <td><%= e.getEmailId()%></td>
      <td><%= e.getAddress()%></td>
      <td><%= e.getDob()%></td>
      
      
     </tr>
<%
}
}
%>
<tr>
<td><button>
<a href="Index.html">Index</a></button></td>
</tr>
</table>


</body>
</html>

</body>
</html>