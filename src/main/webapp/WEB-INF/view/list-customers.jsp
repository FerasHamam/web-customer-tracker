<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>

<html>
	<head>
		<title>Customers List</title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
			<div id="content">
			<input type="button" value="Add Customer"
			class="add-button"
			onclick="window.location.href='showAddCustomerForm'; return false;"
			/>
				<table>
				 <tr>
				 	<th>First Name</th>
				 	<th>Last Name</th>
				 	<th>Email</th>
				 	<th>Action</th>
				 </tr>
				 
				 <c:forEach var="customer" items="${customers}">
				 <c:url var="link" value="/customer/showUpdateCustomerForm">
				 	<c:param name="customerId" value="${customer.id}"></c:param>
				 </c:url>
				 
				 <c:url var="deleteLink" value="/customer/deleteCustomer">
				 	<c:param name="customerId" value="${customer.id}"></c:param>
				 </c:url>
				 <tr>
				 	<td> ${customer.firstName} </td>
				 	<td> ${customer.lastName} </td>
				 	<td> ${customer.email} </td>
				 	<td> <a href="${link}">Update</a> | <a onclick="if(!(confirm('Are you sure you want to delete ${customer.email}?'))) return false;" href="${deleteLink}">Delete</a></td>
				 </tr>
				 </c:forEach>
				</table>
			</div>
	</div>
	</body>
</html>