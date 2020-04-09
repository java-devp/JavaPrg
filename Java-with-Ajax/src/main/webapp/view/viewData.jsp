<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border=1>
   <thead>
     <tr>
     <th>empid</th>
     <th>ename</th>
     <th>addrs</th>
     <th>salary</th>
     <th>edit</th>
     <th>delete</th>
     </tr>
    </thead>
     <tbody>
        <form:forEach items="${viewData}"  var="emp" >
        <tr>
         <td>${emp.empid}</td>
         <td>${emp.ename}</td>
         <td>${emp.salary}</td>
         <td>${emp.addrs}</td>
         <td><a href="updatedata?id=${emp.empid}">edit</a></td>
         <td><a href="">delete</a></td>
         </tr>
        </form:forEach>
       
     </tbody>
 </table>

</body>
</html>