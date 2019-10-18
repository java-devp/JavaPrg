<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<style>
.error {
	color: #FF0000
  }
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js">
</script>
<script>
	$(function() {
		$('form[id="employeeform"]').validate({
			rules : {
				empno : 'required',
				ename : 'required',
				email : {
					required : true,
					email : true
				},
				password : 'required',
			    minlength: 5
			},
			messages : {
				empno : 'please enter employee No',
				ename : 'please enter employee name',
				email : 'please enter email',
				password :{
					required:'please enter password',
		            minlength: "Your password must be at least 5 characters long"
				}

			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<h1 style='color: green'>${empreg}</h1>

	<form:form action="employee" method="POST" modelAttribute="empmsg"
		id="employeeform">
		<table>
			<tr>
				<td>EmpNo</td>
				<td><form:input path="empno" /></td>
			</tr>
			<tr>
				<td>Ename</td>
				<td><form:input path="ename" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</form:form>
	&nbsp
	
  <h2><a href="empfind?id=${1}">ViewData</a></h2>
</body>
</html>