<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/user/save" method="POST" modelAttribute="userForm">
	<form:hidden path="userId" value="${userFrom.userId}" />
	<div class="form-group">
		<label for="exampleInputEmail1">Email address</label>
		<form:input required="required" type="email" value="${userForm.email}"
			path="email" class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" />
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Fax</label>
		<form:input type="text" required="required" class="form-control"
			path="fax" value="${userForm.fax}" id="exampleInputPassword1" />
	</div>
	<div class="form-group">
		<label for="exampleCheck1">Name</label>
		<form:input type="text" required="required" class="form-control"
			path="name" value="${userForm.name}" id="exampleCheck1" />

	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>