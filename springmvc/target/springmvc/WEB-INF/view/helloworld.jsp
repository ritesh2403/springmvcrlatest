<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		Student Table
		<tr>
			<th>Name</th>
			<th>Message</th>
		</tr>

		<tr>
			<td>${param.firstname}</td>
			<td>${message}</td>
		</tr>
	</table>
</body>
</html>