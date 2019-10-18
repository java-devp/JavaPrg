<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"></script>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

  <script type="text/javascript">
   function confirmDelete(){
   return confirm("are you want to delete");
   }
  <!--  </script>
   <script type="text/javascript">
   $(document).ready(function() {
	    $("#example").DataTable( {
	        "ajax": '../ajax/data/arrays.txt'
	    } );
	} ); -->
   
   </script>
</head>

<body>

     <table border="2">
       <thead>
          <tr> 
             <td>SNO</td>
             <td>ID</td>
             <td>ENAME</td>
             <td>EMAIL</td>
             <td>PASSWORD</td>
             <td>EDIT</td>
             <td>DELETE</td>
          </tr>
        </thead>
        <tbody>
           <c:forEach var="emp" items="${list}" varStatus="index" >
            <tr >
             <td>${index.count}</td> 
             <td>${emp.empno}</td> 
             <td>${emp.ename}</td>
             <td>${emp.email}</td>
             <td>${emp.password}</td>
             <td><a href="deletemprecord?id=${emp.empno}" onclick="return confirmDelete()">delete</a></td>
             <td><a href="updateRecord?id=${emp.empno}">edit</a></td>
            </tr>
           </c:forEach>
        </tbody>
     </table>
     
     <c:if test= "${cp>1}">
      <a href="empfind?id=${cp-1}">prev</a>
      </c:if>
    
      <c:forEach begin="1" end="${tp}" var="i" >
      <c:choose>
         <c:when test= "${cp==i}">
            <c:out value="${i}"></c:out>
         </c:when>
         <c:otherwise>
           <a href="empfind?id=${i}">
           <c:out value="${i}"></c:out></a>
         </c:otherwise>
      </c:choose>

     </c:forEach>
     
     <c:if test="${cp<tp}">
     <a href="empfind?id=${cp+1}">Next</a>
     </c:if>
     
     
      
      <h2 style='color:"blue"'><a href="/employee">+AddEmployee</a></h2>
      
     <h2> <a href="javaScript:showPrint()">Print</a></h2>
      <script type="text/javascript">
         function showPrint(){
             frames.focus();
             frames.print();
         }
         
      </script>
      
     
</body>

</html>