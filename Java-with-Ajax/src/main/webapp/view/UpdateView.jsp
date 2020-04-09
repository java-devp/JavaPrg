<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style= color:green>${success}</h1>
 <form:form action="updaterecord?id=${fetch.empid}" modelAttribute="fetch">
   <table>
    <tr>
      <th>Empname</th>
      <td><form:input path="ename"/></td>
      </tr>
      <tr>
      <th>addrs</th>
      <td><form:input path="addrs"/></td>
      </tr>
      <tr>
      <th>salary</th>
      <td><form:input path="salary"/></td>
      </tr>
      <tr>
      <td><input type="submit" value="submit"/></td>
      </tr>
   </table>
 
 </form:form>
  <a href="viewRecord">view</a>

</body>
</html>