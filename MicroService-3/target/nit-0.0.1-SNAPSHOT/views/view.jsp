<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>Interest on salary</h1>
 <form:form action="/getData"  method="post" modelAttribute="bean">
	<table>
		<tr>
			<th>EmpName</th>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<th>Percent</th>
			<td><form:input path="percent" /></td>
		</tr>
		<tr>
		 <td><input type="submit" value="submit"/></td>
		 </tr>
	</table>
</form:form>

<h2>Name:${increment.ename}</h2>
<h2>Salary:${increment.salary}</h2>
<h2>interest:${increment.interest}</h2>
<h2>TotalAmnt:${increment.totAmt}</h2>

</body>
</html>