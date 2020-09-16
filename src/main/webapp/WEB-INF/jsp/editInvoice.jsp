<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Invoice</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:if test="${not empty message }">
			<div class="alert alert-primary" role="alert">${message }</div>
		</c:if>
		<h4>Invoice Id : ${invoice.invoiceId} for ${invoice.user.name}</h4>

		<div class="row card p-4">
			<h5>Add Product to invoice</h5>
			<form:form class="form-inline" modelAttribute="purchaseForm"
				action="/purchase/save" method="POST">
				<div class="form-group ">
					<label for="product"> Select Product </label>
					<form:select class="form-control" path="product.productId"
						required="required" id="product">
						<option value="">Select One</option>
						<c:forEach var="product" items="${products}">
							<option value="${product.productId}">${product.productId}
								(${product.productDescription})
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group ml-2">
					<label for="quantity"> Quantity </label>
					<form:input path="quantity" class="form-control" type="text"
						value="1" placeholder="Quantity" id="quantity" required="required" />
				</div>
				<form:hidden path="invoice.invoiceId" value="${invoice.invoiceId}" />
				<form:button class="btn btn-primary ml-2" name="add" value="Add"
					type="submit">Add</form:button>
			</form:form>
		</div>
		<br /> <br />

		<div class="row card p-2">
			<h3>Products added :</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product id</th>
						<th>Product description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Amount</th>
						<th>Delete</th>
					</tr>
				</thead>
				<c:set var="totalProduct" value="0" />
				<c:set var="totalAmount" value="0" />
				<tbody>
					<c:forEach var="item" items="${purchases}">
						<tr>
							<td>${item.product.productCode }</td>
							<td>${item.product.productDescription }</td>
							<td>${item.product.productPrice }</td>
							<td>${item.quantity}</td>
							<td>${item.quantity * item.product.productPrice}</td>
							<td><a
								href="/purchase/delete/${item.purchaseId}-${invoice.invoiceId}">Delete?</a></td>
						</tr>
						<c:set var="totalProduct" value="${totalProduct+1}" />
						<c:set var="totalAmount"
							value="${totalAmount + (item.quantity * item.product.productPrice) }" />
					</c:forEach>
				</tbody>
				<tfoot class="tfoot-dark">
					<tr>
						<td colspan="4"><strong>Total Products : ${ totalProduct}</strong></td>
						<td><strong>Total Amount : ${ totalAmount}</strong></td>
						<td></td>
					</tr>
				</tfoot>
			</table>
			<button <c:if test="${totalProduct < 1 }">disabled="disabled"</c:if>
				class="btn btn-primary pull-right" type="button" data-toggle="modal"
				data-target="#send-invoice-modal">Send Invoice</button>
		</div>
	</div>


	<div class="modal fade" id="send-invoice-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Invoice
						${invoice.invoiceId}</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h5>Send Invoice to : ${invoice.user.email} ?</h5>
					<div id="mail">
						<span>To ${invoice.user.name}</span><br /> <span>Products</span>
						<table class="table table-bordered" border="1">
							<thead>
								<tr>
									<th>Product id</th>
									<th>Product description</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Amount</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${purchases}">
									<tr>
										<td>${item.product.productCode }</td>
										<td>${item.product.productDescription }</td>
										<td>${item.product.productPrice }</td>
										<td>${item.quantity}</td>
										<td>${item.quantity * item.product.productPrice}</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot class="tfoot-dark">
								<tr>
									<td colspan="4"><strong>Total Products : ${ totalProduct}</strong></td>
									<td><strong>Total Amount : ${ totalAmount}</strong></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" onclick="sendInvoice()"
						class="btn btn-primary">Send</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function sendInvoice() {
			let invoiceId = ${invoice.invoiceId};
			print();
			window.location.href = '/invoice/send/' + invoiceId;

		}

		function print() {
			let print_div = document.getElementById("mail");
			let print_area = window.open();
			print_area.document.write('<html><body>');
			print_area.document.write(print_div.innerHTML);
			print_area.document.write('</body></html>');
			print_area.document.close();
			print_area.focus();
			print_area.print();
			//print_area.close();
		}
	</script>
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