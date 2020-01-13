<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processform" modelAttribute="student">
	
		First name: <form:input path="firstname" />

		<br><br>
		 Last name: <form:input path="lastname" />

		<br><br>
		Country:<form:select path="country">
		            <form:options items="${student.countryOptions}"></form:options>
		        </form:select>
       <br><br>
		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>











