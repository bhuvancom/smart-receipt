<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="invoiceForm" action="/invoice/save">
	<form:hidden path="invoiceId" value="${invoiceForm.invoiceId}" />
	<div class="form-group">
		<label for="exampleInputEmail1">Invoice For</label>
		<form:select required="required" path="user.userId">
			<option value="">Select</option>
			<c:forEach var="user" items="${users}">
				<option value="${user.userId}">${user.name}-${user.email}</option>
			</c:forEach>
		</form:select>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>