<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Smart Receipt</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body><jsp:include page="nav.jsp" />
	<div class="container mt-4">
		<div class="row">
			<c:if test="${not empty message }">
				<div class="alert alert-primary" role="alert">${message }</div>
			</c:if>
			<div class="card col-md-12" style="border: 1px solid black">
				<h4>Users</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Fax</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.name}</td>
								<td>${user.email}</td>
								<td>${user.fax}</td>
								<td><a href="user/${user.userId}">Edit</a></td>
								<td><a href="user/delete/${user.userId}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="card col-md-12 mt-5" style="border: 1px solid black">
				<h4>Invoices (Click on invoice id to edit)</h4>
				<table class="table  table-bordered">
					<thead>
						<tr>
							<th>Invoice Id</th>
							<th>User</th>
							<th>Invoice Date</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="invoice" items="${invoices}">
							<tr>
								<td><a href="invoice/${invoice.invoiceId}">${invoice.invoiceId}</a></td>
								<td>${invoice.user.name}</td>
								<td>${invoice.purchasedOn}</td>
								<td><a href="">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>