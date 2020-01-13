
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/resource/css/style.css' />" rel="stylesheet"></link> 
	
	
<title>List Customer</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-CUSTOMER RELATIONSHIP MANAGEMENT</h2>

		</div>

	</div>


	<div id="container">

		<div id="content">
	<input type="button" value="Add Customer" onClick="window.location.href='ShowFormForAdd'"; return="false" class="add-button"></input>

<br><br>

<form action="<c:url value="/customer/ShowFormForSearch"/>">
	<input name="freetext" placeholder="enter your text to search"></input>
	<button>Search</button>
</form>	
<br><br>
				<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>


				<c:forEach var="tempCustomers" items="${customers}">
				
				    <c:url var="updateLink" value="/customer/showformForUpdate">
				        <c:param name="customerId" value="${tempCustomers.id}"></c:param>
				    </c:url>
				    
				    <c:url var="deleteLink" value="/customer/delete">
				        <c:param name="customerId" value="${tempCustomers.id}"></c:param>
				    </c:url>
					<tr>
						<td>${tempCustomers.firstname}</td>
						<td>${tempCustomers.lastname}</td>
						<td>${tempCustomers.email}</td>
						<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" onclick="if (!confirm('Are you sure you want to delete this customer?')) { return false }">Delete</a>
						</td>

					</tr>


				</c:forEach>

			</table>
			
			
		</div>
	</div>
</body>
</html>


